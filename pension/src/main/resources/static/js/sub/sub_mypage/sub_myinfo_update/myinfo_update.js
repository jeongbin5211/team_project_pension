let userid_change_btn = document.querySelector(".userid_change_btn");
let userid_change = document.querySelector(".userid_change");

userid_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    userid_change.classList.toggle("userid_box");
    if(userid_change.classList.contains("userid_box")){
        userid_change_btn.innerText = "아이디 변경 취소";
        userid_change_btn.style.backgroundColor = "#999";
        userid_change_btn.style.color = "#fff";
    }else {
        userid_change_btn.innerText = "아이디 변경";
        userid_change_btn.style.backgroundColor = "#eee";
        userid_change_btn.style.color = "#555";
    }
});

let username_change_btn = document.querySelector(".username_change_btn");
let username_change = document.querySelector(".username_change");

username_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    username_change.classList.toggle("username_box");
    if(username_change.classList.contains("username_box")){
        username_change_btn.innerText = "이름 변경 취소";
        username_change_btn.style.backgroundColor = "#999";
        username_change_btn.style.color = "#fff";
    }else {
        username_change_btn.innerText = "이름 변경";
        username_change_btn.style.backgroundColor = "#eee";
        username_change_btn.style.color = "#555";
    }
});

let usertell_change_btn = document.querySelector(".usertell_change_btn");
let usertell_change = document.querySelector(".usertell_change");

usertell_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    usertell_change.classList.toggle("usertell_box");
    if(usertell_change.classList.contains("usertell_box")){
        usertell_change_btn.innerText = "전화번호 변경 취소";
        usertell_change_btn.style.backgroundColor = "#999";
        usertell_change_btn.style.color = "#fff";
    }else {
        usertell_change_btn.innerText = "전화번호 변경";
        usertell_change_btn.style.backgroundColor = "#eee";
        usertell_change_btn.style.color = "#555";
    }
});

let useremail_change_btn = document.querySelector(".useremail_change_btn");
let useremail_change = document.querySelector(".useremail_change");

useremail_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    useremail_change.classList.toggle("useremail_box");
    if(useremail_change.classList.contains("useremail_box")){
        useremail_change_btn.innerText = "이메일 변경 취소";
        useremail_change_btn.style.backgroundColor = "#999";
        useremail_change_btn.style.color = "#fff";
    }else {
        useremail_change_btn.innerText = "이메일 변경";
        useremail_change_btn.style.backgroundColor = "#eee";
        useremail_change_btn.style.color = "#555";
    }
});

let useraddr_change_btn = document.querySelector(".useraddr_change_btn");
let useraddr_change = document.querySelector(".useraddr_change");

useraddr_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    useraddr_change.classList.toggle("useraddr_box");
    if(useraddr_change.classList.contains("useraddr_box")){
        useraddr_change_btn.innerText = "주소 변경 취소";
        useraddr_change_btn.style.backgroundColor = "#999";
        useraddr_change_btn.style.color = "#fff";
    }else {
        useraddr_change_btn.innerText = "주소 변경";
        useraddr_change_btn.style.backgroundColor = "#eee";
        useraddr_change_btn.style.color = "#555";
    }
});