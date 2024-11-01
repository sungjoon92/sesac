console.log('-------원하는 값 확인-------');

// fetch('https://jsonplaceholder.typicode.com/posts/1')
//   .then((response) => response.json())
//   .then((json) => console.log(json.title))
//   .catch((error) => console.error(error));

// async function getPost(postId) {
//   const response = await fetch(
//     `https://jsonplaceholder.typicode.com/posts/${postId}`
//   );
//   const data = await response.json();
//   // console.log(response.json());
//   console.log(data);
// }

// getPost(3);
console.log('-------생성-------');

async function createPost() {
  try {
    /* https://jsonplaceholder.typicode.com/posts */
    const response = await fetch('http://localhost:3000/todos', {
      method: 'POST',
      body: JSON.stringify({
        id: '1',
        content: '예습 하기',
        completed: false,
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}
createPost();

console.log('-------리스트확인-------');

async function getPosts() {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts`);
  const data = await response.json();

  data.forEach((value) => {
    console.log(value.title);
  });
  console.log(data);
}
getPosts();

console.log('-------수정-------');
async function updatePost() {
  try {
    const response = await fetch(
      'https://jsonplaceholder.typicode.com/posts/1',
      {
        method: 'PUT',
        body: JSON.stringify({
          id: 1,
          title: 'foo',
          body: 'bar',
          userId: 1,
        }),
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        },
      }
    );
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

updatePost();

console.log('-------삭제-------');

async function deletePost() {
  const response = await fetch(
    'https://jsonplaceholder.typicode.com/posts/100',
    {
      method: 'DELETE',
    }
  );
  console.log('삭제완료');
}
deletePost();
