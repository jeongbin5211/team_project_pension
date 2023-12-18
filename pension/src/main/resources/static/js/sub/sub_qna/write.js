function move() {
  location.href = "/board/qna";
}

function formCheck() {
  let boardQnaSubject = document.querySelector(".board_qna_subject");
  let boardQnaWriter = document.querySelector(".board_qna_writer");
  let boardQnaContent = document.querySelector(".board_qna_content");

  if (boardQnaSubject.value == "") {
    alert("제목을 입력해주세요.");
    boardQnaSubject.focus();
    return false;
  } else if (boardQnaContent.value == "") {
    alert("내용을 입력해주세요.");
    boardQnaContent.focus();
    return false;
  }
}
