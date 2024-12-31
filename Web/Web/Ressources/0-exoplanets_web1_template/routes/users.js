const express = require('express');
const router = express.Router();

/* form Login / password */
router.get('/', (req, res) => {
    console.log("USERS INDEX");
    if(req.session.login){
        res.redirect("/members");
    }
    res.render('users/login');
});

/* check Login and password */
router.post('/login', )
module.exports = router;
 /*finir  