import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
const express = require('express');
const logger = require('morgan');
const app = express();
const http = require('http');
const server = http.createServer(app);

const port = process.env.PORT || '3001';

app.use(logger('dev'));
app.use(express.json());
app.set('port', port);
server.listen(port);

require('./routes/chats')(app);
module.exports = app;

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
