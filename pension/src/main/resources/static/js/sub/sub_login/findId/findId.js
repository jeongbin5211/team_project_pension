let name = document.querySelector(".name");
let email = document.querySelector(".email");
let exptext =
  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
let btn = document.querySelector(".find_id_button");
let findedUserid = document.querySelector(".finded_userid");
let userName = document.querySelector(".user_name");
let userUserid = document.querySelector(".user_userid");
let userInfo = document.querySelector(".user_info");

btn.addEventListener("click", (e) => {
  e.preventDefault();

  // alert("ok");

  if (name.value == "") {
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
      name: name.value,
      email: email.value,
    };
    $.ajax({
      type: "post",
      url: "/find/findId",
      data: obj,
      dataType: "json",
      success: (result) => {
        // console.log(result);
        if (result.msg == "success") {
          alert("success");
          userInfo.classList.remove("show");
          userInfo.classList.add("hidden");
          findedUserid.classList.remove("hidden");
          findedUserid.classList.add("show");
          userName.innerHTML = `${result.name} 회원님의 아이디입니다.`;
          userUserid.innerHTML = `<strong>아이디 : <span class="green">${result.userid}</span></strong>`;
        } else {
          alert("회원정보가 잘못되었습니다.\n다시 입력해주세요.");
          name.value = "";
          email.value = "";
          name.focus();
        }
      },
    });
  }
});
