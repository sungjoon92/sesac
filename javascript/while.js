// 구구단 3단
const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

let index = 0;
while (index < nums.length) {
  let num = nums[index];
  index++;

  console.log(num * 3);
}

console.log('-----------------');
// 출석번호 매기기
index = 0;
const names = ['jun', 'beemo', 'ken', 'lynda'];
while (index < names.length) {
  let name = names[index];
  index++;
  console.log(index + '번 ' + name);
}

console.log('-----------------');

// 리스트 길이 구하기

console.log(names.length);
console.log('----------------');

// 리스트 합계 구하기
index = 0;
let sum = 0;
while (index < nums.length) {
  let num = nums[index];
  index++;
  sum += num;
  console.log(sum);
}

console.log('----------------');

//최소값 구하기
const nums2 = [10, 6, 8, 5, 4, 2, 3, 11];

index = 1;
while (index < nums2.length - 1) {
  let num = nums2[index - 1];
  let min = nums2[index];

  if (min > num) {
    min = num;
  }
  console.log(num, min);
  console.log(min);
  min++;
  index++;
}
console.log('========================');

for (let i = 0; i < nums2.length; i++) {
  for (let j = 0; j < i; j++) {
    if (nums2[i] > nums2[j]) {
      nums2[i] = nums2[j];
      console.log(nums2[i], nums2[j]);
    }
  }
}
