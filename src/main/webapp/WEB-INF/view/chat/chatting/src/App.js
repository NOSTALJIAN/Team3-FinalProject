import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './Pages/Main';
import Signin from './Pages/Signin';
import Signup from './Pages/Signup';
import NotFound from './Pages/NotFound';
import CreateRoom from './Pages/CreateRoom';
import Room from './Pages/Room';
import JoinRoom from './Pages/JoinRoom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/chat/" element={<Signin />} />
        <Route path="/chat/signup" element={<Signup />} />
        <Route path="/chat/main" element={<Main />}></Route>
        <Route path="/chat/room/create" element={<CreateRoom />} />
        <Route path="/chat/room/join" element={<JoinRoom />} />
        <Route path="/chat/room" element={<Room />} />
        <Route path="/chat/*" element={<NotFound />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
