import React from 'react';
import Profile from './ProFfile';
import Subpage from './subpage';
function 이거슨html() {
  return (
    <div>
      <h1>111</h1>
      <div>
        <a href="./subpage" target="_blank">
          subpage
        </a>
      </div>
    </div>
  );
}

export default function App() {
  return (
    <div>
      App
      <div>
        <Profile />
        <이거슨html />
        <Subpage></Subpage>
      </div>
    </div>
  );
}
