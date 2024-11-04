// API 베이스 URL
const baseURL = 'http://localhost:3000';
const path = '/todos';
const params = new URLSearchParams({});

async function getTodos() {
  let URL = `${baseURL}${path}`;

  const response = await fetch(URL);
  const data = await response.json();
  return data;
}
// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
// document.addEventListener('DOMContentLoaded', initTodos);
// async function initTodos() {
//   console.log('Hello World');
// }
//변수 지정할곳
const form = document.querySelector('form');

//리스트 확인
async function getTodosList() {
  const response = await getTodos();

  const ul = document.querySelector('#todo-list');

  response.forEach((el, index) => {
    const liTag = document.createElement('li');
    const sapnTag = document.createElement('span');
    const buttonTag = document.createElement('button');
    const buttonTag2 = document.createElement('button');

    let content = el.content;
    console.log(content);

    sapnTag.textContent = content;

    liTag.append(sapnTag);
    buttonTag.id = `succes${index}`;
    buttonTag.value = '완료';
    buttonTag.textContent = '완료';
    liTag.append(buttonTag);
    buttonTag2.id = `delete${index}`;
    buttonTag2.value = '삭제';
    buttonTag2.textContent = '삭제';
    liTag.append(buttonTag2);

    ul.append(liTag);
  });
  // let deleteButton = document.querySelectorAll('ul >li>button');
  // console.log(deleteButton);

  // form.reset();
}
getTodosList();

//생성
async function addTodos() {
  let URL = `${baseURL}${path}`;

  try {
    form.addEventListener('submit', async (e) => {
      e.preventDefault();
      const formData = new FormData(form);
      const objectData = Object.fromEntries(formData);

      const response = await fetch(URL, {
        method: 'POST',
        body: JSON.stringify(objectData),
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        },
      });

      const data = await response.json();
      const { content } = data;

      const liTag = document.createElement('li');
      const sapnTag = document.createElement('span');
      const buttonTag = document.createElement('button');
      const buttonTag2 = document.createElement('button');

      sapnTag.textContent = `${content} `;
      document.querySelector('#todo-list').append(liTag);

      let list = document.querySelectorAll('#todo-list >li');
      list.forEach((list, index) => {
        list.append(sapnTag);
        buttonTag.id = `succes${index}`;
        buttonTag.value = '완료';
        buttonTag.value = '완료';
        buttonTag.textContent = '완료';
        list.append(buttonTag);
        buttonTag2.id = `delete${index}`;
        buttonTag2.value = '삭제';
        buttonTag2.textContent = '삭제';
        list.append(buttonTag2);
      });
      // form.reset();
    });
  } catch (error) {
    console.error('Error:', error);
  }
}

addTodos();

//삭제
const deleteButton = document.querySelector('li > button');

deleteButton.addEventListener('click', (e) => {
  async function deleteTodos() {
    const response2 = await getTodos();
    const deleteId = response2.id;
    let URL = `${baseURL}${path}${deleteId}`;

    const response = await fetch(URL, {
      method: 'DELETE',
    });
    const data = response.json();
  }
  deleteTodos();
});
