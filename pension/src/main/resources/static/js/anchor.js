document.addEventListener('scroll', () => {   
    
    let myScroll = window.scrollY;
    console.log(myScroll);
    
    if (myScroll < 1800) {
        document.querySelector('.anchor').style.opacity = '0';
        document.querySelector('.anchor').style.visibility = "hidden";
    } else {
        document.querySelector('.anchor').style.opacity = '1';
        document.querySelector('.anchor').style.visibility = "visible";
    }
})