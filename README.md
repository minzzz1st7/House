# HappyHouse_Backend_부울경_4반_김수진_정민지


## userMain (/user)

#### - act

1. 이동

   - mvregister : 회원가입 창으로 이동

   - ~~mvError : 에러화면으로 이동~~

   - mvfindpwd : 비밀번호 찾기 창으로 이동

   - mvmypage: 마이페이지 창으로 이동

   - mvModifyPwd: 비밀번호 변경 창으로 이동

2. 동작

   - register : 회원 등록
   - idcheck : db에 입력한 id가 중복되는 것이 있는지 확인
   - findpwd : 해당 아이디의 비밀번호 찾기
   - userinfo: 해당 아이디의 회원 정보 (UserDto) 불러오기
   - login: 로그인 (한번 로그인 하면 세션에 저장)
   - logout: 로그아웃 (세선에 저장된 정보 삭제)
   - ~~list: 모든 회원 정보 출력 (관리자 모드일 때만 접근가능 할 것)~~  
   - modify: 회원 정보 수정 ()
   - modifypwd: 해당 아이디의 비밀번호 수정
   - delete: 회원 탈퇴



#### 1. 회원 등록 

->**로그인 상태**에서는 메인화면으로 이동

- register, idcheck

![image-20220331102651146](asset/image-20220331102651146.png)

![image-20220331103457593](수진 리드미.assets/image-20220331103457593.png)



#### 2. 비밀번호 찾기 

->**로그인 상태**에서는 메인화면으로 이동

- findpwd

![image-20220331103636990](수진 리드미.assets/image-20220331103636990.png)



#### 3. 로그인/로그아웃 

- login, logout

![image-20220331104028044](수진 리드미.assets/image-20220331104028044.png)



#### 4. 마이페이지 

->**로그아웃 상태**에서는 메인화면으로 이동

- userinfo, modify, delete

![image-20220331104104573](수진 리드미.assets/image-20220331104104573.png)

![image-20220331104440549](수진 리드미.assets/image-20220331104440549.png)



#### 5. 비밀번호 찾기 

->**로그인 상태**에서는 메인화면으로 이동

- findpwd

![image-20220331104703194](수진 리드미.assets/image-20220331104703194.png)

<img src="asset/image-20220331104719409.png" alt="image-20220331104719409" style="zoom:33%;" />



#### 6. 메인화면

![image-20220331110359086](수진 리드미.assets/image-20220331110359086.png)

- 로그인 유무에 따라 해당 내용이 달라짐.

![image-20220331110423975](수진 리드미.assets/image-20220331110423975.png)

- 반응형 웹

![image-20220331110613022](수진 리드미.assets/image-20220331110613022.png)



## userInterest (/interest)



# 환경 설정
<!--  -->


          
# 요구사항 목록
|요구사항 |요구사항 상세 설명|
|------ |-------------|
|로그인, 로그아웃  |  회원데이터베이스에 있는 계정을 확인하고 로그인 |
|회원가입| 회원등록           |
|마이페이지|회원 정보 수정, 탈퇴를 할 수 있음|
|동 검색| 고객이 원하는 동별 주택 정보를 검색하면 그 결과를 지도에 표시하고 거래정보 목록을 출력할 수 있음|
|아파트 검색|고객이 원하는 아파트별 주택 정보를 검색하면 그 결과를 지도에 표시하고 거래정보 목록을 출력할 수 있음|
|동네업종 검색| 동네 업종 종류별로 지도에 출력할 수 있음|
|상권정보 검색||
|관심지역| 관심지역을 설정하면 그 지역의 정보를 우선적으로 검색할 수 있음|
|공지사항| 공지 사항을 등록, 삭제, 수정 할 수 있음 |
|주택 실거래가 정보 수집||
|관심지역 정보 수집||
|주변환경 정보 수집||
|회원관리||


# 디렉토리

##### Controller    
>HouseDealServlet.java   
MainServlet.java    
MemberServlet.java  
NoticeMain.java 
userMain.java   
 

##### Dao
>UserDao 
UserDaoImpl 
StoreDao    
StoreDaoImpl    
NoticeDao   
NoticeDaoImpl   
HouseDealDao    
HouseDealDaoImpl    
EnvDao  
EnvDaoImpl  

##### Dto 
>UserDto 
StoreDto    
NoticeDto   
ListParameterDto    
HouseDealDto    
EnvDto  

##### Service
>UserService 
UserServiceImpl 
StoreServcie    
StoreServcieImpl    
NoticeService   
NoticeServiceImpl   
HouseDealService    
HouseDealServiceImpl    
EnvService  
EnvServiceImpl  

##### Util
>PageNavigation  
DBUtil  




# Usecase Diagram
<img src = "/uploads/73ba72adb1eff0a29d5cf7de05240ab2/image.png" width="800" height="2000"/>




# 테이블 설계



# 실행화면


### 공지사항

##### 메뉴에서 공지사항을 클릭하면 게시글 목록이 뜹니다.

<img src = "/uploads/435942be056ea9e1df70317789d0744b/image.png" width="600" height="300"/>


##### 게시글을 등록할 수 있습니다.
: 제목과 내용을 입력하면, 입력된 정보와 글번호, 작성자, 현재 날짜(글 등록일)가 데이터베이스에 추가됩니다.

<img src = "/uploads/c19b0ccbc114183b8c1f450ecbe7eccc/image.png" width="600" height="300"/>

##### 게시글을 등록하면 게시글 목록에서 확인할 수 있습니다. 

<img src = "/uploads/cd5059646917fedbea2a3aeafe0ebe25/image.png" width="600" height="300"/>

##### 글을 삭제할 수 있습니다. 
<img src = "/uploads/b0709c781c497bfa2b3987bab0cfb9fe/image.png" width="600" height="300"/>


##### 글을 수정할 수 있습니다.
<img src = "/uploads/7eba9bf7c56db155585e30b7bb3286d7/image.png" width="600" height="300"/>

##### 수정 후 변경된 목록 화면
<center><img src = "/uploads/5e976a8d8ec988d39791a21f2c530ae4/image.png" width="600" height="300"/></center>



