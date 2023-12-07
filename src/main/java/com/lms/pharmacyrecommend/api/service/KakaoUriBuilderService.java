package com.lms.pharmacyrecommend.api.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class KakaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    private static final String KAKAO_LOCAL_CATEGORY_SEARCH_URL = "https://dapi.kakao.com/v2/local/search/category.json";


    public URI buildUriBYAddressSearch(String address) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL).queryParam("query", address);
        URI uri = builder.build().encode().toUri();

        log.info("[KakaoUriBuilderService buildUriBYAddressSearch] address :{}, uri : {}",address, uri);
        return uri;
    }

    public URI buildUriByCategorySearch(String category, double x, double y, double radius) {
        double radiusInMeter = radius * 1000;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_CATEGORY_SEARCH_URL)
                .queryParam("category_group_code", category)
                .queryParam("x", x)
                .queryParam("y", y)
                .queryParam("radius", radiusInMeter)
                .queryParam("sort", "distance");
        URI uri = builder.build().encode().toUri();

        log.info("[KakaoUriBuilderService buildUriByCategorySearch] uri : {}",  uri);
        return uri;
    }

}
