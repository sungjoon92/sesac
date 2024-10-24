const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

const n = nums.length;
const m = nums[0].length;

let total = 0;
for (let arr of nums) {
  for (let num of arr) {
    total += num;
  }
}
console.log(total);

console.log('------------------------------');

total = 0;

total += nums[0][0];
total += nums[0][1];
total += nums[0][2];

total += nums[1][0];
total += nums[1][1];
total += nums[1][2];

total += nums[2][0];
total += nums[2][1];
total += nums[2][2];

console.log('------------------------------');

total = 0;

for (i = 0; i < n; i++) {
  total += nums[i][0];
  total += nums[i][1];
  total += nums[i][2];
}
console.log(total);

console.log('------------------------------');

total = 0;

for (i = 0; i < n; i++) {
  for (j = 0; j < m; j++) {
    total += nums[i][j];
  }
}
console.log(total);

console.log('------------------------------');

total = 0;

total += nums[0][0];
total += nums[1][0];
total += nums[2][0];

total += nums[0][1];
total += nums[1][1];
total += nums[2][1];

total += nums[0][2];
total += nums[1][2];
total += nums[2][2];

console.log('------------------------------');

// nums[i][j] 의 형태는 항상 유지할 예정.
// 헷갈리지 말라고.

total = 0;
for (let j = 0; j < m; j++) {
  total += nums[0][j];
  total += nums[1][j];
  total += nums[2][j];
}
console.log(total);

console.log('------------------------------');

total = 0;
for (let j = 0; j < m; j++) {
  for (let i = 0; i < n; i++) {
    total += nums[i][j];
  }
}

console.log(total);
