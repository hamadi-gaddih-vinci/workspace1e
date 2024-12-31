const db = require('../models/db_conf');
module.exports.list = () => {
    const stmt_all = db.prepare("SELECT exoplanet_id AS id, unique_name, hclass AS hClass, discovery_year, ist, pclass AS pClass FROM exoplanets");
    return stmt_all.all();
};
// On peut également écrire 
// module.exports.list = () => exoplanetsTable;
/*module.exports.save = (data) => {
    const id = exoplanetsTable.length + 1;
    data.id = id;
    exoplanetsTable.push(data);
};*/
module.exports.save = (data) => {
    console.log("SAVE :" + JSON.stringify(data));
    //no id => add exoplanet
    if(data.id === undefined){
        const stmt = db.prepare('INSERT INTO EXOPLANETS(unique_name, hclass, discovery_year) VALUES (?, ?, ?)');
        const info = stmt.run(data.unique_name, data.hClass, data.discovery_year);
        console.log("exoplanet model save" + info.changes);
    }
    //id => update exoplanet
    else{
        const stmt = db.prepare('UPDATE EXOPLANETS SET unique_name = ?, hclass = ?, discovery_year = ?, ist = ?, pclass = ? WHERE exoplanet_id = ?');
        const info = stmt.run(data.unique_name, data.hClass, data.discovery_year, data.ist, data.pclass, data.id);
        console.log("exoplanet model save update" + info.changes);
    }
}
module.exports.search = (unique_name) => {
    /*for(const exoplanet of exoplanetsTable){
        if(exoplanet.unique_name.toUpperCase().startsWith(unique_name.toUpperCase())){
            console.log("trouvé");
            return exoplanet;}}return null;*/
// all() -> return alls rows in a table of objects like below
// [ {id:1, name:'user1', pseudo:'oli'}, {id:2, name:'user2', pseudo:'stef'}]
return db.prepare('SELECT exoplanet_id AS id, unique_name, hclass AS hClass, discovery_year, ist, pclass AS pClass FROM exoplanets WHERE unique_name LIKE ?').all(unique_name+'%');
};
module.exports.add = (unique_name, hclass, discovery_year, ist, pclass) => {
    const stmt_insert = db.prepare('INSERT INTO exoplanets (unique_name, hclass, discovery_year, ist, pclass) VALUES (?, ?, ?, ?, ?)');
//run -> return infos about changes made
    const info = stmt_insert.run(unique_name, hclass, discovery_year, ist, pclass);
};

module.exports.delete = (id) => {
    console.log(id);
    const info = db.prepare('DELETE FROM EXOPLANETS WHERE exoplanet_id = ? ').run(id);
    console.log("exoplanet model delete" + info.changes);
};

module.exports.findById = (id) => {
  return db.prepare('SELECT * FROM exoplanets WHERE exoplanet_id = ?').get(id);
};

module.exports.searchByHclass = (hClass) => {
    return db.prepare('SELECT exoplanet_id AS id, unique_name, hclass AS hClass, discovery_year, ist, pclass AS pClass FROM EXOPLANETS WHERE hclass = ?').all(hClass);
}

module.exports.searchByYear = (discovery_year) => {
    return db.prepare('SELECT exoplanet_id AS id, unique_name, hclass AS hClass, discovery_year, ist, pclass AS pClass  FROM EXOPLANETS WHERE discovery_year = ?').all(discovery_year);
}