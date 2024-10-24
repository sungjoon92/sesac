const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

// 3 * 1 = 3
// 3 * 2 = 6
// 3 * 3 = 9
// 3 * 4 = 12

// 3 * num = 결과

for (let index in nums) {
  const num = nums[index];
  console.log(`3 * ${num} = ${3 * num}`);
}
console.log('-------------------');
// array, string, set
// key값을 활용하는 것이 아니라, 바로 value로 접근 가능
for (let num of nums) {
  console.log(`3 * ${num} = ${3 * num}`);
}
