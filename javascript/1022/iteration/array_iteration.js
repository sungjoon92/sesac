const names = ['jun', 'beemo', 'lynda'];

// 1. for of

for (let name of names) {
  console.log(name);
}

console.log('--------------');
// 2. for in

for (let index in names) {
  let name = names[index];
  console.log(name, index);
}

console.log('--------------');
// 3. for

for (let index = 0; index < names.length; index++) {
  let name = names[index];
  console.log(name, index);
}

console.log('--------------');
// 4. while

let index = 0;
while (index < names.length) {
  let name = names[index];
  console.log(name, index);
  index++;
}

console.log('--------------');
// 5. while + break

let index_ = 0;
while (true) {
  let name = names[index_];
  console.log(name, index_);
  index_++;

  if (index_ === names.length) break;
}
