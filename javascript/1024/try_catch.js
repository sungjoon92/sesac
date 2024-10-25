function checkAge(num) {
  if (typeof num !== 'number') {
    throw new Error('숫자가 아닙니다.');
  } else if (num < 0) {
    throw new Error('나이가 음수입니다.');
  }
  console.log(num + 1);
}

try {
  // checkAge('문자열'); // Error 발생
  checkAge(-3); // Error 발생
  // checkAge(3); // Error 발생X
} catch (error) {
  console.error(error.message); // 숫자가 아닙니다.
  console.log(error.message); // 숫자가 아닙니다.
} finally {
  console.log('어찌됐건 실행됨.');
}
