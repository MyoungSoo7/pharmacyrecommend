# 가까운 약국 3개 추천
## [활용기술] <br>
* **Java 17** <br>
* **SpringBoot 3.2**<br>
* mariadb<br>
* redis<br>
* spring-retry<br>
* spring-data-jpa<br>
* spring-data-redis<br>
* mustache<br> 
* docker<br>
* docker-compose<br>

## [ERD]<br>
![image](https://github.com/MyoungSoo7/pharmacyrecommend/assets/13523622/80e9bcc1-0b6b-49f1-9f42-fae832375626)<br>

## [작업내용]<br>
* 카카오 지도검색 API로 가까운 약국 3개 찾기(성북구만 지원 - Haversine formula 길찾기 활용)
* 도메인 주도 설계(DDD - Direction, Pharmacy)
* Redis(약국데이터 캐싱)
* RetryConfig적용(API 호출시 지연시 잠시 대기 후 재시도)
* 지도위치 및 로드 뷰 제공
  
## [테스트]<br>
* API테스트 



