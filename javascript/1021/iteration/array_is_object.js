const arr = ['ken', 'jun', 'beemo'];
// array는 특수한 object
// length, 등등의 추가적인 key : value
const arr_object = {
  0: 'ken',
  1: 'jun',
  2: 'beemo',
};
// object의 key값은 String 또는 Symbol

console.log(arr_object.length);
console.log(arr.length);

console.log(arr[0]);
console.log(arr['0']);

let index = '1';
index += 1;

console.log(index);

index = '2';
index++;
console.log(index);
