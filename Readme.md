# Readme du Demineur

Ce projet à été realisé seul.

# Membre du projet

- BABA Ahmet


# Pour fair la documetation du jeu, il faut faire la commande suivante:

javadoc --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -d ./doc ./src/*.java


# Pour compiler et lancer le jeu, il faut faire les commandes suivantes:

javac --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -d ./bin ./src/*.java

java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -cp ./bin Executable


Il y a eu un changement fait dans le diagramme de class, j'ai utilisé une liste de liste pour mettre mes caseIntelligentes dans le plateau.
De plus j'ai fait une methode qui permet d'innonder les cases lorsque la case sur lequel on appuie a aucune bombe à proximiter.


