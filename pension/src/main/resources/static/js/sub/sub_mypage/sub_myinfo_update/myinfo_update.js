let userid_change_btn = document.querySelector(".userid_change_btn");
        let userid_change = document.querySelector(".userid_change");

        userid_change_btn.addEventListener('click', function(e) {
            e.preventDefault();

            userid_change.classList.toggle("userid_box");
            if(userid_change.classList.contains("userid_box")){
                userid_change_btn.innerText = "아이디(이메일) 변경 취소";
                userid_change_btn.style.backgroundColor = "#999";
                userid_change_btn.style.color = "#fff";
            }else {
                userid_change_btn.innerText = "아이디(이메일) 변경";
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
                username_change_btn.innerText = "이름변경 취소";
                username_change_btn.style.backgroundColor = "#999";
                username_change_btn.style.color = "#fff";
            }else {
                username_change_btn.innerText = "이름변경";
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
                usertell_change_btn.innerText = "휴대폰 번호 변경 취소";
                usertell_change_btn.style.backgroundColor = "#999";
                usertell_change_btn.style.color = "#fff";
            }else {
                usertell_change_btn.innerText = "휴대폰 번호 변경";
                usertell_change_btn.style.backgroundColor = "#eee";
                usertell_change_btn.style.color = "#555";
            }
        });