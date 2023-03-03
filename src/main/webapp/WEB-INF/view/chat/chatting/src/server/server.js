//  express 모듈 호출
const express = require('express');
const http = require('http');
const WebSocket = require('ws');
const mysql = require('mysql');
const cors = require('cors');
const { Server } = require('socket.io');

const app = express();
app.use(express.json());
app.use(cors());

const server = http.createServer(app);
const PORT = 8080;
const io = new Server(server, { cors: { origin: '*', methods: ['GET', 'POST'] } });

const dbConfig = {
  host: 'localhost',
  user: 'nostal',
  password: 'dbsdud94',
  database: 'final',
};

class Database {
  constructor(config) {
    this.connection = mysql.createConnection(config);
  }
  query(sql, args) {
    return new Promise((resolve, reject) => {
      this.connection.query(sql, args, (err, rows) => {
        if (err) return reject(err);
        resolve(rows);
      });
    });
  }
  close() {
    return new Promise((resolve, reject) => {
      this.connection.end((err) => {
        if (err) return reject(err);
        resolve();
      });
    });
  }
}
const database = new Database(dbConfig);

app.post('/user/account/signin', (req, res) => {
  console.log(req.body);
  database.query('SELECT * FROM users WHERE uid=?', [req.body.uid]).then((rows) => {
    console.log(rows);
    if (rows.length === 0) res.send('wrong id');
    else if (rows[0].pwd === req.body.pwd) res.send('login complete');
    else res.send('wrong pwd');
  });
});

app.post('/user/account/signup', (req, res) => {
  database.query('SELECT id FROM users WHERE uid=?', [req.body.uid]).then((rows) => {
    console.log(rows);
    if (rows.length === 0) {
      database.query('INSERT INTO users VALUES (?, ?)', [req.body.uid, req.body.pwd]);
      res.send('create id');
    } else {
      res.send('existing id');
    }
  });
});

///

app.get('/user/:uid/rooms', (req, res) => {
  database.query('SELECT * FROM rooms WHERE uid=?', [req.params.uid]).then((rows) => {
    res.json(rows);
  });
});

app.get('/user/:uid/rooms/admin', (req, res) => {
  database.query('SELECT * FROM rooms WHERE admin_id=?', [req.params.uid]).then((rows) => {
    res.json(rows);
  });
});

app.post('/user/:uid/rooms', (req, res) => {
  database.query('SELECT * FROM rooms WHERE room=?', [req.body.room]).then((rows) => {
    if (rows.length === 0) {
      database.query('INSERT INTO rooms VALUES (?, ?, ?)', [req.params.uid, req.params.uid, req.body.room]);
      res.send('create room');
    } else res.send('existing room');
  });
});

app.post('/user/:uid/rooms/:room', (req, res) => {
  console.log(req.params);
  database.query('SELECT * FROM rooms WHERE room=?', [req.params.room]).then((rows) => {
    if (rows.length === 0) {
      res.send('not existing room');
    } else if (rows[0].uid === req.params.uid) {
      res.send('already existing room');
    } else {
      database.query('INSERT INTO rooms VALUES (?, ?, ?)', [rows[0].admin_id, req.params.uid, rows[0].room]);
    }
    res.send('join room');
  });
});

///

io.sockets.on('connection', (socket) => {
  socket.on('join_room', (room) => {
    socket.join(room);
  });
  socket.on('message', (data) => {
    socket.to(data.room).emit('message', data);
  });
});

server.listen(PORT, () => {
  console.log(`Server running on ${PORT}`);
});
