## 개요
저희가 앱을 구현하게 된 이유는 배달 수요와 공급의 불균형, 수수료의 과도한 인상으로 배달비가 높아져
개인이 부담하는 배달비를 가까운 사람들과 공동 주문을 통해 줄여보고자 이 프로젝트를 진행하게 되었습니다

## 데모 앱 실행
앱은 Github Main에 올라와있는 파일을 다운로드 받으시면 안드로이드 스튜디오에서 실행할 수 있습니다.

## 시나리오
1. 어플 로딩이 끝나면 회원가입 화면이 나타나게됩니다.
2. 회원가입 (아이디 비밀번호 영숫자 혼합 6자 이상으로 해야합니다.)
3. 로그인 성공시 음식 종류를 고르는 화면이 나오는데 짜장면 아이콘인 '중식'을 클릭합니다.
4. 클릭시 현재 생성도어있는 팀 리스트가 나타나게되고(리스트가 없을 시 빈칸입니다.) 하단에 팀 만들기 버튼이 있습니다.
5-1 팀 만들기 버튼 실행시 공동 주문 할 음식점과 시간, 배달 수령 장소를 선택하고 주문할 음식의 개수를 선택합니다.
    이후 '등록' 버튼을 누르게 되면 팀 리스트가 생성이 되고 곧바로 '결제'버튼을 눌러 결제화면으로 넘어갑니다.
 -2 결제는 부트페이 API를 이용하여 네이버 페이로 결제하시면 됩니다.
6-1 팀 참가는 3번이나 4번 팀 리스트를 클릭할 시 공동 주문 할 음식점과 시간, 배달수령 장소가 고정된 화면에서 
    주문할 음식의 개수를 선택합니다. 팀 참가화면에서는 따로 '등록'버튼을 누를 필요없이 '결제'버튼을 눌러 결제화면으로 넘어가면됩니다.
 -2 결제는 5-2와 마찬가지로 부트페이 API를 이용하여 네이버 페이로 결제하시면 됩니다.
7. 결제완료시 Firebase에 receipt형태로 저장되며 추후 부분취소함수와 연동됩니다. 

## 파일 설명
BootpayValueHelper.java:
 부트페이 연동을 위한 도구
Chamga.java:
 숫자 증감, 파이어베이스에 데이터 보내기, 결제금액 값 결제화면으로 넘기기
CustomAadapter.java: 
 리사이클러뷰 아이템별 클릭시 chamga.java로 넘어가고 그에 해당하는 데이터가 넘어가는 기능
LoginActivity.java:
 로그인 기능
MainActivity.java: 
 음식 카테고리 선택기능, 파이어베이스에 저장된 팀을 보여주는 리사이클러뷰를 활용한 단축형 팀리스트, 로그아웃 기능
menu3.java: 
 chamga.java에서 참가할 때 파이어베이스에 등록할 데이터 set
NativeActivity.java:
 결제 기능
Option.java: 
 숫자 증감, 스피너 기능, 파이에베이스에 데이터 보내기, 결제금액 값 결제화면으로 넘기기
SignUpActivity.java:
 회원 가입 기능
SplashActivity.java:
 어플 로딩화면(오프닝)
Teammake.java:
 파이어베이스에 저장된 데이터를 불러와 리스트로 나타내는 기능
User.java:
 Option.java에서 등록할 때 파이어베이스에 필요한 변수 세트



menu.java & menu2.java & WebAppActivity: 
 시행착오를 거치며 생성된 파일. 다른 파일들과 연동되어 있어서 삭제하면 데이터가 사라질 우려가 있어 제거하지 않았음.
