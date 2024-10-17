import React, { useState } from 'react';
// 라우터
import { Routes, Route, Link } from 'react-router-dom';

// css
import './styles/Home.css';

// 페이지
import Home from './pages/Home';
import Form from './pages/html/form';
import Form2 from './pages/html/form2';
import Second from './pages/html/html';
import Sungsan from './pages/Sungsan';
import Position from './pages/css/Position';
import Flex from './pages/css/Flex';
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
        <div id="header-top">
          <Link to="/">
            <h1 id="logo">성준 메인페이지</h1>
          </Link>
          <Link to="https://chatgpt.com/?oai-dm=1" target="_black">
            <h2>chat GPT 도와줘!</h2>
          </Link>
        </div>

        <nav>
          <ul className="menu">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="Second">HTML</Link>
              <ul className="submenu">
                <li>
                  <Link to="form">form</Link>
                </li>
                <li>
                  <Link to="form2">form2</Link>
                </li>
              </ul>
            </li>
            <li>
              <Link to="Sungsan">CSS</Link>
              <ul className="submenu">
                <li>
                  <Link to="Position">Position</Link>
                </li>
                <li>
                  <Link to="Flex">Flex</Link>
                </li>
              </ul>
            </li>
            <li>
              <Link to="Position">javascript</Link>

              <ul className="submenu">
                <li>
                  <Link to="" target="_blank">
                    test
                  </Link>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
      </header>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="Second" element={<Second />}></Route>
        <Route path="form" element={<Form />}></Route>
        <Route path="form2" element={<Form2 />}></Route>
        <Route path="Sungsan" element={<Sungsan />}></Route>
        <Route path="Position" element={<Position />}></Route>
        <Route path="Flex" element={<Flex />}></Route>
      </Routes>

      <main></main>
    </div>
  );
}

export default App;
