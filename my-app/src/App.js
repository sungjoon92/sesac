import React from 'react';
// 라우터
import { Routes, Route, Link } from 'react-router-dom';
// import React, { useEffect, useState } from 'react';
// css
import './styles/App.css';

// 페이지
import Home from './pages/Home';
import Second from './pages/Second';

function App() {
  // const [message, setMessage] = useState('');

  // useEffect(() => {
  //   fetch('http://localhost:8080/api/hello') // Spring Boot API 주소
  //     .then((response) => response.text())
  //     .then((data) => setMessage(data));
  // }, []);

  return (
    <div className="App">
      <header>
        <h1 id="logo">성준 메인페이지 </h1>

        <nav>
          <Link to="/">Home</Link>
          <Link to="second">second</Link>
        </nav>
      </header>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="Second" element={<Second />}></Route>
      </Routes>

      <main></main>
    </div>
  );
}

export default App;
