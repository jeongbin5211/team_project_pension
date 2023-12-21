function remove(id) {
  // alert(id);
  if (confirm("해당 문의사항을 삭제하시겠습니까?")) {
    location.href = "/board/qna/delete?id=" + id;
    alert("아이디 " + id + "번 문의사항이 삭제되었습니다.");
  }
}

function modified () {
    alert("답변이 수정되었습니다.");
}

let modifyBtn = document.querySelector('.modify_btn');
let cancelBtn = document.querySelector('.cancel_btn');
let boardQnaAnswerContent = document.querySelector('.board_qna_answer_content');
let ansModifyContent = document.querySelector('.ans-modify-content');

modifyBtn.addEventListener('click', () => {
    boardQnaAnswerContent.classList.add('hide');
    ansModifyContent.classList.remove('hide');
});

cancelBtn.addEventListener('click', () => {
    ansModifyContent.classList.add('hide');
    boardQnaAnswerContent.classList.remove('hide');
});


