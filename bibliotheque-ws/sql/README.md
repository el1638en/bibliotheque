1 - Creation d'une bdd et d'un utilisateur propriétaire de la bdd
    `psql -U postgres -a -f 1_create_db.sql`.
   
   Renseigner le mot de passe de l'utilisateur `postgres` (dans mon cas, c'est `admin`).

2 - Initialisation des données
    `psql -U bibliotheque -d bibliotheque -a -f 2_init_db.sql`.
    Renseigner le mot de passe de l'utilisateur `bibliotheque` (dans mon cas, c'est `bibliotheque`).
