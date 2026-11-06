# Grille d'auto-évaluation des bonnes pratiques

Projet : simulateur de réseau de Petri – Aslam et Arrsène.
Référence : *Guide de bonnes pratiques en génie logiciel*, IMT Atlantique, v0.8.

Légende : ✅ respectée · ⚠️ partiellement respectée · ❌ non respectée

## Organisation (O)

| Règle | État | Justification |
|---|---|---|
| O1 Faire simple | ✅ | Un seul paquetage, 9 classes, projet Maven standard. |
| O2 Documenter | ✅ | README, Javadoc de présentation sur chaque classe, livrable de conception. |
| O3 Suivre des standards | ⚠️ | Maven, JUnit 5 et conventions Java respectés ; mélange de français et d'anglais dans les noms. |
| O4 Vérifier, valider | ✅ | 50 tests JUnit couvrant les 10 exigences et les arcs zéro et videurs. |
| O5 Faire relire | ✅ | Relecture croisée du modèle de conception (voir le rapport de relecture). |

## Conception (C)

| Règle | État | Justification |
|---|---|---|
| C1 Faire simple | ✅ | Pas d'interface de service inutile (livrable, section 4.6). |
| C2 Documenter | ✅ | Diagrammes de classes et de séquence, choix justifiés dans le livrable. |
| C3 Cacher | ⚠️ | Attributs privés, `addIncomingArc`/`addOutgoingArc` en visibilité paquet ; mais les getters renvoient des listes modifiables et le constructeur `Transition(String, List, List)` est public. |

## Programmation générique (P)

| Règle | État | Justification |
|---|---|---|
| P1 Code commenté | ✅ | Javadoc sur chaque classe et sur les méthodes au comportement non évident (règles du réseau, exceptions). Pas de commentaire sur les getters ni sur les méthodes d'une ou deux lignes (annexe A : « plus n'est pas toujours mieux »). |
| P2 Style et conventions | ⚠️ | Indentation irrégulière dans `ReseauPetri.step()` et `addArc()`, espaces avant certains `;`. |
| P3 Code propre | ⚠️ | `choose()` crée un nouveau `Random` à chaque appel et retire l'élément de la liste reçue. |
| P4 Séparer les responsabilités | ✅ | La place gère ses jetons, l'arc agit sur sa place, la transition décide si elle est franchissable, le réseau choisit. |
| P5 Interfaces simples | ✅ | Trois paramètres au maximum. |
| P6 Petites unités | ✅ | Méthodes de moins de 15 lignes, sauf `addArc` (17 lignes). |
| P7 Unités simples | ⚠️ | `addArc` dépasse 4 branches (boucle, conditions composées, `if/else if`). |
| P8 Écrire un code une seule fois | ⚠️ | Contrôle du poids répété dans le constructeur d'`Arc` et dans `setWeight` ; boucles semblables dans `removePlace` et `removeTransition`. |
| P9 Pas de variables globales | ✅ | Aucune. |
| P10 Séparer spécification et réalisation | ❌ | Pas d'interface : choix assumé, une seule réalisation (livrable, section 4.6). |
| P11 Programmer en anglais | ⚠️ | Méthodes en anglais ; noms de classes, attributs et commentaires en français. |
| P12 Bien choisir les noms | ⚠️ | Noms clairs en général ; quelques noms courts (`transi`, `p`, `a`). |
| P13 Pas de *magic number* | ⚠️ | Poids `1` écrit en dur dans `ArcZero` et `ArcVideur`. |
| P14 Petits pas | ✅ | Développement par commits successifs, tests écrits classe par classe. |
| P15 Attention à `null` | ❌ | Aucun contrôle de `null` dans les constructeurs (`new ArcEntrant(null, t, 1)` est accepté). |

## Programmation objet (Po)

| Règle | État | Justification |
|---|---|---|
| Po1 Code commenté | ✅ | Voir P1. |
| Po2 Cohérence par la responsabilité | ⚠️ | Responsabilités bien réparties, mais `addArc` teste le type des arcs (`instanceof`) au lieu d'utiliser le polymorphisme. |
| Po3 Encapsulation | ⚠️ | Attributs privés, pas de `setJetons` ; mais les getters exposent les listes internes. |
| Po4 Réifier | ✅ | Chaque type d'arc est une classe ; le réseau est réifié par `ReseauPetri`. |
| Po5 Petit préférable | ✅ | Petites classes à une responsabilité. |
| Po6 Une classe calcule | ✅ | `Transition` et les arcs calculent (franchissabilité, tir) : ce ne sont pas de simples structures de données. |
| Po7 Petits pas | ✅ | Voir P14. |
| Po8 Pas de fuite d'exceptions | ⚠️ | Les `IllegalArgumentException` sont documentées (`@throws`) mais remontent à l'appelant ; pas de `main` qui les attrape. |

## Java (Pj)

| Règle | État | Justification |
|---|---|---|
| Pj1 Commenter les paquetages | ✅ | `package-info.java` dans `petri`. |
| Pj2 Conventions de nommage | ✅ | CamelCase, classes en majuscule, méthodes et variables en minuscule. |
| Pj3 Style des accolades | ✅ | Accolades systématiques, même pour une seule instruction. |
| Pj4 Séparer spécification et réalisation | ❌ | Voir P10. |
| Pj5 Packagez | ✅ | Paquetage `petri`, pas de paquetage racine. |
| Pj6 `toString`, `equals`, `hashCode` | ⚠️ | `toString` défini dans `Noeud` ; `equals` et `hashCode` non redéfinis : l'égalité par référence est voulue (livrable, section 4.7). |
