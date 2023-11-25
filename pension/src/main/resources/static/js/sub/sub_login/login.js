let useremail = document.querySelector('.useremail');
let userpw = document.querySelector('.userpw');
let btn = document.querySelector('.btn');

btn.addEventListener('click', (e) => {
    e.preventDefault();

    if (useremail.value == "") {
        alert("이메일을 입력하세요.");
        useremail.focus();
        return false;
    }

    if (userpw.value == "") {
        alert("비밀번호를 입력하세요.");
        userpw.focus();
        return false;
    }
})