const names = ['jun', 'beemo', 'lynda'];

let name = 'jun';
console.log(`안녕 ${name}`);
name = 'beemo';
console.log(`안녕 ${name}`);

const person = {
  name: 'jun',
  age: 18,
  gender: 'm',
};

person[name];
console.log(person['name']);
console.log(person['age']);
console.log(person['gender']);

for (let index in names) {
  let name = names[index];
  console.log(`안녕 ${name}`);
}

for (let key in Object) {
}

const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

for (let i = 0; i < nums.length; i++) {
  console.log(nums[i]);

  if (nums[i] % 3 === 0) {
    console.log(nums[i] % 3 === 0);
  }
}

for (let index in nums) {
  console.log(index);
  const num = nums[index];
  console.log(`3 * ${num} = ${3 * num}`);
}

console.log('------------');
// array, string, set
// key값을 활용하는 것이 아니라 바로 value로 접근 가능
for (let num of nums) {
  console.log(`3 * ${num} = ${3 * num}`);
}

/* # names = ['jun', 'beemo', 'ken']
# ages = [18, 28, 37] 일 때,
#
# 18살 jun
# 28살 beemo
# 37살 ken
# 을 출력하시오. */

const ages = [18, 28, 37];

for (let index in names) {
  let name = name[index];
  console.log(index, name);
}
