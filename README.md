
### 프로젝트 구성

---
![class-diagram](./class-diagram.png)

![structure](./structure.png)

![flowchart](./flowchart.png)


### 문제정의

---

- 공연 티켓 예매 시스템 특성상 특정 시간에 트래픽이 몰린다.
    - 인기가 많은 공연의 경우, 공연 예매가 열림과 동시에 수많은 공연 예매 요청이 들어오기 때문이다.
- 한꺼번에 몰리는 트래픽을 안정적으로 처리할 수 있는 시스템을 구축해야 한다.

### 해결 방식

---

- 트래픽 정도에 따라서 동적으로 인스턴스 수를 늘려주는 Autoscaling이 가능하도록 만든다.
- Kubernetes의 HPA를 이용한 Autoscaling
    - HPA를 사용하여 CPU 사용률 등을 체크하여 Pod의 개수를 동적으로 Scaling한다.
- Autoscaling 과정에서 pod의 개수를 늘이고 줄이는 과정에서 트래픽 누수가 발생할 수 있어 container probes를 통해 안정적인 트래픽 처리를 한다.
    
    > Deployment.yaml 설정값
    > 
  
    
    - terminationGracePeriodSeconds : 60초 지나면 SIGKILL signal 보내게 한다.
    - initialDelaySeconds : 초반 4초가 지나고 probes를 시작하게 한다.
    - periodSeconds : 10초 단위로 컨테이너의 헬스 체크를 한다.
    - failureThreshold : probe가 실패할 수 있는 횟수를 3으로 설정한다.
    - timeoutSeconds : probe가 시간 초과가 되고 컨테이너가 실패한 것으로 간주되는 비활성 시간으로 3초로 설정한다.
    - lifecycle에서 exec handler를 사용해 컨테이너가 종료되기 전에 30초간 정지하게 한다.

### 테스트 결과

---

- JMeter로 스레드 그룹을 생성해 부하테스트를 진행한 결과 접속자 수 변화에 따라 pod 수가 자동으로 증감함을 확인했다.
![demo](./demo.gif)


### 테스트방식
---

용량성
- 150명의 사용자가 각각 공연 티켓 예매 페이지에서 티켓을 예매할 시, 서버의 CPU 사용률, 메모리 사용량 및 응답시간을 측정

- 응답시간 : 150명의 사용자가 연속으로 공연 좌석 예매 요청 시, 평균 응답시간 측정
   -> Apache JMeter 사용

- success criteria: 평균 응답시간 3초 이내
