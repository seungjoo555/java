import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom';

function App() {
  let [state, setState] = useState([{
    id: 1,
    title: "Movie 1",
    genre: "Drama",
    release_date: "2022-01-01"
  }, {
    id: 2,
    title: "Movie 2",
    genre: "Action",
    release_date: "2022-02-01"
  }, {
    id: 3,
    title: "Movie 3",
    genre: "Comedy",
    release_date: "2022-03-01"
  }]);

  function addMusic(music) {
    setState([music, ...state]);
  }

  function deleteMusic(id) {
    let tmpList = state.filter(item => item.id != id);
    setState(tmpList);
  }

  return (
    <BrowserRouter>
      <ul className="menu-list">
        <li><Link to="/">List</Link></li>
        <li><Link to="/add">Add New Movie</Link></li>
      </ul>
      <Routes>
        <Route path="/"
          element={
            <List list={state}
              remove={deleteMusic}
              add={addMusic} />} />
        <Route path="/add" element={<Add />} />
      </Routes>
    </BrowserRouter>
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
    <div>
      <h1>Movies</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item) => {
              return (
                <tr>
                  <td>{item.id}</td>
                  <td>{item.title}</td>
                  <td>{item.genre}</td>
                  <td>{item.release_date}</td>
                  <td><button onClick={() => remove(item.id)}>Delete</button></td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  );
}

function Add() {
  let [id, setId] = useState("");
  let [title, setTitle] = useState("");
  let [genre, setGenre] = useState("");
  let [release_date, setRelease_date] = useState("");

  //다른 페이지로 정보를 전송하기 위해서 navigate 사용
  const navigate = useNavigate();

  function addMusic() {
    //첫번째 매개변수 : 보낼때 url
    //state : 상태정보
    navigate("/", {
      state: {
        id,
        title,
        genre,
        release_date
      }
    });
    setId("");
    setTitle("");
    setGenre("");
    setRelease_date("");
  }

  return (
    <div>
      <h1>Create Movie</h1>
      <div class="input-group">
        <input type="text" placeholder="Input movie id" onChange={(e) => setId(e.target.value)} />
        <br />
        <input type="text" placeholder="Input movie title" onChange={(e) => setTitle(e.target.value)} />
        <br />
        <input type="text" placeholder="Input movie genre" onChange={(e) => setGenre(e.target.value)} />
        <br />
        <label htmlFor="">출시일:</label>
        <input type="date" placeholder="Input Date" onChange={(e) => setRelease_date(e.target.value)} />
        <br />
        <button onClick={addMusic}>Add Movie</button>
      </div>
    </div>
  );
}

export default App;
