const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

//  1 ~ 9 순서대로 출력해보자.

// 1 ~ 3 출력하자 / 4 ~ 6 / 7 ~ 9
// [1, 2, 3] <- nums[0]

// [4, 5, 6] <- nums[1]

let arr;

for (let arr of nums) {
  for (let num of arr) {
    console.log(num);
  }
}

for (let i in nums) {
  let arr = nums[i];
  for (let j in arr) {
    let num = arr[j];
    console.log(num);
    console.log(arr[j]);
    console.log(nums[i][j]);
  }
}
const n = nums.length; // 행의 개수
const m = nums[0].length; // 열의 개수
for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    console.log(nums[i][j]);
  }
}

// arr = nums[0]; // [1, 2, 3]

// for (let num of arr) {
//   console.log(num);
// }

// arr = nums[1]; // [4, 5, 6]

// for (let num of arr) {
//   console.log(num);
// }

