// 몰라도 됨

const applyOperation = (func, number) => {
  return func(number);
};

const double = (x) => x * 2;
const triple = (x) => x * 3;
const quadra = (x) => x * 4;

// console.log(applyOperation(double, 5));

const functions = [double, triple, quadra];

for (let func of functions) {
  const result = applyOperation(func, 5);
  console.log(result);
}

// double(5);
// triple(5);
// quadra(5);
// five(x);
