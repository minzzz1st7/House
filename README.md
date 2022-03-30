# HappyHouse_Backend_부울경_4반_김수진_정민지


# 환경 설정
<!--  -->

# 요구사항 목록
|요구사항 |요구사항 상세 설명|
|------ |-------------|
|로그인, 로그아웃  |  회원데이터베이스에 있는 계정을 확인하고 로그인 |
|회원가입| 회원등록           |
|마이페이지||
|동 검색||
|아파트 검색||
|동네업종 검색||
|상권정보 검색||
|관심지역||
|아파트 검색||
|공지사항| 공지 사항을 등록, 삭제, 수정 할 수 있음 |
|회원관리||

<!--  -->

# Usecase Diagram
<img src = "/uploads/73ba72adb1eff0a29d5cf7de05240ab2/image.png" width="500" height="1000"/>


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



