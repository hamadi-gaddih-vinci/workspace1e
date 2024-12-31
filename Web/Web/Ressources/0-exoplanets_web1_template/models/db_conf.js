// file db_conf.js in models
// /home/olivier/user.db -> path to the db file !
// it shoud be c:/users/olivier/users.db on a windows system
const db = require('better-sqlite3')('C:/Users/hamad/Web/exoplanets.bd', { verbose: console.log });

module.exports = db;