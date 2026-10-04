# TP4 – Gestion d'un hôtel

**Nom : Alexandre Ovu**

## 1. Présentation du TP

Ce TP consiste à réaliser une application permettant de gérer un hôtel et ses chambres en programmation orientée objet.

L'application permet notamment de :

* créer un hôtel avec un nombre donné de chambres ;
* attribuer un statut aux chambres (`CONFORT`, `COSY` ou `PREMIUM`) ;
* récupérer une chambre à partir de son numéro ;
* louer une chambre ;
* libérer une chambre ;
* connaître le nombre de chambres disponibles ;
* rechercher le premier numéro de chambre disponible.

Les classes principales du projet sont `Hotel`, `Room`, `HotelMain`, `RoomMain` ainsi que l'énumération `Status`.

Des tests JUnit sont également présents afin de vérifier le bon fonctionnement des différentes fonctionnalités.

---

## 2. Intelligence Artificielle générative

L'IA a notamment été utilisée pour écrire ce readme.

**Prompt utilisé :**

* « Fais-moi un exemple de README que je peux remplir pour mon TP de POO. »
---

## 3. Fonctionnalités réalisées

Les fonctionnalités suivantes ont été réalisées :

* création d'un hôtel avec un nombre de chambres donné ;
* création automatique des chambres ;
* attribution d'un statut aux chambres ;
* récupération d'une chambre par son numéro ;
* vérification de la validité d'un numéro de chambre ;
* location d'une chambre ;
* gestion de l'exception `RoomNotAvailableException` ;
* libération d'une chambre ;
* comptage des chambres libres ;
* recherche de la première chambre libre ;
* création et exécution de tests JUnit.

Les tests vérifient notamment la création des chambres, leur statut, la location et la libération des chambres ainsi que le comportement lorsque le numéro de chambre est invalide ou lorsqu'une chambre est déjà louée.

---

## 4. Fonctionnalités non réalisées / problèmes connus

Si tout fonctionne correctement :

> Les fonctionnalités demandées ont été réalisées. Aucun problème particulier n'a été identifié lors des tests.

---

## 5. Ajouts éventuels

Si aucun ajout :

> Aucun ajout particulier n'a été réalisé par rapport au cahier des charges.

---

## 6. Génération de la documentation

Depuis le dossier `fichiers-tp4`, utiliser la commande :

```bash
javadoc -sourcepath src -subpackages hotel -d docs
```

La documentation sera générée dans le dossier `docs`.

Pour consulter la documentation, ouvrir :

```text
docs/index.html
```

---

## 7. Compilation du projet

Depuis le dossier `fichiers-tp4` :

```bash
mkdir -p classes
```

Puis compiler les sources :

```bash
javac -sourcepath src src/hotel/*.java src/hotel/util/*.java -d classes
```

---

## 8. Compilation des tests

Compiler les tests avec :

```bash
javac -classpath junit-console.jar:classes test/hotel/*.java -d test
```

---

## 9. Exécution des tests

Pour exécuter tous les tests :

```bash
java -jar junit-console.jar -classpath test:classes -scan-classpath
```

Les tests permettent notamment de vérifier :

* la création des chambres ;
* le statut des chambres ;
* le nombre de chambres ;
* la location d'une chambre ;
* les exceptions lors d'une location impossible ;
* la libération d'une chambre ;
* le nombre de chambres libres ;
* le premier numéro de chambre libre ;
* les méthodes de la classe `Room`, notamment `rent`, `free` et `equals`.

---

## 10. Exécution du programme sans JAR

### HotelMain

Le programme principal peut être exécuté avec :

```bash
java -classpath classes hotel.HotelMain
```

Le programme attend un numéro de chambre en argument.

Par exemple :

```bash
java -classpath classes hotel.HotelMain 12
```

Avec cet exemple, le programme tente de louer la chambre numéro 12.

Si le numéro n'est pas fourni, le programme affiche un message indiquant l'utilisation attendue.

Un numéro invalide ou non entier est également géré par le programme.

### RoomMain

La classe `RoomMain` peut être exécutée avec :

```bash
java -classpath classes hotel.RoomMain
```

Elle crée une chambre et affiche sa représentation.

---

## 11. Création du JAR exécutable

Pour créer le JAR exécutable de l'application principale :

```bash
jar cvfe appli.jar hotel.HotelMain -C classes .
```

Cela crée le fichier :

```text
appli.jar
```

---

## 12. Exécution du JAR

Le programme peut ensuite être exécuté avec :

```bash
java -jar appli.jar
```

Avec un numéro de chambre :

```bash
java -jar appli.jar 12
```

---

## 13. Structure du projet

```text
TP4/
├── README.md
├── .gitignore
├── junit-console.jar
├── src/
│   └── hotel/
│       ├── Hotel.java
│       ├── HotelMain.java
│       ├── Room.java
│       ├── RoomMain.java
│       ├── RoomNotAvailableException.java
│       └── util/
│           └── Status.java
└── test/
    └── hotel/
        ├── HotelTest.java
        ├── RoomTest.java
        └── RoomSecondTest.java
```

Les dossiers générés `classes/` et `docs/` ne doivent pas être ajoutés au dépôt GitLab.

Les fichiers JAR générés doivent également être exclus du dépôt avec le `.gitignore`.

---

## 14. Résumé des commandes

### Documentation

```bash
javadoc -sourcepath src -subpackages hotel -d docs
```

### Compilation

```bash
mkdir -p classes
javac -sourcepath src src/hotel/*.java src/hotel/util/*.java -d classes
```

### Compilation des tests

```bash
javac -classpath junit-console.jar:classes test/hotel/*.java -d test
```

### Tests

```bash
java -jar junit-console.jar -classpath test:classes -scan-classpath
```

### Programme

```bash
java -classpath classes hotel.HotelMain 12
```

### JAR

```bash
jar cvfe appli.jar hotel.HotelMain -C classes .
```

### Exécution du JAR

```bash
java -jar appli.jar 12
```
