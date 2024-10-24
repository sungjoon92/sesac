const first = () => {
  console.log('first 동기 작업 1');
};

const second = () => {
  setTimeout(() => {
    console.log('second 비동기 작업 1초');
  }, 1000);
};

const third = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('third 비동기 작업 0.5초1');
      resolve(); // 작업이 완료되면 resolve 호출
    }, 500);
  });
};
// third()가 완료된 후에 다음 작업을 실행
third().then(() => {
  console.log('third then');
  setTimeout(() => {
    console.log('third2 비동기 작업 0.5초2');
  }, 500);
});

const fourth = () => {
  console.log('fourth 동기 작업 2');
};

first();
second();
fourth();
