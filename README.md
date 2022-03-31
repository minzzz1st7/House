# HappyHouse_Backend_부울경_4반_김수진_정민지

          
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


![image](/uploads/1327d00eb3339debb1936b64518897ae/image.png)


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

![image-20220331102651146](/uploads/bd41df37a5f473674e121ee4f61a1960/image-20220331102651146.png)

![image-20220331103457593](/uploads/962a0369a1014ede81dece32ac0e2a47/image-20220331103457593.png)




#### 2. 비밀번호 찾기 

->**로그인 상태**에서는 메인화면으로 이동

- findpwd

![image-20220331103636990](/uploads/ac7d9853453acd2c677c1a50a1bb3d62/image-20220331103636990.png)



#### 3. 로그인/로그아웃 

- login, logout

![image-20220331104028044](/uploads/20222558c5956a1331f508d83d2dfa6a/image-20220331104028044.png)



#### 4. 마이페이지 

->**로그아웃 상태**에서는 메인화면으로 이동

- userinfo, modify, delete

![image-20220331104104573](/uploads/0ce1ac4ffdd8f3cca947cd7f281711a7/image-20220331104104573.png)

![image-20220331104440549](/uploads/357d56ebb2e6a19abc3f516ffece3374/image-20220331104440549.png)



#### 5. 비밀번호 찾기 

->**로그인 상태**에서는 메인화면으로 이동

- findpwd

![image-20220331104028044](/uploads/20222558c5956a1331f508d83d2dfa6a/image-20220331104028044.png)

![image-20220331104104573](/uploads/0ce1ac4ffdd8f3cca947cd7f281711a7/image-20220331104104573.png)


#### 6. 메인화면

![image-20220331110512493](/uploads/34b6c087e3eaee3d9a9f8dfd006b7a7d/image-20220331110512493.png)

- 로그인 유무에 따라 해당 내용이 달라짐.

![image-20220331110423975](/uploads/a8ec8a41bfba8f725ecf3593b08b2c78/image-20220331110423975.png)

- 반응형 웹

![image-20220331110359086](/uploads/0ddcbb2e5ae5aa09213ca0b56154bac0/image-20220331110359086.png)

## 아파트 실거래가 검색
#### 1. 아파트 실거래가 동으로 검색

![image](/uploads/207978012c16c94c65401916f44cfb0a/image.png)

#### 2. 아파트 실거래가 아파트 주소로 검색

![image](/uploads/62bdbd4a13bf4823c52de2e370da44c5/image.png)




## 공지사항 (/Notice)
#### - act

1. 이동

   - myNotice : 공지 목록 창으로 이동

   - NoticeinsertForm : 게시 글 등록 창으로 이동

   - myAddNotice : 공지 목록 창으로 이동


2. 동작

   - selctAll : 모든 게시글을 불러오기
   - Noticeinsert : 글 제목과 내용을 등록
   - view : 글 제목을 클릭하면 게시글 ID와 일치하는 게시글 제목, 내용 불러오기
   - Noticeupdate: 게시글 수정하기
   - Noticedelete: 게시글ID 와 일치하는 게시글 찾아서 삭세하기
 

#### 1. 메뉴에서 공지사항을 클릭하면 게시글 목록이 뜹니다.
- myNotice
![image](/uploads/28e0cab6257e247b04679bbb81fb9e0f/image.png)

#### 2. 게시글을 등록할 수 있습니다.
- Noticeinsert
![image](/uploads/e7aff4ee71291e3a314dc3ed155837c6/image.png)

#### 3. 제목을 누르면 게시글 확인 할 수 있습니다. 

![image](/uploads/999eb4dfbdd765010c95d480afc7d61e/image.png)


#### 4. 게시글을 삭제할 수 있습니다. 
- Noticedelete
![image](/uploads/9d51bade82b3d333de55daefaa5ae5ca/image.png)

#### 5. 게시글을 수정할 수 있습니다.
- Noticeupdate

![image](/uploads/dc0867c2ce456f5a8a3ac0f22374d640/image.png)


