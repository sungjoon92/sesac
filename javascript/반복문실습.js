const names = ['jun', 'beemo', 'ken', 'lynda'];

/* # names = ['jun', 'beemo', 'ken']
# ages = [18, 28, 37] 일 때,
#
# 18살 jun
# 28살 beemo
# 37살 ken
# 을 출력하시오. */

const ages = [18, 28, 37];

for (let index in names) {
  let name = names[index];
  let age = ages[index];
  index++;
  // index = index + 1;
  console.log(index, age + '살 ' + name);
}

for (let i = 0; i < names.length; i++) {
  console.log(i);
}

let count = 0;
for (_ of names) {
  count++;
}
console.log(count);
console.log('--------------');

const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

let sum = 0;
for (let i = 0; i < nums.length; i++) {
  sum += nums[i];
}
console.log(sum);

for (let index of nums) {
  sum += index;
}
console.log(sum);
