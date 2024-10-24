const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

const n = nums.length;
const m = nums[0].length;

let result;
let sum;

result = [];

sum = 0;
nums[0][0];
nums[1][0];
nums[2][0];
// 위 3개의 합계 더하기
// 더한것을 array에 넣어주기
result.push(sum);

sum = 0;
nums[0][1];
nums[1][1];
nums[2][1];
// 위 3개의 합계 더하기
// 더한것을 array에 넣어주기
result.push(sum);

sum = 0;
nums[0][2];
nums[1][2];
nums[2][2];
// 위 3개의 합계 더하기
// 더한것을 array에 넣어주기
result.push(sum);

console.log('-------------------------');
result = [];
for (let j = 0; j < m; j++) {
  sum = 0;
  sum += nums[0][j];
  sum += nums[1][j];
  sum += nums[2][j];
  result.push(sum);
}

console.log('-------------------------');
result = [];
for (let j = 0; j < m; j++) {
  sum = 0;
  for (let i = 0; i < n; i++) {
    sum += nums[i][j];
  }
  result.push(sum);
}

console.log(result);
