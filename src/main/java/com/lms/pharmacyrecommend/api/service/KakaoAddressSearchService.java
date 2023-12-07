package com.lms.pharmacyrecommend.api.service;


import com.lms.pharmacyrecommend.api.dto.KakaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpHeaders;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAddressSearchService {

    private final RestTemplate restTemplate;
    private final KakaoUriBuilderService kakaoUriBuilderService;

    @Value("${kakao.rest.api.key}")
    private String kakaoRestApiKey;

    @Retryable(
            exceptionExpression = "{RuntimeException}",
            maxAttempts = 2,
            backoff = @Backoff(delay = 2000)
    )
    public KakaoApiResponseDto requestAddressSearch(String address) {
        //
        if(ObjectUtils.isEmpty(address)) {
            return null;
        }

        URI uri = kakaoUriBuilderService.buildUriBYAddressSearch(address);

        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + kakaoRestApiKey);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

            // kakao api 호출
        return restTemplate.exchange(uri, HttpMethod.GET, entity, KakaoApiResponseDto.class).getBody();

    }

    
    // 복구
    @Recover
    public KakaoApiResponseDto recover(RuntimeException e, String address) {
        log.error("Kakao API 호출 중 에러가 발생했습니다. : {}", e.getMessage());
        return null;
    }

}
