$(document).ready(function () {
  // localStorage에 저장되어있는 정보 출력
  var info = JSON.parse(localStorage.getItem("user"));
  var data = ``;
  $.each(info, (key, value) => {
    data += `<tr>
        <th>${key}</th>
        <td><input type="text" class="${key}" value="${value}"disabled></td>
        </tr>`;
    $(".myPage-check").empty().append(data);
  });

  // 수정 버튼 누르면 .myPage-check이 수정되도록 변경
  $("#info-check-btn").click(function () {
    if (modify_info()) {
      $(".myPage-check input").attr("disabled", true);
      $("#info-modify-btn").toggleClass("d-none");
      $("#info-check-btn").toggleClass("d-none");
      $("#info-delete-btn").toggleClass("d-none");
    }
  });

  $("#info-modify-btn").click(function () {
    $(".myPage-check input").removeAttr("disabled");
    $("#info-modify-btn").toggleClass("d-none");
    $("#info-check-btn").toggleClass("d-none");
    $("#info-delete-btn").toggleClass("d-none");
  });
  $("#info-delete-btn").click(function () {
    deleteInfo();
    location.replace("index.html");
  });
});

function deleteInfo() {
  const users = JSON.parse(localStorage.getItem("users"));
  const currentUser = JSON.parse(localStorage.getItem("user"));
  // 입력값 검증 (여러 회원 정보들 중에 사용자의 아이디와 비밀번호가 존재하면 로그인 성공)
  for (let i = 0; i < users.length; i++) {
    console.log(users[i]["id"]);
    console.log(users[i]["password"]);
    if (users[i]["id"] == currentUser["id"] && users[i]["password"] == currentUser["password"]) {
      // users.slice(i, i + 1);
      users.splice(i, 1);
      break;
    }
  }

  localStorage.setItem("users", JSON.stringify(users));
  localStorage.removeItem("user");
  localStorage.removeItem("checkLogin");
  alert("탈퇴 완료!");
}

function modify_info() {
  // 문서에서 id 로 input data 가져오기
  var list = ["id", "password", "name", "email", "age"];
  var user = new Object();
  for (let key of list) {
    var value = document.querySelector(`.myPage-check .${key}`).value;
    if (!value) {
      alert("빈칸이 없도록 입력해주세요.");
      return false;
    } else {
      user[key] = value;
    }
  }

  // users 배열 중에서 아이디 비밀번호 일치하는 것 중에서 수정
  const users = JSON.parse(localStorage.getItem("users"));
  const currentUser = JSON.parse(localStorage.getItem("user"));
  // 입력값 검증 (여러 회원 정보들 중에 사용자의 아이디와 비밀번호가 존재하면 로그인 성공)
  for (let i = 0; i < users.length; i++) {
    console.log(users[i]["id"]);
    console.log(users[i]["password"]);
    if (users[i]["id"] == currentUser["id"] && users[i]["password"] == currentUser["password"]) {
      users[i] = user;
    }
  }

  localStorage.setItem("users", JSON.stringify(users));
  localStorage.setItem("user", JSON.stringify(user));
  alert("사용자 수정 성공!");
  return true;
}
