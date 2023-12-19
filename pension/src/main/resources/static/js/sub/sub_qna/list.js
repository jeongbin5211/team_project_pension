let userid = document.querySelector('input[type=hidden]');

    if (userid.value == "") {
        function sessionRequest() {
            if (confirm("문의 하시려면 로그인이 필요합니다.\n로그인 하시겠습니까?")) {
                location.href = "/login";
            }
        }
    }