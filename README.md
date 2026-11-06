# Simulateur de réseau de Petri

Projet fil rouge FR-PN – IMT Atlantique, Informatique MAPD 2026-2027 – Aslam et Arsène.

Lien du github : https://github.com/aslammm-91/Petri

Ce code implémente le modèle de conception décrit dans
[`livrable_conception_reseau_petri (1) (1).pdf`](livrable_conception_reseau_petri%20(1)%20(1).pdf) :
un réseau de Petri que l'on construit (places, transitions, arcs) puis que l'on exécute pas à pas.
Il couvre les 10 exigences de l'énoncé et l'extension de l'exercice 2 (arcs zéro et arcs videurs).

## Organisation du code

```
Petri/
├── pom.xml                       configuration Maven (Java 8, JUnit 5)
├── src/main/java/petri/          le simulateur
│   ├── ReseauPetri.java          classe principale : construction et exécution du réseau
│   ├── Noeud.java                classe mère abstraite de Place et Transition (le nom)
│   ├── Place.java                une place et ses jetons
│   ├── Transition.java           une transition : sait si elle est franchissable et se tire
│   ├── Arc.java                  classe mère abstraite des arcs (poids, place, transition)
│   ├── ArcEntrant.java           arc Place -> Transition : retire des jetons
│   ├── ArcSortant.java           arc Transition -> Place : ajoute des jetons
│   ├── ArcZero.java              arc entrant actif seulement si la place est vide
│   └── ArcVideur.java            arc entrant qui vide la place
└── src/test/java/petri/          les tests JUnit 5 (une classe de test par classe)
```

Les tests sont dans `src/test/java` et non dans un dossier `tests` : c'est l'emplacement standard
imposé par Maven.

## Exemple d'utilisation

```java
ReseauPetri rp = new ReseauPetri();
Place p1 = new Place("P1", 1);
Place p2 = new Place("P2", 0);
Transition t = new Transition("T");

rp.addPlace(p1);
rp.addPlace(p2);
rp.addTransition(t);
rp.addArc(new ArcEntrant(p1, t, 1));   // P1 -> T, poids 1
rp.addArc(new ArcSortant(p2, t, 1));   // T -> P2, poids 1

rp.step(t);   // tire T, choisie par l'utilisateur : P1 = 0, P2 = 1
rp.step();    // tire une transition franchissable au hasard (ici aucune : renvoie false)
```

## Exécuter les tests

Le projet n'a pas de programme principal (`main`) : on l'exécute à travers ses tests.

**Avec IntelliJ IDEA**
1. *File → Open*, puis choisir le dossier `Petri` : IntelliJ le reconnaît comme projet Maven grâce au `pom.xml`.
2. Vérifier le JDK : *File → Project Structure → Project → SDK* = 1.8.
3. Clic droit sur `src/test/java` → *Run 'All Tests'*.

**En ligne de commande** (Maven et un JDK 8 installés)
```
mvn test
```

Résultat attendu : 50 tests, tous réussis (`BUILD SUCCESS`). Maven en affiche 100, car il lance
chaque classe deux fois : une fois seule, une fois via la suite `AllTests`.

## Environnement utilisé

| Outil | Version |
|---|---|
| IntelliJ IDEA | 2026.2.2 |
| JDK / JRE | Java 8 (OpenJDK 1.8.0_492) |
| Maven | 3.9.6 |
| JUnit | 5.11.4 (Jupiter) |

## Lien avec la conception

L'implémentation reprend le diagramme de classes du livrable : mêmes classes, mêmes attributs,
mêmes associations, et le tir suit les diagrammes de séquence (la transition active d'abord
ses arcs entrants, puis ses arcs sortants). Elle est **conforme, avec les écarts suivants** :

| Écart | Raison |
|---|---|
| Noms des méthodes en anglais (`step`, `fire`, `isFireable`, `addTokens`…) au lieu du français (`executerPas`, `franchir`…) | Bonne pratique P11 « programmer en anglais ». Correspondance : `executerPas` → `step`, `getTransitionsFranchissables` → `getFireableTransitions`, `estFranchissable` → `isFireable`, `franchir` → `fire`, `activer` → `activate`, `estActif` → `isActive`, `getPoids`/`setPoids` → `getWeight`/`setWeight`, `getJetons`/`ajouterJetons`/`retirerJetons` → `getTokens`/`addTokens`/`removeTokens`, `ajouterXxx`/`supprimerXxx` → `addXxx`/`removeXxx`, `choisir` → `choose`. |
| Getters ajoutés : `ReseauPetri.getPlaces()`, `getTransitions()`, `getArcs()`, `Transition.getIncomingArcs()`, `getOutgoingArcs()` | Nécessaires pour tester le contenu du réseau. Ils renvoient les listes elles-mêmes, ce qui affaiblit l'encapsulation (section 4.4). |
| `ReseauPetri.addArc` teste le type de l'arc (`instanceof`) pour l'enregistrer dans la bonne liste de la transition | Solution la plus simple, mais contraire au choix de la section 4.1 (variante C, sans test de type). Une version polymorphe ajouterait à `Arc` une méthode abstraite redéfinie dans `ArcEntrant` et `ArcSortant`. |
| `ReseauPetri.removeArc` retire l'arc des listes de la transition via ses getters | Pas de méthode de retrait dans `Transition` : le diagramme ne prévoyait que l'ajout. |
| Constructeur supplémentaire `Transition(String, List, List)` | Utilisé par le constructeur `Transition(String)`. Il permet aussi de créer une transition avec des arcs sans passer par `addArc`. |
| `Place.removeTokens` ne retire rien s'il n'y a pas assez de jetons, au lieu d'une précondition (section 4.8) | Choix plus simple, qui garantit `nbJetons >= 0`. En revanche, le constructeur de `Place` et `addTokens` n'interdisent pas une valeur négative. |
| `ArcEntrant.activate()` ne retire rien si l'arc n'est pas actif | Sécurité supplémentaire : `fire()` est normalement appelé après `isFireable()`. |

Les autres contraintes du livrable sont respectées : poids strictement positif (exception dans le
constructeur d'`Arc` et dans `setWeight`), un seul arc par sens entre une place et une transition
(exception dans `addArc`), poids fixé à 1 pour `ArcZero` et `ArcVideur`, et `step(t)` renvoie `false`
sans modifier le réseau si la transition n'est pas franchissable.

## Autres documents du rendu

- `GRILLE_AUTO_EVALUATION.md` : grille d'auto-évaluation des bonnes pratiques.
- Rapport de relecture, complété par les décisions finales.
