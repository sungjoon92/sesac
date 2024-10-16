import React from 'react';
// css
import '../styles/Sungsan.css';
function Sungsan() {
  return (
    <>
      <h1>실습 과제</h1>
      <main class="main_box">
        <h2 class="today_name">오늘의 명소</h2>
        <div class="main_container">
          <div>
            <a
              href="https://search.naver.com/search.naver?ssc=tab.image.all&where=image&sm=tab_jum&query=%EC%84%B1%EC%82%B0+%EC%9D%BC%EC%B6%9C%EB%B4%89#imgId=image_sas%3Ablog_0df8dd01474e091d9206648c01252a0e"
              target="blank"
            >
              <img src="/assets/성산일출봉.webp" alt="성산일출봉" />
            </a>

            <div class="sungsan">
              <h4>제주도</h4>
              <h4>성산 일출봉</h4>
            </div>
          </div>

          <div class="content">
            <h3>제주도 서귀포시 성산읍</h3>
            <p>
              성산일출봉은 제주도의 다른 오름들과는 달리 마그마가 물속에서
              분출하면서 만들어진 수성화산체다.화산활동시 분출된 뜨거운 마그마가
              차가운 바닷물과 만나면서 화산재가 습기를 많이 머금어 끈끈한 성질을
              띄게 되었고, 이것이 층을 이루면서 쌓인 것이 성산일출봉이다.
            </p>
          </div>
        </div>
        <div class="green"></div>
      </main>
    </>
  );
}

export default Sungsan;
