function request() {
  alert("* 로 표시된 항목은 필수사항 입니다.");
}

request();

let userid = document.querySelector(".userid");
let userpw = document.querySelector(".userpw");
let userpwCheck = document.querySelector(".userpw_check");
let email = document.querySelector(".email");
let phone = document.querySelector(".phone");
let showPassword = document.querySelector("#show_password");
let registerBtn = document.querySelector(".register_btn");

showPassword.addEventListener("click", (e) => {
  e.preventDefault();

  if (userpw.type == "password") {
    userpw.type = "text";
    showPassword.classList.remove("fa-eye");
    showPassword.classList.add("fa-eye-slash");
  } else if (userpw.type == "text") {
    userpw.type = "password";
    showPassword.classList.remove("fa-eye-slash");
    showPassword.classList.add("fa-eye");
  }
});

registerBtn.addEventListener("click", (e) => {
  e.preventDefault();

  let exptext =
    /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
  let phonetest = /^[0-9]{3}[0-9]{4}[0-9]{4}/;

  if (userid.value == "") {
    alert("아이디를 입력해주세요.");
    userid.focus();
    return false;
  } else if (userid.value.length < 6) {
    alert("아이디를 6자리 이상으로 입력해주세요.");
    userid.value = "";
    userid.focus();
    return false;
  }

  if (userpw.value == "") {
    alert("비밀번호를 입력해주세요.");
    userpw.focus();
    return false;
  } else if (userpw.value.length < 8) {
    alert("비밀번호를 8자리 이상으로 입력해주세요.");
    userpw.value = "";
    userpw.focus();
    return false;
  } else if (userpw.value != userpwCheck.value) {
    alert(
      "입력하신 비밀번호와 비밀번호 확인란이 일치하지 않습니다.\n비밀번호를 다시 입력해주세요."
    );
    userpwCheck.value = "";
    userpwCheck.focus();
    return false;
  }

  if (email.value == "") {
    alert("이메일을 입력해주세요.");
    email.focus();
    return false;
  } else if (exptext.test(email.value) == false) {
    alert("이메일 형식이 올바르지 않습니다.");
    email.focus();
    return false;
  }

  if (phone.value == "") {
    alert("전화번호를 입력해주세요.");
    phone.focus();
    return false;
  } else if (phonetest.test(phone.value) == false) {
    alert("'-' 제외한 11자리를 입력해주세요.\n ex) 01012345678");
    phone.value = "";
    phone.focus();
    return false;
  }
});
