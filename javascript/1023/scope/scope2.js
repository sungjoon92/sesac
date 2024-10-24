let value;

if (true) {
  let value = 123;
} else {
  let value = 456;
}
console.log(value);

let outerValue = '밖';

const func = function () {
  // outerValue = '안';
  console.log(outerValue);
};

func();
console.log(outerValue);

// global 환경에 변수 선언 -> 블럭 안에서 사용
// global 환경에 변수 선언 -> 블럭 안에서 변경
// global 환경에 변수 선언 -> 블럭 안에서 변경 -> global에서 사용
// global 환경에 변수 선언 -> 블럭 안에서 변수 선언

// global 환경에 변수 선언 -> 함수 안에서 사용
// global 환경에 변수 선언 -> 함수 안에서 변경
// global 환경에 변수 선언 -> 함수 안에서 변경 -> global에서 사용
// global 환경에 변수 선언 -> 함수 안에서 변수 선언
