# 나이스평가정보 - 사전과제
## 개발환경
* Java 1.8
* Spring Boot 2.3.4 (web)
* Mybatis 2.1.3
* H2
* opencsv
## 빌드 및 실행
Gradle Wrapper를 사용 실행 방법
* build
``` 
gradlew build
```
* run
``` 
gradlew bootRun
```
## 문제
* ①	API 명세서 작성
* ②	데이터파일(.csv)의 각 레코드를 데이터베이스에 저장하는 API 개발
* ③	일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력하는 API 개발
* ④	월 인원수 평균이 가장 낮은 역 명과 인원수를 출력하는 API 개발
* ⑤	월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력하는 API 개발

## API 명세서
* 데이터파일(.csv)의 각 레코드를 데이터베이스에 저장하는 API 개발
> GET http://localhost:8080/v1.0/file?file=data.csv
>| Parameter | Response |
>|-----------|------------------|
>| file=[String] (default=data.csv) 입수대상 파일명 | code=[String] 상태코드(0:정상, 1:파일입수오류, 2:파일오류 등) |
>|  | status=[String] 상태코드명(sucess, Not Found File, Invalid File 등) |
>|  | data=[List] (count(Decimal):저장 Row) |
```
{"code":"0","data":{"Count":2592},"status":"sucess"}
```

* 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력하는 API 개발
> GET http://localhost:8080/v1.0/api1?count=10
>| Parameter | Response |
>|-----------|------------------|
>| count=[Int] (default=10) 조회건수 |  code=[String] 상태코드(0:정상, 1:파일입수오류, 2:파일파싱오류 등) |
>|  | status=[String] 상태코드명 등) |
>|  | data=[List] (s_name(String):지하철역명칭, amount(Decimal):인원수) |
```
{"code":"0","data":[{"amount":151591,"s_name":"강남"},{"amount":126087,"s_name":"잠실(2)"},{"amount":124515,"s_name":"홍대입구"},{"amount":103756,"s_name":"신림"},{"amount":93727,"s_name":"구로디지털단지"},{"amount":90052,"s_name":"고속터미널(3)"},{"amount":89094,"s_name":"삼성"},{"amount":87372,"s_name":"신도림"},{"amount":82650,"s_name":"서울역(1)"},{"amount":78355,"s_name":"서울대입구"}],"status":"sucess"}
```

* 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력하는 API 개발
> GET http://localhost:8080/v1.0/api2?count=1
>| Parameter | Response |
>|-----------|------------------|
>| count=[Int] (default=10) 조회건수 |  code=[String] 상태코드(0:정상, 1:파일입수오류, 2:파일파싱오류 등) |
>|  | status=[String] 상태코드명 등) |
>|  | data=[List] (s_name:지하철역명칭(String), amount(Decimal):인원수) |
```
{"code":"0","data":[{"amount":37201,"s_name":"둔촌오륜"}],"status":"sucess"}
```

* 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력하는 API 개발
> GET http://localhost:8080/v1.0/api3?count=1
>| Parameter | Response |
>|-----------|------------------|
>| count=[Int] (default=10) 조회건수 |  code=[String] 상태코드(0:정상, 1:파일입수오류, 2:파일파싱오류 등) |
>|  | status=[String] 상태코드명 등) |
>|  | data=[List] (s_name:지하철역명칭(String), amount(Decimal):인원수) |
```
{"code":"0","data":[{"amount":1350567,"s_name":"강남"}],"status":"sucess"}
```
