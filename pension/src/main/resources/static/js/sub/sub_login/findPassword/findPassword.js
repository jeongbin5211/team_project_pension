let userid = document.querySelector(".userid");
let name = document.querySelector(".name");
let email = document.querySelector(".email");
let exptext =
  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
let findPwBtn = document.querySelector(".find_pw_button");
let userInfo = document.querySelector(".user_info");
let findedUserpw = document.querySelector(".finded_userpw");
let newPw = document.querySelector(".userpw");
let checkNewPw = document.querySelector(".userpw_check");
let changePwBtn = document.querySelector(".change_pw_btn");
let hiddenUserid = document.querySelector(".hidden_userid");
let hiddenUserpw = document.querySelector(".hidden_userpw");

findPwBtn.addEventListener("click", (e) => {
  e.preventDefault();
  if (userid.value == "") {
    alert("아이디를 입력해주세요.");
    userid.focus();
    return false;
  } else if (name.value == "") {
    alert("이름을 입력해주세요.");
    name.focus();
    return false;
  } else if (email.value == "") {
    alert("이메일을 입력해주세요.");
    email.focus();
    return false;
  } else if (exptext.test(email.value) == false) {
    alert("이메일 형식이 올바르지 않습니다.");
    email.focus();
    return false;
  } else {
    let obj = {
      userid: userid.value,
      name: name.value,
      email: email.value,
    };
    $.ajax({
      type: "post",
      url: "/find/findPassword",
      data: obj,
      dataType: "json",
      success: (result) => {
        if (result.msg == "success") {
          alert("success");
          userInfo.classList.remove("show");
          userInfo.classList.add("hidden");
          findedUserpw.classList.remove("hidden");
          findedUserpw.classList.add("show");
          hiddenUserid.innerHTML = `${result.hiddenUserid}`;
          hiddenUserpw.innerHTML = `${result.hiddenUserpw}`;
          changePwBtn.addEventListener("click", (e) => {
            e.preventDefault();
            // alert("ok");
            if (newPw.value == "") {
              alert("설정하실 비밀번호를 입력해주세요.");
              newPw.focus();
              return false;
            } else if (newPw.value.length < 8) {
              alert("비밀번호를 8자리 이상으로 설정해주세요.");
              newPw.value = "";
              newPw.focus();
              return false;
            } else if (newPw.value != checkNewPw.value) {
              alert(
                "입력하신 비밀번호와 비밀번호 확인란이 일치하지 않습니다.\n비밀번호를 다시 입력해주세요."
              );
              checkNewPw.value = "";
              checkNewPw.focus();
              return false;
            } else {
              let obj = {
                newPw: newPw.value,
                hiddenUserid: hiddenUserid.innerHTML,
                hiddenUserpw: hiddenUserpw.innerHTML,
              };
              $.ajax({
                type: "post",
                url: "/setNewPassword",
                data: obj,
                dataType: "json",
                success: (result) => {
                  console.log(result.msg);
                  if (result.msg == "none") {
                    alert(
                      "사용하던 비밀번호로는 설정할 수 없습니다.\n다른 비밀번호로 설정해주세요."
                    );
                    newPw.value = "";
                    checkNewPw.value = "";
                    newPw.focus();
                  } else if (result.msg == "change") {
                    alert(
                      "비밀번호 변경이 완료되었습니다.\n로그인 페이지로 이동합니다."
                    );
                    location.href = "/login";
                  }
                },
              });
            }
          });
        } else {
          alert("회원정보가 잘못되었습니다.\n다시 입력해주세요.");
          userid.value = "";
          name.value = "";
          email.value = "";
          userid.focus();
        }
      },
    });
  }
});
