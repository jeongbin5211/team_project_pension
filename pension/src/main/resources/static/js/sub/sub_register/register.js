function request() {
  alert("* 로 표시된 항목은 필수사항 입니다.");
}

request();

let userid = document.querySelector(".userid");
let userpw = document.querySelector(".userpw");
let userpwCheck = document.querySelector(".userpw_check");
let email = document.querySelector(".email");
let name = document.querySelector(".name");
let phone = document.querySelector(".phone");
let addr = document.querySelector(".addr");
let showPassword = document.querySelector("#show_password");
let registerBtn = document.querySelector(".register_btn");
let idCheckBtn = document.querySelector(".id_check_btn");
let msg = document.querySelector(".msg");
let duplication = true;

idCheckBtn.addEventListener("click", (e) => {
  e.preventDefault();

  if (userid.value == "") {
    alert("아이디를 입력해주세요.");
    userid.focus();
    return false;
  } else if (userid.value.length < 8) {
    alert("아이디를 8자리 이상으로 입력해주세요.");
    userid.value = "";
    userid.focus();
    return false;
  } else {
    $.ajax({
      type: "get",
      url: "/idCheck",
      data: { userid: userid.value },
      dataType: "json",
      success: (result) => {
        // console.log(result)
        if (result.msg == "no") {
          alert("중복된 아이디입니다.");
          msg.classList.remove("green");
          msg.classList.add("red");
          msg.innerHTML = "중복된 아이디입니다.";
          userid.value = "";
          userid.focus();
        } else {
          alert("사용 가능한 아이디입니다.");
          msg.classList.remove("red");
          msg.classList.add("green");
          msg.innerHTML = "사용 가능한 아이디입니다.";
          duplication = false;
        }
      },
    });
  }
});

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

  let expText =
    /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
  let phoneTest = /^01([0|1])-?([0-9]{4})-?([0-9]{4})$/;
  let nameTest = /^[가-힣]{2,10}$/;

  if (userid.value == "") {
    alert("아이디를 입력해주세요.");
    userid.focus();
    return false;
  } else if (userid.value.length < 8) {
    alert("아이디를 8자리 이상으로 입력해주세요.");
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

  if (name.value == "") {
    alert("이름을 입력해주세요.");
    name.focus();
    return false;
  } else if (name.value.length < 2) {
    alert("이름을 두글자 이상 적어주세요.");
    name.focus();
    return false;
  } else if (nameTest.test(name.value) == false) {
    alert("이름은 한글로 작성해주세요.");
    name.focus();
    return false;
  }

  if (phone.value == "") {
    alert("전화번호를 입력해주세요.");
    phone.focus();
    return false;
  } else if (phoneTest.test(phone.value) == false) {
    alert("'-' 제외한 11자리를 입력해주세요.\n ex) 01012345678");
    phone.value = "";
    phone.focus();
    return false;
  }

  if (email.value == "") {
    alert("이메일을 입력해주세요.");
    email.focus();
    return false;
  } else if (expText.test(email.value) == false) {
    alert("이메일 형식이 올바르지 않습니다.");
    email.focus();
    return false;
  }

  if (duplication) {
    alert("아이디 중복 체크를 해주세요.");
    idCheckBtn.focus();
    return false;
  }

  let obj = {
    userid: userid.value,
    userpw: userpw.value,
    name: name.value,
    phone: phone.value,
    email: email.value,
    addr: addr.value,
  };

  $.ajax({
    type: "post",
    url: "/register",
    data: obj,
    dataType: "json",
    success: (result) => {
      // console.log(result.msg);
      if (result.msg == "ok") {
        alert("회원가입이 완료되었습니다.");
        location.href = "/login";
      } else {
        alert("회원가입에 실패했습니다.\n관리자에게 문의하세요.");
      }
    },
  });
});
