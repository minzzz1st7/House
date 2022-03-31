$(document).ready(function () {
  var notices = JSON.parse(localStorage.getItem("notices"));
  var data = ``;
  $.each(notices, (idx, item) => {
    data += `<tr>
            <th>${idx + 1}</th>
            <td><a id="notice-${idx + 1}" class="notice-title">${item.title}</a></td>
            <td>${item.view}</td>
            </tr>`;
    $(".notice-table tbody").empty().append(data);
  });

  // 공지 제목 누르면 폼이 활성화됨
  $(".notice-title").click(function () {
    //   기존 리스트 안보임
    $(".notice-list-box-toggle").addClass("d-none");
    $(".notice-form").removeClass("d-none");

    // 몇번째 공지인지 저장
    let idx = $(this).parent().prev().text();
    $("#notice-idx").empty().append(idx);

    var notices = JSON.parse(localStorage.getItem("notices"));
    // 조회수 추가
    notices[idx - 1].view += 1;
    localStorage.setItem("notices", JSON.stringify(notices));

    // 공지 데이터
    var notices = JSON.parse(localStorage.getItem("notices"));
    console.log(notices[idx - 1].title);
    // console.log(notices[idx]["title"]);
    $("#addNotice-title").val(notices[idx - 1].title);
    $("#addNotice-content").val(notices[idx - 1].content);
  });

  // 수정 누르면 수정 활성화
  $(".modify-check-nocice-btn").click(function () {
    if (modify()) {
      $(".notice-form input,textarea").attr("disabled", true);
      $(".modify-nocice-btn").toggleClass("d-none");
      $(".modify-check-nocice-btn").toggleClass("d-none");
      $(".check-nocice-btn").toggleClass("d-none");
      $(".delete-nocice-btn").toggleClass("d-none");
    }
  });

  $(".modify-nocice-btn").click(function () {
    $(".notice-form input,textarea").removeAttr("disabled");
    $(".modify-nocice-btn").toggleClass("d-none");
    $(".modify-check-nocice-btn").toggleClass("d-none");
    $(".check-nocice-btn").toggleClass("d-none");
    $(".delete-nocice-btn").toggleClass("d-none");
  });
  $(".delete-nocice-btn").click(function () {
    deleteNotice();
    location.replace("notice.html");
  });
});

function modify() {
  // 문서에서 id 로 input data 가져오기
  var list = ["title", "content"];
  var notice = new Object();
  for (let key of list) {
    var value = document.querySelector(`#addNotice-${key}`).value;
    if (!value) {
      alert("빈칸이 없도록 입력해주세요.");
      return false;
    } else {
      notice[key] = value;
    }
  }

  // users 배열 중에서 아이디 비밀번호 일치하는 것 중에서 수정
  const notices = JSON.parse(localStorage.getItem("notices"));
  const idx = document.getElementById("notice-idx").innerHTML;
  // 입력값 검증 (여러 회원 정보들 중에 사용자의 아이디와 비밀번호가 존재하면 로그인 성공)
  notice.view = notices[idx - 1].view;
  notices[idx - 1] = notice;

  localStorage.setItem("notices", JSON.stringify(notices));
  alert("공지 수정 성공!");
  return true;
}

function addNotice() {
  var list = ["title", "content"];
  var noticeArr = new Array();
  var notice = new Object();

  for (let key of list) {
    let value = document.getElementById(`addNotice-${key}`).value;
    if (!value) {
      alert("빈칸이 없도록 입력해주세요.");
      return;
    } else {
      notice[key] = value;
    }
  }
  notice.view = 0;
  noticeArr.push(notice);

  if (localStorage.getItem("notices") != null) {
    let origin = JSON.parse(localStorage.getItem("notices"));
    localStorage.setItem("notices", JSON.stringify(origin.concat(noticeArr)));
  } else {
    localStorage.setItem("notices", JSON.stringify(noticeArr));
  }

  //기존에 저장되어 있던 회원 정보에 추가

  // user 객체 문자열로 바꿔서 로컬스토리지에 저장
  alert("공지 등록 성공!");
  // 로그인 화면으로 돌아가기
  location.href = "notice.html"; // 다시 확인
}

// 공지 삭제
function deleteNotice() {
  const notices = JSON.parse(localStorage.getItem("notices"));

  const idx = document.getElementById("notice-idx").innerHTML;
  notices.splice(idx - 1, 1);

  localStorage.setItem("notices", JSON.stringify(notices));
  alert("공지 삭제 완료!");
}
