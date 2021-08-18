## - 라이징테스트(배달의 민족) 개발일지 1일차 -

### <2021.08.14>
+ 기획서 작성... 70% - 서버개발자(리브)와의 커뮤니케이션을 통해 함께 작성, 추후에 수정가능성 있음
+ 프로젝트 템플릿 구성 중... 50%
+ 스플래쉬 화면 구성... 100%
+ 첫 화면 구성 중... 60%
+ 메인화면 구성 중... 10%
+ my배민 화면 구성 중... 5%
+ 액티비티 전환 애니메이션 적용(baseactivity에 적용해서 각 activity에서 상속해서 사용) 
  + slide_in_right 구현 O  
  + slide_out_right 구현 X
    + 구현 중에 오류 발견 추후에 다시 시도할 예정이다.

*<내일 할 리스트>*
  + my배민 화면 구현하기
  + 로그인 화면, 회원가입화면 구현하기
  + recyclerview gridlayoutmanager사용해서 메인화면 구성하기
  + viewpager 사용해서 배민 광고배너 화면 메인화면에 구성하기
***
## - 라이징테스트(배달의 민족) 개발일지 2일차 -

### <2021.08.15>
+ 기획서 작성... 70% - 서버개발자(리브)와의 커뮤니케이션을 통해 함께 작성, 추후에 수정가능성 있음
+ 프로젝트 템플릿 구성 중... 55%
+ 스플래쉬 화면 구성... 100%
+ 첫 화면 구성 중... 60%
+ 메인화면 구성 중... 50%
  + viewpager 구현 O
  + recyclerview gridlayoutmanager 구현 O
+ my배민 화면 구성 중... 70%
  + 비로그인시 화면 구성 중인데 scrollview 하단이 짤리는 이슈 발생 / marginbottom 문제인지 정확히 몰라서 내일 해결해 볼 예정이다. 
  + 로그인시 화면 X
+ 로그인 화면, 회원가입 화면... 50%

+ 액티비티 전환 애니메이션 적용(baseactivity에 적용해서 각 activity에서 상속해서 사용) 
  + slide_in_right 구현 O  
  + slide_out_right 구현 X 
    + fromxDelta 값을 변경해서 잠시 구현되었으나 메인화면의 viewpager의 쓰레드와 충돌이 일어나서 그런지 다시 원상태로 돌아왔다. 이부분은 다음에 해결 할 예정이다.

+ **<서버개발자와의 소통>**
  + 클라이언트는 실행화면을 동영상으로 공유하여서 진행상황을 공유하였고, 서버개발자는 서버구축을 완료하였고 db설계 중이라고 하였다. 서버 도메인을 알려주었고, 자동완성 api기능을 추가할지 말지에       관하여 토론하였다. 해당사항은 우선순위에 밀린다고 판단하여서 추후에 시간이 날시 기획서에 반영하고 개발할 예정으로 결론지었다. 

+ **<내일 할 리스트>**
  + 로그인화면, 회원가입 화면 구현하기
  + 로그인, 소셜로그인(카카오) api 엮어서 로그인하기
  + my배민 화면(로그인시) 구현하기
  + 메인화면 구현하기(Floating action button)
  + 시작화면 만들고 coorinatorlayout 적용해보기
***
## - 라이징테스트(배달의 민족) 개발일지 3일차 -

### <2021.08.16>
+ 기획서 작성... 70% - 서버개발자(리브)와의 커뮤니케이션을 통해 함께 작성, 추후에 수정가능성 있음
+ 프로젝트 템플릿 구성 중... 55%
+ 스플래쉬 화면 구성... 100%
+ 첫 화면 구성 중... 65%
+ 메인화면 구성 중... 50%
  + viewpager 구현 O
  + recyclerview gridlayoutmanager 구현 O
+ my배민 화면 구성 중... 70%
  + 비로그인시 화면 구성 중인데 scrollview 하단이 짤리는 이슈 발생 / marginbottom 문제인지 정확히 몰라서 내일 해결해 볼 예정이다. -> 해결 완료! layout의 height 설정 오류로 인하여 발생한 문제     였다.
  + 로그인시 화면 X
+ 로그인 화면, 회원가입 화면... 80%
+ 주소 검색 화면... 80%

+ 액티비티 전환 애니메이션 적용(baseactivity에 적용해서 각 activity에서 상속해서 사용) 
  + slide_in_right 구현 O  
  + slide_out_right 구현 X 
    + fromxDelta 값을 변경해서 잠시 구현되었으나 메인화면의 viewpager의 쓰레드와 충돌이 일어나서 그런지 다시 원상태로 돌아왔다. 이부분은 다음에 해결 할 예정이다.

+ **<서버개발자와의 소통>**
  + 클라이언트는 실행화면을 동영상으로 공유하여서 진행상황을 공유하였고, 서버개발자는 디비설계를 거의 완료하였고, 회원가입할때 하는 휴대폰인증 api 개발 막바지라는 상황을 공유해주었다.

+ **<내일 할 리스트>**
  + 로그인, 소셜로그인(카카오) api 엮어서 로그인하기
  + my배민 화면(로그인시) 구현하기
  + 메인화면 구현하기(Floating action button)
  + 시작화면 만들고 coorinatorlayout 적용해보기
***
## - 라이징테스트(배달의 민족) 개발일지 4일차 -

### <1차 피드백>
+ 문제1 : 나는 레이아웃을 짤 때 한 화면을 다 만들고 넘어가는 것이 아닌 중구난방식으로 여러 레이아웃을 조금씩 만드는 방식을 했었다. 그래서 이과정에서 피드백을 받았다. 
  + 피드백 : 퍼블리싱 디테일을 먼저 다잡고 뒤에 작업을 하는 것이 좋고, 하나의 레이아웃 기본틀을 잡으면 뒤에는 해당 레이아웃을 활용하면 시간이 줄어들어서 효율성, 생산성 측면에서 좋다. 

+ 문제2 : 실제 어플과 조금씩 차이가 나는 부분이 있다.
  + 피드백: 테스트에 있어서 그 부분은 똑같이 구현하는것이 좋고 높은 점수를 받을 수 있다. 고쳐야할 부분 : 시작화면 layout의 간격과 margin, loadingdialog animation, custom edittextview, 회원가입 화면의 디테일, tablayout을 viewpager와 recyclerview와 연동! 

### <2주차 2차 피드백 전까지 해야 할 목표>
+ 음식점 리스트 / 상세 정보 조회, 장바구니, 주문하기, 주문 내역까지!

### <2021.08.17>
+ 기획서 작성... 70% - 서버개발자(리브)와의 커뮤니케이션을 통해 함께 작성, 추후에 수정가능성 있음
+ 프로젝트 템플릿 구성 중... 55%
+ 스플래쉬 화면 구성... 100%
+ 첫 화면 구성 중... 65%
+ 메인화면 구성 중... 50%
  + viewpager 구현 O
  + recyclerview gridlayoutmanager 구현 O
+ my배민 화면 구성 중... 70%
  + 비로그인시 화면 구성 중인데 scrollview 하단이 짤리는 이슈 발생 / marginbottom 문제인지 정확히 몰라서 내일 해결해 볼 예정이다. -> 해결 완료! layout의 height 설정 오류로 인하여 발생한 문제     였다.
  + 로그인시 화면 X
+ 로그인 화면, 회원가입 화면... 80%
+ 주소 검색 화면... 80%
+ 액티비티 전환 애니메이션 적용(baseactivity에 적용해서 각 activity에서 상속해서 사용) 
  + slide_in_right 구현 O  
  + slide_out_right 구현 X 
    + fromxDelta 값을 변경해서 잠시 구현되었으나 메인화면의 viewpager의 쓰레드와 충돌이 일어나서 그런지 다시 원상태로 돌아왔다. 이부분은 다음에 해결 할 예정이다.
+ 휴대폰번호 인증번호 발송 api 반영 여부 O
+ 휴대폰번호 인증 api 반영 X => api 통신은 성공하였으나 인증번호와 휴대폰번호를 보냈음(로그를 통해 확인)에도 휴대폰 인증번호를 먼저 요청해달라는 code가 response로 오게되었다. postman에서는   성공적으로 인증되었는데 로컬에서 안되는 문제인거 같다. 서버개발자와 소통을 통해 전화번호값으로 임시로 저장된 인증번호를 찾을때 null값이면 해당 response가 오게된다는 것을 알게되었고, 그래서 여러 방법을 시도해보았지만 해결되지 않음. 해결방안을 모색 중이다.
 
+ **<서버개발자와의 소통>**
  + 휴대폰인증번호 발송 api는 연동을 성공하였으나 휴대폰번호를 인증하는 api연동에서 오류가 발생하였다. 이 부분에 관하여서 서로 커뮤니케이션하였고, 인증번호 발송 response에 발송번호를 넣어서 클     라이언트에서 값을 비교해서 처리하는 방식으로 바꾸는 것으로 결론지었다. 12시 이후에 테스트가 가능해서 추후에 테스트 해볼 예정이다.

+ **<내일 할 리스트>**
  + 회원가입, 로그인, 소셜로그인(카카오) api 엮어서 로그인하기
  + my배민 화면(로그인시) 구현하기
  + 메인화면 구현하기(Floating action button)
  + 시작화면 만들고 coorinatorlayout 적용해보기
  + edittext custom 하기
***
## - 라이징테스트(배달의 민족) 개발일지 5일차 -

### <1차 피드백>
+ 문제1 : 나는 레이아웃을 짤 때 한 화면을 다 만들고 넘어가는 것이 아닌 중구난방식으로 여러 레이아웃을 조금씩 만드는 방식을 했었다. 그래서 이과정에서 피드백을 받았다. 
  + 피드백 : 퍼블리싱 디테일을 먼저 다잡고 뒤에 작업을 하는 것이 좋고, 하나의 레이아웃 기본틀을 잡으면 뒤에는 해당 레이아웃을 활용하면 시간이 줄어들어서 효율성, 생산성 측면에서 좋다. 

+ 문제2 : 실제 어플과 조금씩 차이가 나는 부분이 있다.
  + 피드백: 테스트에 있어서 그 부분은 똑같이 구현하는것이 좋고 높은 점수를 받을 수 있다. 고쳐야할 부분 : 시작화면 layout의 간격과 margin, loadingdialog animation, custom edittextview, 회원가입 화면의 디테일, tablayout을 viewpager와 recyclerview와 연동! 

### <2주차 2차 피드백 전까지 해야 할 목표>
+ 음식점 리스트 / 상세 정보 조회, 장바구니, 주문하기, 주문 내역까지!

### <2021.08.18>
+ 기획서 작성... 75% - 휴대폰번호 인증 api를 없애고 클라이언트에서 처리하는 방식으로 바꾸어서 api시트에서 삭제하였고, 기획서에 반영하였다.
+ 프로젝트 템플릿 구성 중... 55%
+ 스플래쉬 화면 구성... 100%
+ 첫 화면 구성 중... 65%
+ 메인화면 구성 중... 50%
  + viewpager 구현 O
  + recyclerview gridlayoutmanager 구현 O
+ my배민 화면 구성 중... 70%
  + 비로그인시 화면 구성 중인데 scrollview 하단이 짤리는 이슈 발생 / marginbottom 문제인지 정확히 몰라서 내일 해결해 볼 예정이다. -> 해결 완료! layout의 height 설정 오류로 인하여 발생한 문제     였다.
  + 로그인시 화면 X
+ 로그인 화면, 회원가입 화면... 90% - edittext custom 하기 O, 나머지 사소한 디테일만 고치면 됨.
+ 주소 검색 화면... 80%
+ 액티비티 전환 애니메이션 적용(baseactivity에 적용해서 각 activity에서 상속해서 사용) 
  + slide_in_right 구현 O  
  + slide_out_right 구현 X 
    + fromxDelta 값을 변경해서 잠시 구현되었으나 메인화면의 viewpager의 쓰레드와 충돌이 일어나서 그런지 다시 원상태로 돌아왔다. 이부분은 다음에 해결 할 예정이다. => 해결완료! 각 animation들의 duration값을 같게 해주었고, fromXDelta와 toXDelta의 값을 수젛하였다.
+ 휴대폰번호 인증번호 발송 api 반영 여부 O
+ 휴대폰번호 인증 api 반영 X => api 통신은 성공하였으나 인증번호와 휴대폰번호를 보냈음(로그를 통해 확인)에도 휴대폰 인증번호를 먼저 요청해달라는 code가 response로 오게되었다. postman에서는   성공적으로 인증되었는데 로컬에서 안되는 문제인거 같다. 서버개발자와 소통을 통해 전화번호값으로 임시로 저장된 인증번호를 찾을때 null값이면 해당 response가 오게된다는 것을 알게되었고, 그래서 여러 방법을 시도해보았지만 해결되지 않음. 해결방안을 모색 중이다. -> 해결 완료! 클라이언트에서 값을 비교해서 처리하였고, 테스트 성공하였다.
+ 이메일 중복체크 api 반영 여부 O
+ 회원가입 api 반영 여부 O
+ 로그인 api 반영 여부 O

+ **<서버개발자와의 소통>**
  + 현재 진행상황에 관하여서 서로 공유하였고, 서버개발자분은 가게 리스트 api와 주소 조회 api를 목표로 하셨고, 나는 주소 조회 및 설정을 위한 카카오지도 SDK 연동, GPS로 좌표값 가져오기를 목표로 하였다. 그리고  기본 주소를 어디로 할지 정하였고, 중간중간마다 클라이언트인 나는 response의 error message에 대해서 모르는부분을 물어보았고, 서버분은 클라이언트에서 처리가능한 부분을 물어보셨다. 서로의 분야에 대해서 미숙하다 보니 대화를 통해서 문제에 대해서 해결해 나가고 있다. 이런 부분에서 서로간의 커뮤니케이션이 중요하다는 것을 느낀다.

+ **<내일 할 리스트>**
  + 주소 조회 및 설정을 위한 카카오지도 SDK 연동, GPS로 좌표값 가져오기
  + 소셜로그인(카카오) api 사용하기
  + my배민 화면(로그인시) 구현하기
  + 메인화면 구현하기(Floating action button)
  + 시작화면 만들고 coorinatorlayout 적용해보기
***
