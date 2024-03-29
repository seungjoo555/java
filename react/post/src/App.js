import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Link, Routes } from 'react-router-dom';

function App() {
  let [list, setList] = useState([{
    title: "공지사항2",
    writer: "admin",
    content: "공지사항2입니다."
  }, {
    title: "공지사항1",
    writer: "admin",
    content: "공지사항1입니다."
  }]);
  return (
    <BrowserRouter>
      <ul className="menu-list">
        <li><Link to="/">메인</Link></li>
        <li><Link to="/board/list">게시글 리스트</Link></li>
        <li><Link to="/board/insert">게시글 작성</Link></li>
      </ul>
      <Routes>
        <Route path="/" exact element={<Home />} />
        <Route path="/board/list" element={<List list={list} />} />
        <Route path="/board/insert" element={<Insert />} />
      </Routes>
    </BrowserRouter>
  );
}

function Home() {
  return (<h1>홈</h1>);
}

function List({list}) {
  return (
    <table>
      <thead>
        <tr>
          <th>제목</th>
          <th>내용</th>
          <th>작성자</th>
        </tr>
      </thead>
      <tbody>
        {
          list.map(item => {
            return (
              <tr>
                <td>{item.title}</td>
                <td>{item.content}</td>
                <td>{item.writer}</td>
              </tr>
            );
          })
        }
      </tbody>
    </table>
  );
}

function Insert() {
  return (
    <div>
      <input type="text" placeholder="제목" />
      <br />
      <input type="text" placeholder="작성자" />
      <br />
      <textarea placeholder="내용"></textarea>
      <br />
      <button>게시글 등록</button>
    </div>
  );
}

export default App;
