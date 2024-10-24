// 구구단을 만들고 싶음.
// 2차원 배열로 만들고 싶음.

// [
//   [1, 2, 3, 4, ..., 9],
//   [2, 4, 6, 8, 10, ...18],
//   [3, 6, 9, ..., 27],
//   ...
//   [9, 18, 27, ..., 81]
// ]

// 1. 전체를 담을 수 있는 container
// 2. 1단
// 3. 1단을 1번에 넣습니다
// 4. 2단
// 5. 2단을 1번에 넣습니다

// ... 9단을 만들고 넣습니다.

// 4. 2단을 만듦.
// 4.a 2단을 어떻게 만들지?
// 2 *1 / 2*2 / 2*3 / 2*4 계산 -> 새로운 container에 넣어줄것. -> 계산하기 전에 container가 필요합니다.

// n*m단은 대체 뭐지?

const gugudan = [];

let n_dan = [];
let a = 10;
let b = 10;
for (let n = 1; n <= a; n++) {
  for (let i = 1; i <= b; i++) {
    n_dan.push(n * i);
  }
  gugudan.push(n_dan);
}
console.log(gugudan);