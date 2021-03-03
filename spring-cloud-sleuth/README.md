# Spring Cloud Sleuth & Zipkin

## 배경
마이크로서비스 아키텍쳐 구조에서 하나의 HTTP 호출이 내부적으로 여러 서비스를 경유하며, 병목 발생 시 추적이 어려움.
마이크로서비스 환경의 분산 트랜잭션 및 여러 서비스를 통해 이루어지는 트랜잭션 추적 기능 정의 및 솔루션 적용 예제 작성

## Sleuth
- Trace Id, Span Id 생성 및 Zipkin 서버로 전달
- Zipkin 연동 도와줌

### Trace / Span
분산 시스템 추적에서 핵심적인 개념
- Trace
  - 클라이언트에서 하나의 요청
  - 전체 트랜잭션 시간 추적
- Span
  - Tracing 의 가장 기본 단위
  - 서비스 컴포넌트 간 호출
  - 서비스 구간 시간 추적

## Zipkin
- 분산 로그 추적 시스템
- Spring Sleuth 모듈에서 공식 지원하므로 연동 쉬움
- 트위터 오픈소스
- 구글의 Dapper 기초하여 개발

### 설치 및 실행
```shell
$ curl -sSL https://zipkin.io/quickstart.sh | bash -s
$ java -jar zipkin.ja

// Zipkin UI
$ http://localhost:9411/
```

### 프로토콜 
- HTTP

### 저장소
- In-memory (default)
  - 테스트 환경 적합
- MySQL
  - 소규모 서비스 적합
- Cassandra
- Elastic Search
    
### 로그 형태
```shell
2021-02-28 16:45:27.659  INFO [hello-app,0416701257fb6251,a08e0b59f9bd736b] 88801 --- [nio-8081-exec-5] com.example.web.hello.HelloApi           : hello 8081 !
```

## 테스트 방법
- apache ab 툴 이용하여 부하 테스트

## References
- https://docs.spring.io/spring-cloud-sleuth/docs/current-SNAPSHOT/reference/html/
- https://zipkin.io/pages/quickstart
- https://dzone.com/articles/tracing-in-microservices-with-spring-cloud-sleuth