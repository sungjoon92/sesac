names = ['jun', 'beemo', 'ken', 'lynda'];

// // 1번 jun
// // 2번 beemo
// // 3번 ken

for (let index in names) {
  let name = names[index];
  index++;
  console.log(index, name);

  // 아래 두 경우가 안되는 이유는
  // 1. object의 key값은 string 또는 symbol, 이 경우는 string
  // 2. '1' + 1 => '11' 이 되기 때문에 정상적으로 동작하지 않음
  // index = index + 1;
  // index += 1;
}

// console.log(parseInt('1') + 1);
// console.log('1' + 1);
