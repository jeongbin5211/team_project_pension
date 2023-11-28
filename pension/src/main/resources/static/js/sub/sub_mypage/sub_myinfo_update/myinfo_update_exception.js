let btn_change_userid = document.querySelector("#btn_change_userid");
let userid = document.querySelector(".userid");
let btn_change_username = document.querySelector("#btn_change_username");
let username = document.querySelector(".username");
let btn_change_usertell = document.querySelector("#btn_change_usertell");
let usertell = document.querySelector(".usertell");
let btn_change_useremail = document.querySelector("#btn_change_useremail");
let useremail = document.querySelector(".useremail");
let btn_change_useraddr = document.querySelector("#btn_change_useraddr");
let useraddr = document.querySelector(".useraddr");

btn_change_userid.addEventListener('click', function(e) {
    e.preventDefault();

    if(userid.value == "") {
        alert("변경하실 아이디를 입력해 주세요.");
        userid.focus();
        return false;
    }
});

btn_change_username.addEventListener('click', function(e) {
    e.preventDefault();

    if(username.value == "") {
        alert("변경하실 이름을 입력해 주세요.");
        username.focus();
        return false;
    }
});

btn_change_usertell.addEventListener('click', function(e) {
    e.preventDefault();

    if(usertell.value == "") {
        alert("변경하실 전화번호를 입력해 주세요.");
        usertell.focus();
        return false;
    }
});

btn_change_useremail.addEventListener('click', function(e) {
    e.preventDefault();

    if(useremail.value == "") {
        alert("변경하실 이메일을 입력해 주세요.");
        useremail.focus();
        return false;
    }
});

btn_change_useraddr.addEventListener('click', function(e) {
    e.preventDefault();

    if(useraddr.value == "") {
        alert("변경하실 주소를 입력해 주세요.");
        useraddr.focus();
        return false;
    }
});

let userpasswd = document.querySelector("#userpasswd");
let new_userpasswd = document.querySelector("#new_userpasswd");
let renew_userpasswd = document.querySelector("#renew_userpasswd");

let passwd_change_btn = document.querySelector("#passwd_change_btn");

passwd_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    if(userpasswd.value == "") {
        alert("현재 비밀번호를 입력해 주세요.");
        userpasswd.focus();
        return false;
    }
    if(new_userpasswd.value == "") {
        alert("새 비밀번호를 입력해 주세요.");
        new_userpasswd.focus();
        return false;
    }
    if(renew_userpasswd.value == "") {
        alert("새 비밀번호를 다시 입력해 주세요.");
        renew_userpasswd.focus();
        return false;
    }

    if(new_userpasswd.value != renew_userpasswd.value) {
        alert("입력하신 새 비밀번호가 일치하지 않습니다.\n다시 입력해 주세요.");
        new_userpasswd.value = "";
        renew_userpasswd.value = "";
        new_userpasswd.focus();
        return false;
    }
});