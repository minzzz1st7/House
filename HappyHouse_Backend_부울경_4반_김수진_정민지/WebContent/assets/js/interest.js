$(document).ready(function () {
  $("#inteestConfirm").click(function () {
    var interestList = localStorage.getItem("interest");
    if (interestList == null) {
      alert("관심 지역을 설정하세요");
    }
    let interestListJson = JSON.parse(interestList);
    let index = 0;
    let appendList = "";
    for (let i of interestListJson) {
      let sido = i["sido"];
      let sigugun = " " + i["sigugun"];
      let dong = " " + i["dong"];
      let fullName = `${sido}${sigugun}${dong}`;
      appendList += `
        <div class="intrestList jumbotron .col-sm-2">
        <ul class="list-group">
        <li class="list-group-item list-group-item-primary">시: ${sido}</li>
        <li class="list-group-item list-group-item-primary">구: ${sigugun}</li>
        <li class="list-group-item list-group-item-primary">동: ${dong}</li>
        </ul>
        </div>
        <button type="button" class="intrestRegion" value="${fullName}">검색</button>
        `;
      index++;
    }

    $("#interestList").empty().append(appendList);

    $(".intrestRegion").click(function () {
      let s = this.getAttribute("value");
      let cityCode = s[0] + s[1] + s[2] + s[3] + s[4];
      let city = checkCity(cityCode);

      for (let index = 5; index < s.length; ++index) {
        city += s[index];
      }

      var geocoder = new kakao.maps.services.Geocoder();
      //첫번쨰 파라미터는 주소를 넣어준다. 여기선 this를 넣어주면 된다.
      var address = city;
      geocoder.addressSearch(address, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          //var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          //var centerPosition = map.getCenter();
          var cx = result[0].y; //centerPosition.getLat(); // 위도
          var cy = result[0].x; //centerPosition.getLng(); // 경도
          // 여기 밑에서 위도 경도를 가지고 상권 정보를 map에 다시 뿌려줘야 한다.
        } else {
          console.log("error status");
          console.log(status);
        }
        //중심좌표: map.getCenter()
        //위도: center.getLat()
        //경도: center.getLng()

        console.log("반경내 상가업소 조회 오퍼레이션 명세");
        var ServiceKey =
          "yOYPxjA2Luqpjh8gS0r0pw69WoBHUn5HXJzTznjhCK78Aab2ZiFJ5pAGNq/LoVzbI1pCfMG10RPiGyk+qfFAIQ=="; //일반 인증키 (decode)
        // server에서 넘어온 data
        $.ajax({
          url: "http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInRadius", //call back 함수 url
          type: "GET",
          data: {
            ServiceKey: ServiceKey,
            radius: "1000",
            pageNo: "1",
            numOfRows: "10",
            cx: cy, //중심점 경도
            cy: cx, //중심점 위도
            indsLclsCd: "Q", //상권업종 대분류코드
            indsMclsCd: "Q12", //중분류
            indsSclsCd: "Q12A01", //소분류
            type: "xml",
          },

          dataType: "xml",
          success: function (response) {
            console.log("반경내 상가업소 조회 오퍼레이션 명세 성공");
            getList(response, cx, cy);
          },
          error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http 에러메시지 : " + msg);
          },
        });
      });
    });

    function getList(data, cx, cy) {
      var positions = [];
      // var L = document.getElementById("big");
      // var M = document.getElementById("medium");
      // var S = document.getElementById("small");
      // infoList에 cx, cy, storeName을 넣어 놓고, 이제 지도에 마킹을 한다.
      $(data)
        .find("item")
        .each(function () {
          // if($(this).find("indsMclsNm")==L &&
          // $(this).find("indsMclsNm")==M &&
          // $(this).find("indsMclsNm")==S
          // ){}
          positions.push({
            latlng: new kakao.maps.LatLng(
              `${$(this).find("lat").text()}`,
              `${$(this).find("lon").text()}`
            ),
            content: `${$(this).find("bizesNm").text()}`,
            title: `${$(this).find("bizesNm").text()}`,
          });
        });

      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };
      // 지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      // 마커 이미지의 이미지 주소입니다
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
      // 마커 이미지의 이미지 크기 입니다.

      for (var i = 0; i < positions.length; i++) {
        var imageSize = new kakao.maps.Size(24, 35);
        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });

        // // 마커에 표시할 인포윈도우를 생성합니다
        // var infowindow = new kakao.maps.InfoWindow({
        //   content: positions[i].content, // 인포윈도우에 표시할 내용
        // });

        // // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // // 이벤트 리스너로는 클로저를 만들어 등록합니다
        // // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        // kakao.maps.event.addListener(
        //   marker,
        //   "mouseover",
        //   makeOverListener(map, marker, infowindow)
        // );
        // kakao.maps.event.addListener(marker, "mouseout", makeOutListener(infowindow));

        // // 마커에 click 이벤트를 등록합니다
        // kakao.maps.event.addListener(
        //   marker,
        //   "click",
        //   makeClickListener(map, marker, infowindow)
        // );
      }

      //var moveLatLon = new kakao.maps.LatLng(positions[0].latlng.Ma, positions[0].latlng.La);
      var moveLatLon = new kakao.maps.LatLng(cx, cy);
      // 지도 중심을 이동 시킵니다
      map.setCenter(moveLatLon);
    }

    function makeClickListener(map, marker, infowindow) {
      return function () {
        var pos = marker.getPosition();
        console.log(pos);
        map.setLevel(5);
        map.panTo(pos);
      };
    }

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
    function makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다
    function makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    }
  });

  $("#moveRegisterInterest").click(function () {
    location.href = "registerInterest.html";
  });
});
/*
1. 위치 정보로 좌표를 얻는다.
2. 좌표로부터 상가 정보를 얻는다.
3. 상가 정보를 맵에 추가한다.
*/

function checkCity(cityCode) {
  let cityName = "";
  switch (cityCode) {
    case "27110":
      cityName = "대구광역시";
      break;
    case "30110":
      cityName = "대전광역시";
      break;
    case "26110":
      cityName = "부산광역시";
      break;
    case "11110":
      cityName = "서울특별시";
      break;
    case "36110":
      cityName = "세종특별자치시";
      break;
    case "31110":
      cityName = "울산광역시";
      break;
    case "28110":
      cityName = "인천광역시";
      break;
    case "46110":
      cityName = "전라남도";
      break;
    case "45111":
      cityName = "전라북도";
      break;
    case "50110":
      cityName = "제주특별자치도";
      break;
    case "44131":
      cityName = "충청남도";
      break;
    case "43111":
      cityName = "충청북도";
      break;
  }
  return cityName;
}
