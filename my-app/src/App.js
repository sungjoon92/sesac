import React from 'react';
// 라우터
import { Routes, Route, Link } from 'react-router-dom';
// import React, { useEffect, useState } from 'react';

// css
import './styles/Home.css';

// 페이지
import Home from './pages/Home';
import Second from './pages/Second';
import Sungsan from './pages/Sungsan';
import Position from './pages/Position';

function App() {
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
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="Second">Second</Link>
            </li>
            <li>
              <Link to="Sungsan">Sungsan</Link>
            </li>
            <li>
              <Link to="Position">Position</Link>
            </li>
          </ul>
        </nav>
      </header>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="Second" element={<Second />}></Route>
        <Route path="Sungsan" element={<Sungsan />}></Route>
        <Route path="Position" element={<Position />}></Route>
      </Routes>

      <main></main>
    </div>
  );
}

export default App;
