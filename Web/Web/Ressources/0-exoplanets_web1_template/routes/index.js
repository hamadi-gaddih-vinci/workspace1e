const express = require('express');
const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  console.log("Je passe par la route /");
  const today = new Date();
  /* Attention Date.now() est tentant mais renvoie une valeur numérique et non un objet Date
  donc impossible de faire ceci par exemple
  let now = Date.now(); 
  now.getFullYear()*/
  const todayString = "Nous sommes le " + today.getDate() + "/" + (today.getMonth() + 1) + "/" + today.getFullYear() + ".";
  const hourtodayString = "Il est " + today.getHours() + ":" + today.getMinutes() + " à Bruxelles";
  // today -> name of variable to pass to hbs
  // after : -> concatenation of two string as value of today
  res.render('index.hbs', { today: todayString + " " + hourtodayString });
});


/*router.get('/moi', (req, res) => {
  console.log("Je suis bien passer ici /listeplanetes");
  let listeplanetes = [];
  let mars = { name : "Mars"};
  let jupiter = { name: "Jupiter"};
  listeplanetes.push(mars, jupiter);
  res.render('moi.hbs', {listeplanetes});
});*/

/*router.get('/exolunes', (req, res) => {
  const listeExolunes = [];
  const DHTauri = {name : "DH Tauri"};
  const Kepler = {name : "Kepler-409"};
  const Wasp = {name : "WASP-49"};
  listeExolunes.push(DHTauri,Kepler,Wasp);
  const date = new Date();
  const ajd = "Nous sommes le " + date.getDay() + "/" + date.getMonth() + "/" + date.getFullYear() + date.getHours() + ":" + date.getMinutes() + " à Bruxelles";
  res.render('exolunes.hbs', {listeExolunes, varDate:ajd});
 
});

router.get('/forum', function (req, res, next) {
  res.render('forum.hbs', {messageTable});                
});

router.post('/forum/add', function (req, res, next) {
  console.log("POST ADD FORUM");
  messageTable.push({message: req.body.message, author: req.body.author});
  res.redirect('/forum');
});*/


module.exports = router;