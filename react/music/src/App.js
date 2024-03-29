import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom';

function App() {
  //음악을 조회하고 등록하는 사이트를 구현하세요.
  //음악 조회는 / 에서
  //음악 등록은 /insert에서
  //음악 등록시 음악번호(숫자), 제목, 가수, 장르를 입력하여 등록
  //음악 번호는 중복되지 않게 입력해서 추가
  //음악 조회에서 음악 삭제버튼을 클릭하면 삭제되도록 구현
  //    : 음악번호를 이용하여 삭제

  let [list, setList] = useState([{
    num: 1,
    title: "영화관",
    singer: "팝콘",
    genre: "팝"
  }, {
    num: 2,
    title: "아침",
    singer: "햇살",
    genre: "시티팝"
  }]);

  function addMusic(music) {
    setList([music, ...list]);
  }

  function deleteMusic(index) {
    let tmpList = list.filter((item) => item.num != index);

    setList(tmpList);
  }

  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" exact
          element={<List
            list={list}
            remove={deleteMusic}
            add={addMusic} />} />
        <Route path="/music/insert" element={<Insert />} />
      </Routes>
    </BrowserRouter>
  );
}

function Nav() {
  return (
    <ul className="menu-list">
      <li><Link to="/">음악 조회</Link></li>
      <li><Link to="/music/insert">음악 등록</Link></li>
    </ul>
  );
}


function List({ list, add, remove }) {
  //다른 페이지에서 전송한 정보를 받기 위해 location을 이용
  const location = useLocation();
  //누군가가 전송을 하면
  let music = location.state;
  if (music != null) {
    add(music);
    //처리를 했으면 전송된 정보를 비움
    location.state = null;
  }
  return (
    <table border="1">
      <thead>
        <tr>
          <th>음악 번호</th>
          <th>제목</th>
          <th>가수</th>
          <th>장르</th>
          <th>삭제버튼</th>
        </tr>
      </thead>
      <tbody>
        {
          list.map((item) => {
            return (
              <tr>
                <td>{item.num}</td>
                <td>{item.title}</td>
                <td>{item.singer}</td>
                <td>{item.genre}</td>
                <td><button onClick={() => remove(item.num)}>&times;</button></td>
              </tr>
            );
          })
        }
      </tbody>
    </table>
  );
}

function Insert() {
  let [num, setNum] = useState(0);
  let [title, setTitle] = useState("");
  let [singer, setSinger] = useState("");
  let [genre, setGenre] = useState("");

  //다른 페이지로 정보를 전송하기 위해서 navigate 사용
  const navigate = useNavigate();

  function insertMusic() {
    //첫번째 매개변수 : 보낼때 url
    //state : 상태정보
    navigate("/", {
      state: {
        num,
        title,
        singer,
        genre
      }
    })
  }
  return (
    <div>
      <h1>음악 추가</h1>
      <div>
        <input type="number" placeholder="음악번호" onChange={(e) => setNum(e.target.value)} />
        <br />
        <input type="text" placeholder="제목" onChange={(e) => setTitle(e.target.value)} />
        <br />
        <input type="text" placeholder="가수" onChange={(e) => setSinger(e.target.value)} />
        <br />
        <input type="text" placeholder="장르" onChange={(e) => setGenre(e.target.value)} />
        <br />
        <button onClick={insertMusic}>음악 등록</button>
      </div>
    </div>
  );
}

export default App;
