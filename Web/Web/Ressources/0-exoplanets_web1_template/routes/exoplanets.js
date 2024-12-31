const express = require('express');
const { name } = require('../models/db_conf.js');
const router = express.Router();

const Exoplanet = require("../models/Exoplanets.js");

router.get('/', function (req, res, next) {
  const exoplanetsTable = Exoplanet.list();
  console.log(exoplanetsTable);
  res.render('exoplanets/exoplanets.hbs', { exoplanetsTable });
});

router.post('/add', function (req, res, next) {
  console.log("POST ADD EXOPLANET");
  
  const unique_name = req.body.unique_nameExoplanet;
  const hClass = req.body.hClassExoplanet;
  const discovery_year = req.body.discovery_yearExoplanet;
  const ist = req.body.istExoplanet;
  const pClass = req.body.pClassExoplanet;

  Exoplanet.add(unique_name, hClass, discovery_year, ist, pClass);
  res.redirect('/exoplanets');
});


router.get('/search', function (req, res, next) {
  console.log("GET SEARCH EXOPLANET");
  const unique_nameExoplanetParam = req.query.unique_nameExoplanet;
  let min3charOK = false;
  let exoplanetFound = null;
  if (unique_nameExoplanetParam.length >= 3) {
    min3charOK = true;
    exoplanetsTable = Exoplanet.search(unique_nameExoplanetParam);
    
  }
  res.render('exoplanets/exoplanets.hbs', { exoplanetsTable, min3charOK});
});

router.post('/delete', (req, res, next) => {
  console.log("id Exoplanète à supprimer : " + req.body.id);
  Exoplanet.delete(req.body.id);
  res.redirect('/exoplanets');
});

router.get('/details', function (req, res, next) {
  console.log("GET DETAILS EXOPLANET");
  const exoplanetIdParam = parseInt(req.query.id);
  const exoplanetFound = Exoplanet.findById(exoplanetIdParam);
  res.render('exoplanets/details.hbs', { exoplanet: exoplanetFound });
});

router.get('/filter', function(req, res, next){
    const filter = req.query.filter;
    let exoplanetsTableFilter = [];
    if(filter === "Filtrer par hClass"){
      console.log("GET FILTER EXOPLANET HCLASS");
      exoplanetsTableFilter = Exoplanet.searchByHclass(req.query.hClassExoplanet);
        }
    if(filter === "Filtrer par année"){
      console.log("GET FILTER EXOPLANET ANNEE");
      const discoveryYearParam = parseInt(req.query.discoveryYearExoplanet);
      exoplanetsTableFilter = Exoplanet.searchByYear(discoveryYearParam);
    }
    res.render('exoplanets/exoplanets.hbs', {exoplanetsTable: exoplanetsTableFilter});
});

router.get('/update', function (req, res, next){
  console.log("GET UPDATE EXOPLANET");
  const exoplanetIdParam = parseInt(req.query.id);
  const exoplanetFound = Exoplanet.findById(exoplanetIdParam);
  res.render('exoplanets/update.hbs', {exoplanet: exoplanetFound});
});

router.post('/update', function (req, res, next){
  console.log("POST UPDATE EXOPLANET");
  Exoplanet.save({
    id: parseInt(req.body.id),
    unique_name: req.body.unique_name,
    hClass: req.body.hClass,
    discovery_year: parseInt(req.body.discovery_year),
    ist: parseFloat(req.body.ist),
    pClass: req.body.pClass
  });

  res.redirect('/exoplanets');
});
module.exports = router;