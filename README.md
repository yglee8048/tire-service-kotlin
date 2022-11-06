# tire-service
## 목적
- 타이어 관련 서비스를 kotlin 으로 만들어 보자.
- gradle, kotlin dsl 기반 멀티 모듈을 구성해보자.
- 멀티 모듈 서비스에서 적절한 역할과 책임을 설정해보자.

## 구성
- tire-common
  - 공통 모듈. 상수나 Util 등 공통으로 사용할 코드를 작성한다.
  - spring 을 포함해 아무 의존성을 가지고 있지 않다.
  - 최대한 의존성을 추가하지도, 사용하지도 않는다.
- tire-domain
  - 도메인을 책임지는 모듈
  - Spring Data JPA 관련 의존성을 가지고 있다.
  - Entity 와 Repository 코드를 가지고 있다.
  - 최대한 비즈니스 연관성을 배제한다.
  - command(CUD) 이벤트는 최대한 도메인 모듈을 통해 처리한다.
    - 관리 포인트를 일원화 하기 위함
  - query(R) 이벤트는 공통적이고 간단한 것들만 도메인 모듈에서 처리한다.
    - 각 세부 비즈니스와 연관된 복잡한 조회 로직은 각 모듈에서 처리한다. (query-dsl 등)
- tire-erp
  - erp 서비스
    - 전체적인 타이어 속성 및 타이어 재고 관리
    - 고객 정보, 주문 정보 관리
  - common, domain 모듈에 의존한다.
- tire-client
  - client 포탈
    - 로그인 및 회원 정보 관리
    - 타이어 재고 확인 및 주문/주문 관련 조회
  - common, domain 모듈에 의존한다.