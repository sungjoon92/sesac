import React from 'react';
function form2() {
  /*   function test() {
    let name = document.getElementById('name').value;
    if (name.length <= 2) {
      alert('이름을 작성해 주세요');
      return false;
    }

    // 선택된 라디오 버튼을 찾음
    let roomType = document.querySelector('input[name="room_type"]:checked');
    // 선택된 라디오 버튼이 없으면 경고창 표시
    if (!roomType) {
      alert('객실 타입을 선택해주세요.');
      return false;
    }
  } */
  return (
    <div>
      <h1>숙소 예약</h1>
      <form action="get" onsubmit="return test()">
        {/*   <!-- 이름 --> */}
        <div>
          <h2>신상 정보</h2>
          <label for="name">이름 :</label>
          <input
            type="text"
            name="name"
            id="name"
            placeholder="이름 입력"
            autofocus
          />
        </div>

        {/* <!-- 이메일 --> */}
        <div>
          <label for="email">이메일 :</label>
          <input
            type="text"
            name="email"
            id="email"
            placeholder="이메일 입력"
          />
        </div>
        <div>
          <label for="poto">예약자 사진 :</label>
          <input type="file" name="poto" id="poto" placeholder="파일 선택" />
        </div>
        <hr />

        <h2>상세 정보</h2>

        {/*  <!-- 객실 타입 --> */}
        <h3>선호 객실 타입</h3>
        <div>
          <label for="city">도시뷰 :</label>
          <input type="radio" name="room_type" id="city" value="city" />

          <label for="lake">레이크뷰 :</label>
          <input type="radio" name="room_type" id="lake" value="lake" />

          <label for="mountain">마운틴뷰 :</label>
          <input type="radio" name="room_type" id="mountain" value="mountain" />
        </div>

        {/* <!-- 동행자 정보 --> */}
        <h2>동행자 정보</h2>
        <div>
          <label for="aa">인원수 :</label>
          <input type="text" name="aa" id="aa" />
        </div>

        {/*   <!-- 기타 --> */}
        <h2>기타</h2>
        <div>
          <label for="textarea">요청사항 : </label>
          <textarea name="textarea" id="textarea"></textarea>
        </div>

        <input type="submit" value="정보 전달" />
      </form>
    </div>
  );
}

export default form2;