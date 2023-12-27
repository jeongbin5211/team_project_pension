let id = document.querySelector("input[name=id]")
let username = document.querySelector(".username");
let phone = document.querySelector(".usertell");
let email = document.querySelector(".useremail");
let addr = document.querySelector(".useraddr");
let userpw = document.querySelector("#userpasswd");
let new_userpasswd = document.querySelector("#new_userpasswd");
let renew_userpasswd = document.querySelector("#renew_userpasswd");
let passwd_change_btn = document.querySelector("#passwd_change_btn");
let btn_change_username = document.querySelector("#btn_change_username");
let btn_change_usertell = document.querySelector("#btn_change_usertell");
let btn_change_useremail = document.querySelector("#btn_change_useremail");
let btn_change_useraddr = document.querySelector("#btn_change_useraddr");

passwd_change_btn.addEventListener('click', function(e) {
    e.preventDefault();

    if(userpw.value == "") {
        alert("현재 비밀번호를 입력하세요.");
        userpw.focus();
        return false;
    }
    if(new_userpasswd.value == "") {
        alert("새 비밀번호를 입력하세요.");
        new_userpasswd.focus();
        return false;
    }
    if(renew_userpasswd.value == "") {
        alert("새 비밀번호를 다시 입력하세요.");
        renew_userpasswd.focus();
        return false;
    }

    if(new_userpasswd.value != renew_userpasswd.value) {
        alert("입력하신 새 비밀번호가 일치하지 않습니다.\n다시 입력하세요.");
        new_userpasswd.value = "";
        renew_userpasswd.value = "";
        new_userpasswd.focus();
        return false;
    }
    
    if(new_userpasswd.value == userpw.value) {
        alert("현재 사용중인 비밀번호입니다.\n새로운 비밀번호로 입력하세요.");
        userpw.value = "";
        new_userpasswd.value = "";
        renew_userpasswd.value = "";
        userpw.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeUserpw",
        dataType: "json",
        data:{
            id: id.value,
            userpw: userpw.value,
            newUserpw: new_userpasswd.value
        },
        success: function(result) {
            if(result.msg == "success") {
                location.href = "/mypage/myinfo/checkpw";
                alert("비밀번호가 변경되었습니다.\n로그인을 다시 하여 확인하세요.");
            }else if(result.msg == "failure") {
                location.reload();
                alert("현재 비빌번호가 틀립니다.\n다시 입력하세요.");
                userpw.value = "";
                new_userpasswd.value = "";
                renew_userpasswd.value = "";
            }
        }
    });
});

btn_change_username.addEventListener('click', function(e) {
    e.preventDefault();

    if(username.value == "") {
        alert("변경하실 이름을 입력해 주세요.");
        username.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeName",
        dataType: "json",
        data:{
            id: id.value,
            name: username.value
        },
        success: function(result) {
            if(result.msg == "success") {
                location.href = "/mypage/myinfo/update";
                alert("이름이 변경되었습니다.");
            }else{
                location.href = "/mypage/myinfo/update";
                alert("이름 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
            }
        }
    });
});

btn_change_usertell.addEventListener('click', function(e) {
    e.preventDefault();

    if(phone.value == "") {
        alert("변경하실 전화번호를 입력해 주세요.");
        phone.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changePhone",
        dataType: "json",
        data:{
            id: id.value,
            phone: phone.value
        },
        success: function(result) {
            if(result.msg == "success") {
                location.href = "/mypage/myinfo/update";
                alert("휴대폰 번호가 변경되었습니다.");
            }else{
                location.href = "/mypage/myinfo/update";
                alert("휴대폰 번호 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
            }
        }
    });
});

btn_change_useremail.addEventListener('click', function(e) {
    e.preventDefault();

    if(email.value == "") {
        alert("변경하실 이메일을 입력해 주세요.");
        email.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeEmail",
        dataType: "json",
        data:{
            id: id.value,
            email: email.value
        },
        success: function(result) {
            if(result.msg == "success") {
                location.href = "/mypage/myinfo/update";
                alert("이메일이 변경되었습니다.");
            }else{
                location.href = "/mypage/myinfo/update";
                alert("이메일 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
            }
        }
    });
});

btn_change_useraddr.addEventListener('click', function(e) {
    e.preventDefault();

    if(addr.value == "") {
        alert("변경하실 주소를 입력해 주세요.");
        addr.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeAddr",
        dataType: "json",
        data:{
            id: id.value,
            addr: addr.value
        },
        success: function(result) {
            if(result.msg == "success") {
                location.href = "/mypage/myinfo/update";
                alert("주소가 변경되었습니다.");
            }else{
                location.href = "/mypage/myinfo/update";
                alert("주소 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
            }
        }
    });
});