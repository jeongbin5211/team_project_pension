document.querySelector(".near-img1").addEventListener('mouseover', function(e) {
    e.preventDefault();
    let tt = "남지 개비리길";
    let text = "남지개비리길은 벚꽃이 피는 시기 벚꽃을 보기 위해서도 많이 찾아가는 장소이기도 한데, 핑크뮬리, 억새, 코스모스도 만날 수 있는 장소입니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });
  
  document.querySelector(".near-img2").addEventListener('mouseover', function(e) {
    e.preventDefault();
    let tt = "남지 유채밭";
    let text = "창녕군 남지읍 낙동강 유채단지는 전국에서 단일면적으로 최대 규모로, 2006년에 시작돼 낙동강과 유채꽃이 어우러진 비경을 알리며 창녕 지역을 대표하는 축제인 창녕 낙동강 유채축제도 볼 수 있습니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });
  
  document.querySelector(".near-img3").addEventListener('mouseover', function(e) {
    e.preventDefault();
    let tt = "망우정";
    let text = "임진왜란 때의 곽재우가 만년을 보냈던 곳으로, 강변에 접해서 솟은 언덕 위에 큰 느티나무가 서있는 망우정에서 마음의 평화를 찾을 수 있습니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });
  
  document.querySelector(".near-img1").addEventListener('mouseleave', function(e) {
    e.preventDefault();
    let tt = "주변의 볼거리";
    let text = "개비리길 펜션에 오시면 아름다운 풍경을 즐기실 수 있습니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });
  
  document.querySelector(".near-img2").addEventListener('mouseleave', function(e) {
    e.preventDefault();
    let tt = "주변의 볼거리";
    let text = "개비리길 펜션에 오시면 아름다운 풍경을 즐기실 수 있습니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });
  
  document.querySelector(".near-img3").addEventListener('mouseleave', function(e) {
    e.preventDefault();
    let tt = "주변의 볼거리";
    let text = "개비리길 펜션에 오시면 아름다운 풍경을 즐기실 수 있습니다.";
    document.querySelector(".near-text-title").innerHTML = tt;
    document.querySelector(".near-text-txt").innerHTML = text;
  });