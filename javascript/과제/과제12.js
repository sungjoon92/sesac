const posts = [
  { id: 1, title: '첫 번째 포스트', content: '첫 번째 포스트 내용' },
  { id: 2, title: '두 번째 포스트', content: '두 번째 포스트 내용' },
  { id: 3, title: '세 번째 포스트', content: '세 번째 포스트 내용' },
];

const comments = [
  { id: 1, postId: 1, content: '첫 번째 댓글' },
  { id: 2, postId: 2, content: '두 번째 댓글' },
  { id: 3, postId: 1, content: '세 번째 댓글' },
  { id: 4, postId: 2, content: '네 번째 댓글' },
  { id: 5, postId: 3, content: '다섯 번째 댓글' },
  { id: 6, postId: 2, content: '여섯 번째 댓글' },
  { id: 7, postId: 3, content: '일곱 번째 댓글' },
  { id: 8, postId: 3, content: '여덟 번째 댓글' },
  { id: 9, postId: 1, content: '아홉 번째 댓글' },
  { id: 10, postId: 3, content: '열 번째 댓글' },
];

console.log('-------------게시글 번호와 제목------------');
// 게시글 번호와 제목
for (let post of posts) {
  console.log(post.id, post.title);
}

console.log('-------------2번 게시글의 댓글------------');
// 1번 게시글의 댓글
for (let comment of comments) {
  if (comment.postId === 1) {
    console.log(comment);
  }
}

console.log('-------------모든 게시글과 댓글------------');
// 모든 게시글과 댓글
for (let post of posts) {
  console.log(post);
  let postId = post.id;
  for (let comment of comments) {
    // for (let i = 0; i <= posts.length; i++) {
    if (comment.postId === postId) {
      console.log(comment);

      // }
    }
  }
}

console.log('-------------댓글의 수------------');
// 댓글의 수

for (let post of posts) {
  let postId = post.id;
  let count = 0;

  for (let comment of comments) {
    if (comment.postId === postId) {
      count++;
    }
  }
  console.log(postId + '번 게시글의 댓글 수 ' + count);
}
