// 나는 미세먼지 농도를 알고 있고,
// 그 농도에 따른 지수를 알고싶음.

let dust = 50.5;

if (0 <= dust && dust <= 50) {
  console.log('좋음');
}

if (51 <= dust && dust <= 100) {
  console.log('보통');
}

if (101 <= dust && dust <= 250) {
  console.log('나쁨');
}

if (251 <= dust) {
  console.log('매우나쁨');
}

if (0 <= dust && dust <= 50) {
  console.log('좋음');
} else if (dust <= 100) {
  console.log('보통');
} else if (dust <= 250) {
  console.log('나쁨');
} else {
  console.log('매우나쁨');
}

let target = document.querySelector('.color');
let blue = '#0000FF';
let green = '#00FF00';
let yellow = '#FFFF00';
let red = '#FF0000';

dust = 20;

document.addEventListener('DOMContentLoaded', function () {
  if (dust <= 50) {
    console.log(blue);
    target.style.backgroundColor = blue;
    target.innerHTML = '좋음';
  } else if (dust >= 51 && dust <= 100) {
    console.log(green);
    target.style.backgroundColor = green;
    target.innerHTML = '보통';
  } else if (dust >= 101 && dust <= 250) {
    console.log(yellow);
    target.style.backgroundColor = yellow;
    target.innerHTML = '나쁨';
  } else if (dust >= 251) {
    console.log(red);
    target.style.backgroundColor = red;
    target.innerHTML = '매우나쁨';
  }
});
