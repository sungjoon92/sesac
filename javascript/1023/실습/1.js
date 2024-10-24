const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

const n = nums.length;
const m = nums[0].length;

// 1.  행들의 합의 값으로 리스트를 만드세요
//     - [6, 15, 24]. 즉,  [1 + 2 + 3,  4 + 5 + 6, 7 + 8 + 9]

// [6, 15, 24];
// 1. 배열을 만든다.
// 2. 6을 만든다.
// 3. 넣는다
// 4. 15를 만든다.
// 5. 넣는다.
// 6. 24를 만든다.
// 7. 넣는다.

// [1, 2, 3] 더한다 -> 6을 만든다.
// [4, 5, 6] 더한다 -> 15를 만든다.

// nums[0]를 더한다. -> 6을 만든다.

let arr;
let sum;
let result;

// arr = nums[0]; // [1, 2, 3]
// sum = 0;
// for (let num of arr) {
//   sum += num;
// }
// console.log(sum);
// result.push(sum);

// arr = nums[1]; // [4, 5, 6]
// sum = 0;
// for (let num of arr) {
//   sum += num;
// }
// console.log(sum);
// result.push(sum);

// console.log(result);

result = [];
for (let arr of nums) {
  sum = 0;
  for (let num of arr) {
    sum += num;
  }
  result.push(sum);
}
console.log(result);

console.log('--------------------');
result = [];
for (let i = 0; i < n; i++) {
  sum = 0;
  for (let j = 0; j < n; j++) {
    sum += nums[i][j];
  }
  result.push(sum);
}
console.log('--------------------');
var _ = require('lodash');

result = [];
for (let arr of nums) {
  result.push(_.sum(arr));
}
