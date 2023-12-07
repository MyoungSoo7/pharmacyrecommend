package com.lms.pharmacyrecommend.api.service

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.nio.charset.StandardCharsets

@SpringBootTest
class KakaoUriBuilderServiceTest extends Specification {

    private KakaoUriBuilderService kakaoUriBuilderService;

    def setup() {
        kakaoUriBuilderService = new KakaoUriBuilderService();
    }

    def "카카오 uri 빌더 테스트"() {

        given:
        String address = "서울특별시 강남구"
        def charset= StandardCharsets.UTF_8

        when:
        def uri = kakaoUriBuilderService.buildUriBYAddressSearch(address)
        def decodeResult =URLDecoder.decode(uri.toString(), charset)

        then:
        decodeResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울특별시 강남구"

    }

}
