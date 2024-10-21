import React, { useEffect, useRef, useState } from 'react';
// css
import '../../styles/For.css';
function Home() {
  // form input 접근자 생성
  const inputRef = useRef(null); // ref 생성
  const [dust, setDust] = useState(''); // 상태 관리

  const test = () => {
    const inputValue = inputRef.current.value; // ref를 사용하여 input의 값에 접근
    setDust(inputValue); // 상태 업데이트 (input 값이 dust로 설정)
  };

  // javascript 사용시 useEffect 필요
  useEffect(function () {
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

    // dust 값을 숫자로 변환
    const dustValue = parseInt(dust);

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
  return (
    <div class="javascript">
      <div class="color">color</div>
      {/*  <form className="test" action="get" onSubmit={test}>
        <input type="text" ref={inputRef}></input>
        <input type="submit"></input>
      </form> */}
      <div>
        <input type="number" className="test" ref={inputRef} />
        {/* ref를 input에 연결 */}
        <button onClick={test}>Get Value</button>
        {/* 버튼 클릭 시 test 함수 호출 */}
      </div>
    </div>
  );
}

export default Home;
