const express = require('express');
const cors = require('cors');
const mysql = require('mysql');
const app = express();
const PORT = 8080;

const db = mysql.createPool({
  host: 'localhost',
  user: 'nostal',
  password: 'dbsdud94',
  database: 'final',
});

app.use(
  cors({
    origin: '*',
    credentials: true,
    optionsSuccessStatus: 200,
  })
);

app.use(express.urlencoded({ extended: true }));

app.listen(PORT, () => {
  console.log(`server running on port ${PORT}`);
});

app.get('/api/users', (req, res) => {
  res.header('Access-Control-Allow-Origin', '*');

  const sqlQuery = 'SELECT * FROM users';

  db.query(sqlQuery, (err, result) => {
    res.send(result);
  });
});
