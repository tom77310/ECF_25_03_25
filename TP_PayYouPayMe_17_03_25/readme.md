AuthController => InscriptionController
Ajout du template "inscription.html"
ajout du css : inscription.css => integration dans le fichier inscription.html.
/signUp => /inscription
deplacement du formulaire d'inscription dans la page d'acceuil vers la page d'inscription
Ajout d'un titre dans la page d'acceuil
Toutes les variables de tous les models sont renommées en français 
Mise a jour de tous les fichiers pour les noms des variables des models correspondant
formulaire d'inscription complet et fonctionnel
Barre de navigation gérée en fonction des roles :
USER => toutes les pages sauf admin et inscription
ADMIN => acceuil, admin, deconnexion
SANS ROLE => acceuil, inscription