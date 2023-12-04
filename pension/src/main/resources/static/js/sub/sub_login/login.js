    let userid = document.querySelector('.userid');
    let userpw = document.querySelector('.userpw');
    let btn = document.querySelector('.btn');

    btn.addEventListener('click', (e) => {
        e.preventDefault();

        if (userid.value == "") {
            alert("아이디를 입력해주세요.");
            userid.focus();
            return false;
        }

        if (userpw.value == "") {
            alert("비밀번호를 입력해주세요.");
            userpw.focus();
            return false;
        }
    })
