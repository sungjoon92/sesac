import React, { useState } from 'react';
// 라우터
import { Routes, Route, Link } from 'react-router-dom';

// css
import './styles/Home.css';

// 페이지
import Home from './pages/Home';
import Second from './pages/Second';
import Sungsan from './pages/Sungsan';
import Position from './pages/Position';
import Flex from './pages/Flex';
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"
></script>;

function App() {
  // useEffect(() => {
  //   fetch('http://localhost:8080/api/hello') // Spring Boot API 주소
  //     .then((response) => response.text())
  //     .then((data) => setMessage(data));
  // }, []);
  // 서브메뉴 표시 여부를 관리하는 상태
  const [showSubmenu, setShowSubmenu] = useState(false);

  return (
    <div className="App">
      <header>
        <h1 id="logo">성준 메인페이지 </h1>

        <nav>
          <ul className="menu">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="Second">Second</Link>
            </li>
            <li>
              <Link to="Sungsan">Sungsan</Link>
            </li>
            <li
              onMouseEnter={() => setShowSubmenu(true)} // 마우스 오버 시 서브메뉴 표시
              onMouseLeave={() => setShowSubmenu(false)} // 마우스 아웃 시 서브메뉴 숨김
            >
              <Link to="Position">Position</Link>
              {showSubmenu && (
                <ul className="submenu">
                  <li>
                    <Link to="Flex">Flex</Link>
                  </li>
                </ul>
              )}
            </li>
          </ul>
        </nav>
      </header>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="Second" element={<Second />}></Route>
        <Route path="Sungsan" element={<Sungsan />}></Route>
        <Route path="Position" element={<Position />}></Route>
        <Route path="Flex" element={<Flex />}></Route>
      </Routes>

      <main></main>
    </div>
  );
}

export default App;
