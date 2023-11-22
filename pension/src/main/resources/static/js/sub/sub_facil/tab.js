let tabList = document.querySelectorAll(".tab-menu li");
let contents = document.querySelectorAll(".cont");
let activeCont = "";

for(let i=0;i<tabList.length;i++) {
    tabList[i].querySelector(".btn").addEventListener('click', function(e) {
    e.preventDefault();
            
    for(let j=0;j<tabList.length;j++) {
        tabList[j].classList.remove("active");
        tabList[j].style.borderBottom = "none";
        contents[j].style.display = "none";
    }

    this.parentNode.classList.add("active");
    this.parentNode.style.borderBottom = "3px solid #616161";

    activeCont = this.getAttribute("href");
    document.querySelector(activeCont).style.display = "block";
    });
}