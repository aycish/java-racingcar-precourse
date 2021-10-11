# 자동차 경주 게임
## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 / 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하려는 자동차의 이름을 함께 출력할 수 있다.
- 자동차의 이름을 읿력받을 땐, 쉼표(,)를 기준으로 구분하며, 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후, random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후, 누가 우승했는지 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우, "[ERROR]"로 시작하는 에러 메세지를 출력 후, 입력을 다시 받는다.

## 제약 사항
- Application.main으로 시작한다.
- JDK 8에서 동작 가능해야한다.
- nextstep.utils 패키지에서 제공하는 Randoms, Console API를 활용해야한다.
- 주어진 ApplicationTest의 2개의 Test Case가 성공해야한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다. ([링크](https://naver.github.io/hackday-conventions-java/))
- indent depth는 2를 초과하면 안된다.
- steam api는 사용하지 못하지만, 람다는 가능하다
- else 예약어를 사용하지 않는다.
- 함수(메소드)의 길이가 10라인을 넘지 않도록 구현한다.
- 일급 컬렉션을 활용해 구현한다.
- 모든 원시값과 문자열을 포장한다.
- 도메인 로직의 단위 테스트를 구현한다.

## 입출력 분석
### 입력
1. 자동차 이름 입력
    - 사용자가 1~5자리의 자동차 이름을 입력할 수 있다.
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
```
2. 자동차의 전진을 시도할 횟수를 입력할 수 있다.
    - 시도 횟수의 제한되는 값은 존재하지 않아보인다.
    - 입력한 횟수만큼 각 자동차는 전진 여부를 random한 숫자를 생성해 판단하고, 전진한다.
    - 매 시기마다 각 자동차 별로 위치 정보를 출력한다.
```
시도할 회수는 몇회인가요?
5

실행결과
...
```

### 출력
1. 실행 결과 출력
    - 사용자가 입력한 시도 횟수만큼 각 자동차 별, 해당 시기의 위치 정보를 '-'로 출력한다.
```
실행 결과
pobi : -
crong :
honux : -

pobi : --
crong :-
honux : --

pobi : ---
crong :--
honux : ---
...
```

2. 최종 우승자 출력
    - 정해진 횟수만큼 모두 시행한 뒤, 가장 많이 전진한 자동차를 이름과 함께 출력하여 우승자를 알려준다.
    - 우승자가 한 명 이상인 경우, 쉼표(,)로 이름을 구분해 출력한다.
```
최종 우승자는 pobi, honux 입니다.
```

## 게임 흐름 분석
### 게임 순서
1. 경주를 시작할 자동차의 이름을 사용자로부터 입력을 받는다.
   - 사용자로부터 쉼표로 구분된 자동차의 이름을 입력받는다.
   - 이름들을 검증한 뒤, 검증 결과에 따라 에러메세지 출력한다.
   - 입력받은 내용을 토대로, 자동차의 그룹을 생성한다.
2. 시도할 횟수를 입력받는다.
   - 입력받은 횟수 만큼, 자동차들은 전진 여부를 판단한 뒤, 전진할 예졍이다.
3. 자동차의 전진
   - 각 자동차별로 전진 여부를 판단할 수 있게 랜덤한 숫자를 생성한다.
   - 생성한 숫자를 토대로, 전진 여부를 판단한다.
   - 생성한 숫자가 4 이상이라면 전진한다.
   - 전진한 뒤, 전진 결과를 출력한다.
   - 시행 횟수만큼 반복한다.
4. 우승자 출력
    - 자동차 그룹중, 가장 전진을 많이한 자동차들을 출력한다.
    - 공동 우승자가 존재하는 경우, 쉼표로 구분한다.
### 게임 흐름 예제
```
경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)
pobi,crong,honux
시도할회수는몇회인가요?
5

실행결과
pobi:-
crong:
honux:-

pobi:--
crong:-
honux:--

pobi:---
crong:--
honux:---

pobi:----
crong:---
honux:----

pobi:-----
crong:----
honux:-----

최종우승자는pobi,honux입니다.
```
## 구현할 기능 정리
### 게임 관련
- 자동차 생성
    - 생성 시에 이름을 부여 받는다.
- 숫자 생성
    - 전진 여부를 판단할 숫자를 Randoms를 활용해 생성한다.
    - 생성할 숫자의 범위는 0~9이다.
- 자동차 전진 여부 판단
    - 숫자를 전달 받고, 해당 숫자가 4이상이면 전진, 아니라면 전진하지 않도록 판단한다.
- 자동차 전진
    - 전진 여부에 따라 전진한다.
- 우승자 선별
    - 마지막 시행 후, 자동차들의 위치에 따라 우승자를 선별한다.
- 자동차 그룹 생성
    - 입력받은 자동차 이름들을 토대로 자동차 그룹을 생성한다.
- 사용자 입력 검증
    - 입력받은 자동차 이름을 검증한다.
    - 입력받은 시행 횟수를 검증한다.
### 게임 뷰어(가칭)
- 자동차들의 이름을 입력받는다.
    - 1~5자리의 이름을 입력받는다.
- 시행 횟수를 입력받는다.
    - 숫자를 입력받는다.
- 시행 결과를 출력한다.
    - 매 횟수마다 전진 결과를 자동차 별로 출력한다.
    - "{차이름} : -" 형태로 출력
- 우승자를 출력한다.
    - 전달받은 우승자들을 출력한다.
    - 공동 우승자가 존재하는 경우, 쉼표로 구분하여 출력한다.
    - "{차이름1}, {차이름2}" 형태로 출력

