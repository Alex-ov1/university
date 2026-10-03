# Alexandre Ovu
## Description sujet TP
Ce TP a pour but de créer un Objet Membre faisant ayant un certain niveau a son domaine selon le nombre de points
qu'il a.  

On gère le type de niveau avec une classe enum qui nous permet d'interdir la création d'un nouveau niveau.

## Instructions
### Compileur
Pour compiler le programme il faut se placer dans: TP3/fichiers-tp3/tp3/src$  
Puis dans le terminal lancer: javac -d classes/ *.java

### Execution
Pour exécuter le programme il faut se placer dans: TP3/fichiers-tp3/tp3/src/classes$  
Puis dans le terminal lancer: java MemberMain

### Exemple d'exécution
```
TP3/fichiers-tp3/tp3/src/classes$ java MemberMain Apollon 17
Le membre Apollon a 17 points et est niveau OR
OR
Le membre est platine: false
Le membre timoleon a 1847 points et est niveau PLATINE
Ils ne sont pas égaux
Le membre 1 a plus de points que timoleon: false
```