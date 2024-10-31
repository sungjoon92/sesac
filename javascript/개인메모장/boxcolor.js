let money = 10001;

if (money > 1000) {
  console.log('나 돈 많아');
} else {
  console.log('나 거지야');
}

let ondo = 20;
if (ondo < 22) {
  console.log('보일러 틀어');
} else {
  console.log('에어컨 틀어');
}

if (money > 10000) {
  console.log('치킨');
} else if (money > 5000) {
  console.log('라면');
} else if (money > 1000) {
  console.log('과자');
} else if (money > 100) {
  console.log('추파춥스');
} else {
  console.log('돈좀 주세요');
}
console.log('-------------------');

if (money > 100) {
  console.log('추파춥스'); // money가 10000보다 크면 '치킨'을 출력
  if (money > 1000) {
    console.log('과자'); // money가 5000보다 크면 '라면'을 출력
    if (money > 5000) {
      console.log('라면'); // money가 1000보다 크면 '과자'를 출력
      if (money > 10000) {
        console.log('치킨'); // money가 100보다 크면 '추파춥스'를 출력
      }
    }
  }
}

let target = document.querySelector('.color');
let blue = '#0000FF';
let green = '#00FF00';
let yellow = '#FFFF00';
let red = '#FF0000';

const dust = 40;

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
