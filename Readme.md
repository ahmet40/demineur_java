# Readme du Demineur

Ce projet à été realisé seul.

# Membre du projet

- BABA Ahmet


# Pour fair la documetation du jeu, il faut faire la commande suivante:

javadoc --module-path  lien/vers/openjfx/lib  --add-modules javafx.controls -d ./doc ./src/*.java


# Pour compiler et lancer le jeu, il faut faire les commandes suivantes:

javac --module-path lien/vers/openjfx/lib --add-modules javafx.controls -d ./bin ./src/*.java

java --module-path lien/vers/openjfx/lib--add-modules javafx.controls -cp ./bin Executable

# problème pouvant être rencontrer

Si vous n'arriver pas à compiler le jeu, c'est que vous n'avez pas la librairie javafx, il faut donc la télécharger et mettre le lien vers la librairie dans le chemin du module.

De plus il se pourrait que vous soyez amenez à changer le chemin du module dans les fichier launch.json et settings.json.

- Dans le fichier setting.json, il faut changer le chemin du module dans la liste vous devez simplement changer le chemin du module.

- Dans le fichier launch.json, il faut changer le chemin du module dans la liste vous devez simplement changer le chemin du module.

exemple de chemin du module:
 "vmArgs": "--module-path /test/openjfx/lib --add-modules javafx.controls,javafx.fxml",
            "mainClass": "Executable",

il faut changer le chemin /test/openjfx/lib par le chemin de votre librairie javafx.