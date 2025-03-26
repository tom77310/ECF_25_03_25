AuthController => InscriptionController
Ajout du template "inscription.html"
ajout du css : inscription.css => integration dans le fichier inscription.html.
/signUp => /inscription
deplacement du formulaire d'inscription depuis la page d'acceuil vers la page d'inscription
Ajout d'un titre dans la page d'acceuil
Toutes les variables de tous les models sont renommées en français 
Mise a jour de tous les fichiers pour les noms des variables des models correspondant
formulaire d'inscription complet et fonctionnel
Barre de navigation gérée en fonction des roles :
USER => toutes les pages sauf admin et inscription
ADMIN => acceuil, admin, deconnexion
SANS ROLE => acceuil, inscription
ajout du css pour la barre de navigation (ne fonctionne pas dans la page acceuil quand on est pas connecter)
redirection du logout vers l'acceuil
ajout d'un lien vers la connexion dans la barre de navigation
ajout dde la page acceuil
ajout du css de la page d'acceuil

Idée d'amelioration :
Partie admin :
Ajouter dans la barre de navigation des sections pour les messsage, 
les transactions et la liste des utilisateurs pour ne pas tout avoir dans la meme page

faire une page de login personnalisée
faire le style de la page d'inscription
faire le style du reste du site