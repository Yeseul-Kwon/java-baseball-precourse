#우아한테크캠프 
##Precourse Week 1 - 숫자 야구 게임
###• 1~9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
***
###프로그래밍 요구사항
1. JDK 8버전에서 실행 가능해야한다.
2. JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.  
   • Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.  
   • 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
3. [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 을 지키면서 프로그래밍한다.
4. indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.  
   • 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
   • 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다. 
5. 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
6. else 예약어를 쓰지 않는다.  
힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.  
   • switch/case도 허용하지 않는다.
7. 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.

***
### 기능 요구사항
1. 상대방(컴퓨터)은 1~9까지의 서로 다른 임의의 수를 3개 선택한다.
2. 플레이어는 상대방의 숫자라고 예상되는 수를 입력한다.
3. 상대방은 플레이어가 입력한 숫자에 대한 힌트를 출력한다.  
   •  같은 수가 같은 자리에 있으면 스트라이크(strike)  
   •  같은 수가 다른 자리에 있으면 볼(ball)  
   • 같은 수가 전혀 없으면 낫싱(nothing)
4. 위 과정을 반복해 상대방이 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다
6. 플레이어가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

***
### 구현해야 할 기능 목록
1. (기능 1) 1~9까지 서로 다른 3개의 정답 숫자 생성  
   • camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
2. (기능 2) 플레이어의 숫자 입력 받기  
   • camp.nextstep.edu.missionutils.Console의 readLine() 활용
3. (기능 3) 플레이어 입력값과 정답을 비교하여 힌트 출력  
   • 입력값과 정답의 각 숫자 비교  
   • 숫자만 일치하면 "볼"  
   • 숫자와 자리가 모두 일치하면 "스트라이크"  
   • 모두 일치하지 않으면 "낫띵"
   • 모든 숫자와 자리가 일치할 때까지 반복  
4. (기능 4) 모든 숫자와 자리가 일치하면 게임 종료  
5. (기능 5) 게임의 완전 종료 여부 확인(1-반복, 2-종료)  
6. (기능 6) 모든 입력 시 잘못된 값을 입력할 경우 IllegalArgumentException 발생  
   • 0을 입력한 경우  
   • 중복된 숫자를 입력한 경우  
   • 숫자의 개수가 3 미만이거나 초과인 경우