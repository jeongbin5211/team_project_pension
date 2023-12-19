let id = document.querySelector("input[name=id]");
let userid = document.querySelector(".userid");
let name = document.querySelector(".username");
let phone = document.querySelector(".usertell");
let email = document.querySelector(".useremail");
let addr = document.querySelector(".useraddr");
let userpw = document.querySelector("#userpasswd");
let new_userpasswd = document.querySelector("#new_userpasswd");
let renew_userpasswd = document.querySelector("#renew_userpasswd");

function changeUserid() {
    if(userid.value == "") {
        alert("변경하실 아이디를 입력하세요.");
        userid.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeUserid",
        dataType: "json",
        data:{
            id: id.value,
            userid: userid.value
        },
        success: function(result) {
            if(result.msg == "success") {
                alert("아이디가 변경되었습니다.\n로그인을 다시 하여 확인하세요.");
                location.reload();
            }else if(result.msg == "failure") {
                alert("이미 사용중인 아이디입니다.\n다른 아이디로 입력하세요.");
                userid.value = "";
                location.reload();
            }
        }
    });
}

function changeUserpw() {
    if(userpasswd.value == "") {
        alert("현재 비밀번호를 입력하세요.");
        userpasswd.focus();
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
                alert("비밀번호가 변경되었습니다.\n로그인을 다시 하여 확인하세요.");
                location.reload();
            }else if(result.msg == "failure") {
                alert("현재 비빌번호가 틀립니다.\n다시 입력하세요.");
                userpw.value = "";
                new_userpasswd.value = "";
                renew_userpasswd.value = "";
                location.reload();
            }
        }
    });
}

function changeName() {
    if(name.value == "") {
        alert("변경하실 이름을 입력해 주세요.");
        name.focus();
        return false;
    }

    $.ajax({
        type: "post",
        url: "/mypage/changeName",
        dataType: "json",
        data:{
            id: id.value,
            name: name.value
        },
        success: function(result) {
            if(result.msg == "success") {
                alert("이름이 변경되었습니다.");
                location.href = "/mypage/myinfo/update";
            }else{
                alert("이름 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
                location.href = "/mypage/myinfo/update";
            }
        }
    });
}

function changePhone() {
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
                alert("휴대폰 번호가 변경되었습니다.");
                location.href = "/mypage/myinfo/update";
            }else{
                alert("휴대폰 번호 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
                location.href = "/mypage/myinfo/update";
            }
        }
    });
}

function changeEmail() {
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
                alert("이메일이 변경되었습니다.");
                location.href = "/mypage/myinfo/update";
            }else{
                alert("이메일 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
                location.href = "/mypage/myinfo/update";
            }
        }
    });
}

function changeAddr() {
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
                alert("주소가 변경되었습니다.");
                location.href = "/mypage/myinfo/update";
            }else{
                alert("주소 변경에 문제가 발생하였습니다.\n관리자에게 문의바랍니다.");
                location.href = "/mypage/myinfo/update";
            }
        }
    });
}