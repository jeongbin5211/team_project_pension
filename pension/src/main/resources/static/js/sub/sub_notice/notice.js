function move() {
  location.href = "/board/notice";
}

function formCheck() {
  let boardNoticeSubject = document.querySelector(".board_notice_subject");
  let boardNoticeContent = document.querySelector(".board_notice_content");
  let boardNoticeFiles = document.querySelector(".board_notice_files");
  let imgBox = document.querySelector(".img-box");

  if (boardNoticeSubject.value == "") {
    alert("제목을 입력해주세요.");
    boardNoticeSubject.focus();
    return false;
  } else if (boardNoticeContent.value == "" && !imgBox) {
    alert("내용을 입력해주세요.");
    boardNoticeContent.focus();
    return false;
  }
}
