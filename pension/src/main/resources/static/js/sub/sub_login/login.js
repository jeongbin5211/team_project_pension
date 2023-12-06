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
                // console.log(result.msg)
                if (result.msg == "fail") {
                    alert("아이디와 비밀번호를 다시 확인하세요.");
                    userpw.value = "";
                    userpw.focus();
                    return false;
                } else {
                    alert("로그인 성공");
                    location.href = "/";
                }
            }
        })
    })
