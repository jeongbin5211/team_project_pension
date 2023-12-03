// 윤년 계산 함수
function checkLeapYear() {
  if(year%400 == 0) {
    return true;
  }else if(year%100 == 0) {
    return false;
  }else if(year%4 == 0) {
    return true;
  }else {
    return false;
  }
}

// 1일이 무슨 요일인지 구하는 함수
function getFirstDatOfWeek(year, month) {
  if(month < 10) {
    month = "0" + month;
  }
  return (new Date(year + "-" + month + "-01" )).getDay();
}

// 년도, 월을 직접 변경하였을 때 바뀌는 함수
function changeYearMonth(year, month) {
  let month_day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

  if(month == 2) {
    if(checkLeapYear(year)) {
      month_day[1] = 29;
    }
  }
  let first_day_of_week = getFirstDatOfWeek(year, month);
  
  let arr_calender = [];
  for(let i=0;i<first_day_of_week;i++) {
    arr_calender.push("");
  }
  for(let i=1;i<=month_day[month-1];i++) {
    arr_calender.push(String(i));
  }

  // 아래쪽 빈 공간에 채워질 배열 생성
  let remain_day = 7 - (arr_calender.length%7);
  if(remain_day < 7) {
    for(let i=0;i<remain_day;i++) {
      arr_calender.push("");
    }
  }
  renderCalender(arr_calender);
}

// 1~31일까지 테이블 html생성
function renderCalender(data) {
  let h = [];
  for(let i=0;i<data.length;i++) {
    if(i == 0) {
      h.push('<tr>');
    }else if(i%7 == 0) {
      h.push('</tr>');
      h.push('<tr>');
    }

    if(current_year < now_year) {
      h.push('<td style="cursor: default; opacity: 0.5;">'+data[i]+'</td>');
    }else if(current_year == now_year){
      if(current_month < now_month) {
        h.push('<td style="cursor: default; opacity: 0.5;">'+data[i]+'</td>');
      }else if(current_month == now_month) {
        if(data[i]>current_date) {
          if(data[i] == ""){
            h.push('<td>'+data[i]+'</td>');
          }else {
            h.push('<td onclick="setDate(' + data[i] + ');" style="cursor: pointer;">'+data[i]+'</td>');
          }
        }else {
          h.push('<td style="cursor: default; opacity: 0.5;">'+data[i]+'</td>');
        }
      }else {
        if(data[i] == "") {
          h.push('<td>'+data[i]+'</td>');
        }else {
          h.push('<td onclick="setDate(' + data[i] + ');" style="cursor: pointer;">'+data[i]+'</td>');
        }
      }
    }else if(current_year > now_year) {
      if(data[i] == "") {
        h.push('<td>'+data[i]+'</td>');
      }else {
        h.push('<td onclick="setDate(' + data[i] + ');" style="cursor: pointer;">'+data[i]+'</td>');
      }
    }
  }
  h.push('</tr>');
  $("#tb_body").html(h.join(""));
}

// 날짜를 클릭 했을때 input값에 넣기 함수
let checkin = document.querySelector("#input_date_checkin");
let checkout = document.querySelector("#input_date_checkout");

function setDate(day) {
  if(day < 10) {
    day = "0" + day;
  }
  if(checkin.value == "") {
    if(current_month < 10){
      $("#input_date_checkin").val(current_year+"-0"+current_month+"-"+day);
    }else {
      $("#input_date_checkin").val(current_year+"-"+current_month+"-"+day);
    }
  }else {
    if(current_month < 10){
      $("#input_date_checkout").val(current_year+"-0"+current_month+"-"+day);
    }else {
      $("#input_date_checkout").val(current_year+"-"+current_month+"-"+day);
    }      
  }
  if(checkin.value != "" && checkout.value != ""){
    if(checkin.value >= checkout.value) {
      alert("예약날짜를 다시 확인해 주세요.");
      checkin.value = "";
      checkout.value = "";
    }else {
      changeTripDay(checkin.value, checkout.value);
      daySelected();
    }
  }
}

function daySelected() {
  cld.classList.remove("cld_toggle");
}

// 몇박인지 계산하기
let trip_day = document.querySelector(".trip_day");

function changeTripDay(a, b) {
  let arr1 = a.split('-');
  let arr2 = b.split('-');
  
  let dt1 = new Date(arr1[0], arr1[1], arr1[2]);
  let dt2 = new Date(arr2[0], arr2[1], arr2[2]);

  let diff = dt2 - dt1;
  let diffDays = parseInt(diff/(1000*60*60*24));

  trip_day.value = diffDays;
}

// 날짜 입력값 초기화
let reset_btn = document.querySelector(".reset_checkdate");

reset_btn.addEventListener('click', function(e) {
  e.preventDefault();
  
  checkin.value = "";
  checkout.value = "";
  trip_day.value = "";
});

// 현재 년, 월, 일저장
let current_year = (new Date()).getFullYear();
let current_month = (new Date()).getMonth() + 1;

// 현재 날짜(년, 월, 일)
let now_year = (new Date()).getFullYear();
let now_month = (new Date()).getMonth()+1;
let current_date = (new Date()).getDate();

$("#year").val(current_year);
$("#month").val(current_month);

// 년도 수정하면 바뀌는 함수
function changeYear() {
  current_year = parseInt($("#year").val());
  loadCalender();
}

// 버튼으로 월 이동하는 함수
function changeMonth(diff) {
  if(diff == undefined) {
    current_month = parseInt($("#month").val());
  }else{
    current_month = current_month + diff;
    if(current_month == 0) {
      current_year = current_year - 1;
      current_month = 12;
    }else if(current_month == 13) {
      current_year = current_year + 1;
      current_month = 1;
    }
  }
  loadCalender();
}

function loadCalender() {
  $("#year").val(current_year);
  $("#month").val(current_month);
  changeYearMonth(current_year, current_month);
}

changeYearMonth(current_year, current_month);

let cld = document.querySelector(".cld_wrap");
let cld_btn = document.querySelector(".cld_show");

cld_btn.addEventListener('click', function(e) {
  e.preventDefault();
  cld.classList.toggle("cld_toggle");
});

checkin.addEventListener('focus', function(e) {
  e.preventDefault();
  if(checkin.value == "") {
    alert("달력을 클릭하여 날짜를 선택해 주세요.");
    cld.classList.add("cld_toggle");
    checkin.blur();
  }else {
    checkin.value = "";
    cld.classList.add("cld_toggle");
    checkin.blur();
  }
});

checkout.addEventListener('focus', function(e) {
  e.preventDefault();
  if(checkout.value == "") {
    alert("달력을 클릭하여 날짜를 선택해 주세요.");
    cld.classList.add("cld_toggle");
    checkout.blur();
  }else {
    checkout.value = "";
    cld.classList.add("cld_toggle");
    checkin.blur();
  }
});