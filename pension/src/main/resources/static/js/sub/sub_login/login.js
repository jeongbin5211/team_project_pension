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

        let obj = {
            userid: userid.value,
            userpw: userpw.value
        }

        $.ajax({
            type: 'post',
            url: "/login",
            data: obj,
            dataType: 'json',
            success: (result) => {
                console.log(result.msg)
                if (result.msg == "fail") {
                    alert("아이디와 비밀번호를 다시 확인하세요.");
                    userpw.value = "";
                    userpw.focus();
                    return false;
                } else if (result.msg == "admin") {
                    alert("관리자 계정으로 로그인합니다.");
                    location.href = "/admin";
                } else if (result.msg == "user") {
                    alert(result.userid + "님 환영합니다.");
                    location.href = "/";
                }
            }
        })
    })
