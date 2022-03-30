# HappyHouse_Backend_부울경_4반_김수진_정민지


### 환경 설정:


---
# 공지사항

### - 메뉴에서 공지사항을 클릭하면 게시글 목록이 뜹니다.

#### - 웹페이지
![image](/uploads/435942be056ea9e1df70317789d0744b/image.png)

#### - 서버코드 
![image](/uploads/7ba2c7ae8b301656d7142904aec1e1c1/image.png)

### - 게시글을 등록할 수 있습니다.
: 제목과 내용을 입력하면, 입력된 정보와 글번호, 작성자, 현재 날짜(글 등록일)가 데이터베이스에 추가됩니다.

#### - 웹페이지
![image](/uploads/c19b0ccbc114183b8c1f450ecbe7eccc/image.png)

#### - 서버코드 
![image](/uploads/5e84383d0780542d9503b3a8e428b2b6/image.png)
![image](/uploads/53b7346226d9e837034caf1890bb1dba/image.png)

### - 게시글을 등록하면 게시글 목록에서 확인할 수 있습니다. 
![image](/uploads/cd5059646917fedbea2a3aeafe0ebe25/image.png)

### - 글을 삭제할 수 있습니다. 
#### - 웹페이지
![image](/uploads/b0709c781c497bfa2b3987bab0cfb9fe/image.png)

#### - 서버코드 
![image](/uploads/78f2d4373ee5c5174b5ca80a616ba09c/image.png)
![image](/uploads/1e7269a8a5a9fcfdc111ceab27de8ad7/image.png)

### - 글을 수정할 수 있습니다.
#### - 웹페이지
![image](/uploads/7eba9bf7c56db155585e30b7bb3286d7/image.png)
#### - 서버코드 
![image](/uploads/57d1a43d9a797e175deb54cab5f08f48/image.png)
### - 수정 후 변경된 목록 화면
![image](/uploads/5e976a8d8ec988d39791a21f2c530ae4/image.png)



**getApartInfoFromApi** 클래스 에서는 아파트 상세거래 API 를 통해 API 정보를 가져옵니다.

**util** 폴더에서는 **DB를 connect, Close** 하는 클래스가 있습니다.

**housedeal** 폴더 내에는 **실거래가 Table Dao, Dto와 관심 Table Dao, Dto**  이 있습니다.

그리고 HouseDealMain.java 으로 각가지 기능을 실행합니다.

HouseDealMain 을 실행시키면 아래와 같이 메뉴 선택 창이 뜹니다.

![image](https://user-images.githubusercontent.com/51036842/159398305-54431946-89ee-4a77-b7a8-6320bd40b946.png)

먼저 데이터가 없기 때문에 6번을 통해 data 를 insert 합니다.

![image](https://user-images.githubusercontent.com/51036842/159395177-2b9cdb84-e270-468f-9c82-0df30143decc.png)

그러면 Response code가 뜨고 아래와 같이 매핑된 데이터가 들어온 것을 확인할 수 있습니다.
![image](https://user-images.githubusercontent.com/51036842/159395805-4620cfb1-53f2-486b-890c-7058d4c178c6.png)

5번으로 전체 데이터를 검색하면 다음과 같이 아파트 정보가 뜹니다.

![image](https://user-images.githubusercontent.com/51036842/159400946-8ff250c5-c9cd-46c7-bc9f-408b036469f0.png)


3번으로 동으로 검색을 하면 다음과 같이 동에 맞는 아파트 정보가 나옵니다.

![image](https://user-images.githubusercontent.com/51036842/159396009-d779f24a-2323-4895-a1fd-ec33cf3f1267.png)


4번으로 아파트로 검색을 하면 다음과 같이 아파트명에 맞는 아파트 정보가 나옵니다.

![image](https://user-images.githubusercontent.com/51036842/159396157-bd76d107-34a8-4dcf-b075-3e631be23052.png)




1번으로 다음과 같이 관심 동네 등록을 하면

![image](https://user-images.githubusercontent.com/51036842/159396270-613a1776-20af-487e-b2e6-56740dbc458e.png)

아래와 같이 관심 등록한 아파트 정보만 뜨게 됩니다.

![image](https://user-images.githubusercontent.com/51036842/159396476-f140d9d3-b0ba-4e52-8998-5f75f3b5f2b3.png)


# 회원 정보 데이터 관리

#### - 메뉴 선택

![image](https://user-images.githubusercontent.com/51036842/159401063-5dd3579c-6127-4047-8927-37da3f6eb3c5.png)

#### - 회원 등록

: 아이디, 비밀번호, 이름, 생일, 성별, 이메일을 입력하면, 입력된 정보와 현재 날짜(회원 등록일)가 데이터베이스에 추가됩니다.

![image-20220322104918228](img/image-20220322104918228.png)



![image-20220322112652097](img/image-20220322112652097.png)



#### - 비밀번호 변경

: 변경할 아이디를 입력하고, 변경할 비밀번호를 입력하면 비밀번호가 변경됩니다.

![image-20220322105420792](img/image-20220322105420792.png)



![image-20220322112731204](img/image-20220322112731204.png)


#### - 탈퇴

: 탈퇴할 아이디를 입력하면 해당 데이터가 삭제됩니다.

![image-20220322105537832](img/image-20220322105537832.png)

![image-20220322112941936](img/image-20220322112941936.png)


#### - 회원 정보 조회

: 아이디를 입력하면 해당 아이디의 회원 정보를 출력합니다.

![image-20220322113254694](img/image-20220322113254694.png)

#### - 아이디로 바밀번호 찾기

: 아이디를 입력하면 해당 아이디의 비밀번호를 조회합니다.

![image-20220322105508172](img/image-20220322105508172.png)

#### - 모든 회원 정보 출력

: 모든 회원 정보를 출력합니다.

![image-20220322112913896](img/image-20220322112913896.png)





# 동네 업종 정보 데이터 관리

#### - 메뉴 선택

![image-20220322105623532](img/image-20220322105623532.png)

#### - 코드로 상권 찾기

: 법정동 코드와 분류코드를 선택적으로 입력해서 조회할 수 있습니다. 빈 칸으로 입력한다면 모든 목록을 조회합니다.

![image-20220322111017396](img/image-20220322111017396.png)

#### - 모든 상권 출력

: 모든 상권을 출력합니다.

![image-20220322110845787](img/image-20220322110845787.png)



# 동네 환경 점검 정보 관리

#### - 지역 코드로 배출시설 찾기

: 시도군코드와 동코드를 선택적으로 입력하여 배출업체 목록을 찾을 수 있습니다.

![image-20220322111445370](img/image-20220322111445370.png)

#### - 모든 배출시설 출력

: 모든 배출시설을 출력합니다.

![image-20220322111216248](img/image-20220322111216248.png)



# 기관지 전문 병원 정보 데이터 관리

#### - 메뉴 선택

![image-20220322111731161](img/image-20220322111731161.png)

#### - 지역명과 병원명으로 병원 찾기

: 시도명과 시구군명, 병원 이름을 선택적으로 입력해서 병원 목록을 불러옵니다.

![image-20220322112000352](img/image-20220322112000352.png)

#### - 모든 기관지 전문병원 출력

: 모든 기관지 전문 병원을 출력합니다.

![image-20220322111925452](img/image-20220322111925452.png)



# 국가 안심 병원 정보 데이터 관리

#### - 메뉴 선택

![image-20220322112249523](img/image-20220322112249523.png)

#### - 지역명과 병원명으로 병원 찾기

: 시도명, 시구군명, 병원명을 선택적으로 입력하여 국가 안심 병원을 조회합니다.

![image-20220322112234381](img/image-20220322112234381.png)

#### - 모든 안심 병원 출력

: 모든 국가 안심 병원을 출력합니다.

![image-20220322112158947](img/image-20220322112158947.png)

