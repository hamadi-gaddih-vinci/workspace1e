SELECT * FROM bd1.albums;

SELECT *
FROM bd1.albums
WHERE editeur = 'Dupuis';

SELECT DISTINCT titre
FROM bd1.albums
WHERE scenariste = 'Sente';

SELECT DISTINCT titre, editeur
FROM bd1.albums
WHERE scenariste = 'Uderzo' OR dessinateur = 'Uderzo' OR coloriste = 'Uderzo';

SELECT *
FROM bd1.albums
WHERE coloriste IS NULL;

SELECT DISTINCT editeur
FROM bd1.albums
WHERE date_part('year', date_edition) = 1977;

SELECT DISTINCT scenariste, dessinateur
FROM bd1.albums
WHERE editeur = 'Dargaud' AND scenariste <> dessinateur;

SELECT *
FROM bd1.albums
WHERE scenariste IS NOT NULL AND dessinateur IS NOT NULL AND scenariste = dessinateur AND dessinateur<> coloriste;

SELECT *
FROM bd1.albums
WHERE scenariste = dessinateur AND scenariste = coloriste;

SELECT *
FROM bd1.albums
WHERE scenariste = coloriste AND coloriste = dessinateur
   OR scenariste = coloriste AND dessinateur IS NULL
   OR coloriste = dessinateur AND scenariste IS NULL
   OR scenariste = dessinateur AND coloriste IS NULL
   OR scenariste IS NOT NULL AND dessinateur IS NULL AND coloriste IS NULL
   OR coloriste IS NOT NULL AND dessinateur IS NULL AND scenariste IS NULL
   OR dessinateur IS NOT NULL AND coloriste IS NULL AND scenariste IS NULL;

SELECT DISTINCT scenariste
FROM bd1.albums
WHERE scenariste IS NOT NULL AND date_part('year', date_edition) >= 1980 AND prix < 12;

SELECT isbn, titre
FROM bd1.albums
WHERE (date_part('year', date_edition) > 1999 OR date_part('year', date_edition) < 1990) AND editeur <> 'Casterman' AND
      (coloriste IS NULL OR coloriste = dessinateur);

SELECT DISTINCT titre
FROM bd1.albums
WHERE editeur <> 'Casrerman' AND editeur <> 'Dupuis' AND coloriste <> dessinateur AND dessinateur <> scenariste AND scenariste <> coloriste;

SELECT *
FROM bd1.albums
WHERE (serie = 'Lucky Luke' AND editeur = 'Dargaud') OR (serie = 'Astérix' AND (editeur = 'Albert René' OR editeur = 'Le Lombard'))
   OR scenariste IS NULL AND dessinateur IS NULL AND coloriste IS NULL;

SELECT DISTINCT titre, prix
FROM bd1.albums
WHERE pays_edition = 'fr' AND (dessinateur IS NULL OR coloriste IS NULL OR (dessinateur IS NULL AND coloriste IS NULL));

SELECT isbn, titre, date_edition
FROM bd1.albums
WHERE serie = 'Astérix'
ORDER BY date_edition;

SELECT DISTINCT titre
FROM bd1.albums
WHERE serie = 'Astérix'
ORDER BY titre;

SELECT isbn, titre, editeur, date_edition
FROM bd1.albums
ORDER BY editeur, date_edition;

SELECT isbn, titre, prix
FROM bd1.albums
WHERE editeur = 'Dupuis'
ORDER BY prix DESC;

//fiche2

SELECT MIN(date_edition)
FROM bd1.albums;

SELECT MAX(prix)
FROM bd1.albums
WHERE dessinateur <> 'Uderzo';

SELECT COUNT(*)
FROM bd1.albums
WHERE editeur = 'Casterman';

SELECT AVG(prix)
FROM bd1.albums
WHERE editeur = 'Blake et Mortimer' AND date_part('year', date_edition) >= 1990 AND date_part('year', date_edition) <= 1999;

SELECT SUM(prix)
FROM bd1.albums
WHERE serie = 'Spirou';

SELECT DISTINCT titre
FROM bd1.albums
WHERE titre LIKE '%mystère%';

SELECT 3*SUM(prix-prix*0.25)
FROM bd1.albums
WHERE editeur = 'Blake et Mortimer';

SELECT MAX(date_part('year', date_edition)) - MIN(date_part('year', date_edition))
FROM bd1.albums;

SELECT DISTINCT editeur
FROM bd1.albums
WHERE editeur LIKE '% %';

//faire a partir de 30