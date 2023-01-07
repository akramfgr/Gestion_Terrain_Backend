# Localisation des terrains
 Ce projet a pour but de mettre en place une application mobile qui permet la localisation des terrains par zone et ville, la recherche d'un terrain, la reservation d'un terrain en precisant la date de reservation.Les terrains seront affiché dans une map avec la possibilité d'afficher la distance entre le client et un tel terrain ainsi que l'itinéraire.
 
 Ce projet utilise spring boot cote backend où Il traitera les demandes de  l'interface, il interrogit la base de données pour récupérer ou mettre à jour des données, et renvoit des réponses à l'interface et React cote frontend de notre application Web. Il communiquera avec le backend utiliser des API pour récupérer et mettre à jour les données.

# Fonctionnalités

1. Affichage des terrains ainsi leurs informations.

2. Possibilité de filtrer les terrains.

3. Affichage de la distance entre le client et un tel terrain selectionné et l'itineraire.

4. Réservation d'un terrain.

# étapes:

 On a crée un nouveau projet Spring Boot en utilisant l'outil de création de projets Spring Initializr.Nous avons choisi les dépendances Spring Data JPA et MySQL Driver pour le projet.

On a configuré l'application Spring Boot pour se connecter à la base de données MySQL en modifiant les propriétés de connexion dans le fichier application.properties.

Nous avons crée des entités JPA pour représenter les objets de l'application dans la base de données. Ces entités seront mappées à des tables de base de données et serviront de couche d'abstraction entre votre application et la base de données.

On a crée un repository Spring Data JPA pour chaque entité afin de gérer les opérations de persistance des objets de votre application dans la base de données.

On a crée des contrôleurs Spring MVC pour gérer les requêtes HTTP et exposer les données de votre application sous forme d'API REST.on a utilise  les repositories JPA pour récupérer et enregistrer les données auprès de la base de données.

Lancez votre application Spring Boot et testez vos API en envoyant des requêtes HTTP à l'aide d'un outil de test d'API comme Postman.

On a utilisé Spring Security pour protéger vos API et contrôler l'accès des utilisateurs.

On a testé les API en utilisant Postman.

# Mise en place du projet

Pour mettre en place ce projet, vous aurez besoin des éléments suivants :

Un éditeur de code (comme Eclipse)

Spring boot

Xampp

# Démarrage projet

Pour déployer ce projet suivez les étapes suivantes :

Téléchargez le projet sur votre ordinateur.

Ouvrez-le dans votre intellij idea par exemple.

lancer Xampp.

lancer le backend Spring boot.
