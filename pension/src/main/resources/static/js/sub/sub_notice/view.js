function move() {
  location.href = "/board/notice";
}

function remove(id) {
  // alert(id);
  if (confirm("해당 공지사항을 삭제하시겠습니까?")) {
    location.href = "/board/notice/delete?id=" + id;
    alert("아이디 " + id + "번 공지사항이 삭제되었습니다.");
  }
}
