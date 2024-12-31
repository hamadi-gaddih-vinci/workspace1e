const express = require('express');
const router = express.Router();

const Message = require('../models/Message.js');

router.get('/', (req, res) => {
    res.render('forum/forum.hbs', {messageTable: Message.list});
  });
  
router.post('/add', function (req, res, next) {
    console.log("POST ADD FORUM");
    Message.save({message: req.body.message, author: req.body.author});
    res.redirect('/forum');
  });

router.post('/like', (req,res) => {
    console.log("LIKE MESSAGE FORUM");
    Message.like(req.body.id);
    res.redirect('/forum');
});

module.exports = router;