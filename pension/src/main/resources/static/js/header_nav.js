document.querySelector('.main-menu1').addEventListener('mouseover', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu1').style.visibility = 'visible';
})

document.querySelector('.main-menu2').addEventListener('mouseover', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu2').style.visibility = 'visible';
})

document.querySelector('.main-menu3').addEventListener('mouseover', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu3').style.visibility = 'visible';
})

// document.querySelector('.main-menu4').addEventListener('mouseover', function (e) {
//     e.preventDefault();
//     document.querySelector('.sub-menu4').style.visibility = 'visible';
// })

document.querySelector('.main-menu5').addEventListener('mouseover', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu5').style.visibility = 'visible';
})


document.querySelector('.main-menu1').addEventListener('mouseleave', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu1').style.visibility = 'hidden';
})

document.querySelector('.main-menu2').addEventListener('mouseleave', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu2').style.visibility = 'hidden';
})

document.querySelector('.main-menu3').addEventListener('mouseleave', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu3').style.visibility = 'hidden';
})

// document.querySelector('.main-menu4').addEventListener('mouseleave', function (e) {
//     e.preventDefault();
//     document.querySelector('.sub-menu4').style.visibility = 'hidden';
// })

document.querySelector('.main-menu5').addEventListener('mouseleave', function (e) {
    e.preventDefault();
    document.querySelector('.sub-menu5').style.visibility = 'hidden';
})

/* scroll event */

let nav = document.querySelector("header");
        
    document.addEventListener('wheel', function(e) {
        if(e.deltaY > 0 && scrollY > 500){
            nav.classList.add("nav-hide");
        }else {
            nav.classList.remove("nav-hide");
        }
    });

    document.addEventListener('scroll', function(e) {
        if(scrollY > 500) {
            nav.style.backgroundColor = "rgba(225, 232, 234, 1)";
        }else {
            nav.style.backgroundColor = "rgba(225, 232, 234, 0.82)";
        }
    });