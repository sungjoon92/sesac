// API 베이스 URL
const URL = 'http://localhost:3000/todos';

// #todo-list === ul
const todoListTag = document.querySelector('#todo-list');
// #add-todo === button
const addButton = document.querySelector('#add-todo');

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos);

///////////////////////////////////////////////////////////////////
// 상태변경
// 완료 버튼을 눌렀을 때 => 취소선이 그어지고 / 취소선이 그어진 상태에서는 없어짐
// compoleted => true / false 토글
// db에 반영

///////////////////////////////////////////////////////////////////
// Todo 생성

// 데이터의 관점
// 데이터를 받아다가 db에 저장한다

// 사용자의 관점
// 1. 데이터를 입력한다
// 2. 추가 버튼을 누른다.
// -> todo가 추가된다.

// front의 관점
// 사용자의 관점 (입력을 받아서 추가버튼을 누르면)
// 데이터의 관점 (db에 저장을 시키고)
// 데이터를 rendering한다.

// 버튼을 누르면 동작이 실행됨.

// 초기값 세팅
async function initTodos() {
  // 1. 데이터 가져오기
  const todos = await fetchTodos();
  // 2. 데이터 보여주기

  renderTodos(todos);
}
//////////////////////////////////////////////////////

// Todos json 형태로 가져오기.
async function fetchTodos() {
  // const URL = 'http://localhost:3000/todos';
  const response = await fetch(URL);
  const data = await response.json();
  return data;
}

//////////////////////////////////////////////////////

// todos를 입력받아 보여주기.
function renderTodos(todos) {
  todos.forEach((todo) => {
    renderTodo(todo);
  });
}

//////////////////////////////////////////////////////

// 글 생성 클릭 이벤트
addButton.addEventListener('click', addTodo);
// 글 생성
async function addTodo() {
  // 입력을 받아다가 => db에 저장하고 => 보여준다.
  const inputTag = document.querySelector('#todo-input');
  const value = inputTag.value;

  const data = await postTodo(value);

  renderTodo(data);

  inputTag.value = '';
}
// 글 생성 patch
async function postTodo(value) {
  const response = await fetch(URL, {
    method: 'POST',
    body: JSON.stringify({
      content: value,
      completed: false,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();

  return data;
}

//////////////////////////////////////////////////////

// completed 수정 patch
async function patchTodo(todo) {
  const { id } = todo;

  const response = await fetch(URL + '/' + id);
  const data = await response.json();
  const { completed } = data;
  // spanTag가 completed class를 가지고 있니?
  // 에서, completed class는 사용자가 controll할 수 있는 정보이기 때문에
  // 다시 서버에 요청을 보내 정확한 데이터를 가지고 동작을 하도록 하였다.
  // react에서는 state로 관리할 수 있다.

  const responsePatch = await fetch(URL + '/' + id, {
    method: 'PATCH',
    body: JSON.stringify({
      completed: !completed,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const dataPatch = await responsePatch.json();
  return dataPatch;
}

//////////////////////////////////////////////////////
// content 수정 patch
async function patchContent(todo) {
  const { id, content } = todo;
  const responsePatch = await fetch(URL + '/' + id, {
    method: 'PUT',
    body: JSON.stringify({
      content: content,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const dataPatch = await responsePatch.json();
  return dataPatch;
}
//////////////////////////////////////////////////////

// 삭제 patch
async function deleteTodo(todo) {
  const { id } = todo;
  const response = await fetch(URL + '/' + id, {
    method: 'DELETE',
  });
}

//////////////////////////////////////////////////////

// 태그 생성, 수정, 삭제 (기능)
function renderTodo(todo) {
  // liTag 변수에 li태그 생성문 주입
  const liTag = document.createElement('li');

  // span태그 만들기
  const spanTag = document.createElement('span');

  // const content = todo.content;
  // const completed = todo.completed;
  const { content, completed } = todo;

  spanTag.textContent = content;
  if (completed) {
    spanTag.classList.add('completed');
  }

  // complete 수정
  const completeButton = document.createElement('button');
  completeButton.textContent = '완료';
  completeButton.addEventListener('click', async (e) => {
    // 단순한 토글이 아니라, database의 patch가 성공하면 toggle해
    const data = await patchTodo(todo);
    const { completed } = data;
    // spanTag.classList.toggle('completed');
    if (completed) {
      spanTag.classList.add('completed');
    } else {
      spanTag.classList.remove('completed');
    }
  });

  // content 수정
  const contentbutton = document.createElement('button');
  const contentInput = document.createElement('input');
  const contentSuccesButton = document.createElement('button');

  // 수정 버튼 클릭시 input 도출
  contentbutton.textContent = '수정';
  contentbutton.addEventListener('click', async () => {
    const data = await patchContent(todo);
    const { content } = data;
    liTag.append(contentInput);
    liTag.append(contentSuccesButton);
    contentInput.value = content;
    contentSuccesButton.textContent = '변경';

    // 변경 button 클릭시 contentInput의 값 변경
    contentSuccesButton.addEventListener('click', async () => {
      spanTag.textContent = contentInput.value;
    });
  });

  // delete
  const deleteButton = document.createElement('button');
  deleteButton.textContent = '삭제';
  deleteButton.addEventListener('click', async () => {
    await deleteTodo(todo);
    liTag.remove();
  });

  liTag.append(spanTag, completeButton, deleteButton, contentbutton);
  todoListTag.append(liTag);
}
