# Notification Sender

Aldo et Luigi viennent d'ouvrir un camion de pizza.  

Depuis la crise du covid ils ont décidé de créer un système de notification pour la vente à emporter afin d'éviter que   
les clients encours un risque.

Luigi qui a fait un peu d'informatique pendant ses études à fait un système de notification.

Certains client mécontents n'ont pas vue les notification assé vite et ont donc manger froid.

Aldo a tout de suite pensé à une solution. Proposer des notifications sur plusieurs platforme en même temps pour   
que les clients soit sûr de savoir que leur pizza est bientôt prête.

Le problème c'est que Luigi ne voit pas comment il va faire sans avoir à créer un gros paquet classes pour avoir la  
toutes les possibilités. Il n'imagine pas ce qu'il se passera le jour où ils devront rajouter une nouvelle platforme  
de notification.

# Decorator pattern

Pour aider Luigi et Aldo nous leur proposons d'utiliser le "Decorator pattern".
Comme Luigi est déjà occupé au camion de pizza il vous demande de faire le code à sa place.

# Bonus Builder pattern 

Afin de fluidifier l'instantiation des NotificationSender implémenter un Builder pour créer tout type de notification.