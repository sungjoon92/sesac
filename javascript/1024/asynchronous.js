async function fetchUrl(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();

    console.log(data);
  } catch (error) {
    // 비동기 처리 중 오류 발생 시 실행
    console.error('오류 발생');
    console.error(error.name);
    console.error(error.message);
  }
}
const url = 'https://abcnplaceholder.typicode.com/todos/1';

fetchUrl(url);
