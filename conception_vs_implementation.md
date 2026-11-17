## Question 7.2 – Diagramme de classes de notre implémentation

![Diagramme de notre projet](../Diagramme_rétro-ingénierie.png)

Le diagramme généré à partir du paquetage `petri` montre :
- **Héritage** : `Noeud` → `Place`, `Transition` ; `Arc` → `ArcEntrant`, `ArcSortant` ; `ArcEntrant` → `ArcZero`, `ArcVideur`. `Noeud` et `Arc` sont abstraites.
- **Associations** : l'outil ne dessine que les flèches d'héritage ; les associations se lisent dans les attributs typés de chaque boîte : `ReseauPetri` → `Place`, `Transition`, `Arc` (`List<Place>`, `List<Transition>`, `List<Arc>`) ; `Arc` → `Place` et `Arc` → `Transition` (attributs `place` et `transition`) ; `Transition` → `ArcEntrant` et `Transition` → `ArcSortant` (propriétés `incomingArcs`, `outgoingArcs`).
- **Méthodes** : `activate()` abstraite dans `Arc`, redéfinie dans les 4 sous-classes ; `isActive()` dans `ArcEntrant`, redéfinie dans `ArcZero` et `ArcVideur`.
- **Propriétés** : l'outil regroupe chaque getter avec l'attribut qu'il lit et l'affiche comme une « propriété » (icône *p*) : `tokens` pour `getTokens()`, `weight` pour `getWeight()`, `fireable` pour `isFireable()`, `active` pour `isActive()`, `incomingArcs`/`outgoingArcs` pour les getters de `Transition`. C'est pourquoi `nbJetons`, `poids`, `arcsEntrants` et `arcsSortants` n'apparaissent que sous le nom de leur getter.
- **Visibilités** : les attributs sont tous privés (cadenas) ; `choose` est privée ; `addIncomingArc` et `addOutgoingArc` ont la visibilité paquet, comme prévu en conception.

---

## Question 7.3 – Comparaison avec le modèle de conception

**Le modèle implémenté est conforme au modèle de conception** pour l'essentiel : mêmes 9 classes, même hiérarchie, mêmes méthodes redéfinies, même répartition des responsabilités (la place gère ses jetons, l'arc agit sur sa place, la transition décide si elle est franchissable, le réseau choisit).

### Différences et justifications

| Différence | Justification |
|---|---|
| Méthodes en anglais (`step`, `fire`, `isFireable`, `activate`, `addTokens`…) au lieu du français (`executerPas`, `franchir`…) | Bonne pratique P11 « programmer en anglais ». Les classes et attributs sont restés en français. |
| Getters ajoutés : `getPlaces`, `getTransitions`, `getArcs` dans `ReseauPetri`, `getIncomingArcs`, `getOutgoingArcs` dans `Transition` | Nécessaires pour tester le contenu du réseau. Inconvénient : ils renvoient les listes internes, modifiables de l'extérieur (moins d'encapsulation qu'en conception). |
| `addArc` utilise `instanceof` pour ranger l'arc dans la bonne liste de la transition | Solution la plus directe, mais contraire à notre choix de conception (variante C, polymorphisme sans test de type). Amélioration possible : une méthode abstraite dans `Arc`, redéfinie par `ArcEntrant` et `ArcSortant`, qui s'enregistre elle-même. |
| `removeArc` retire l'arc des listes de la transition via ses getters | La conception ne prévoyait que l'ajout d'arcs dans `Transition`, pas leur retrait. |
| Constructeur supplémentaire `Transition(String, List, List)` | Utilisé par `Transition(String)` ; il permet aussi de créer une transition avec des arcs sans passer par le réseau. |
| `Place.removeTokens` ignore un retrait trop grand au lieu d'une précondition | Choix plus simple qui garantit `nbJetons >= 0` (exigence 7). |

### Navigabilité

Les associations retrouvées par la rétro-ingénierie sont **exactement celles choisies en conception** (section 4.3) :

| Association | Conception | Implémentation |
|---|---|---|
| `ReseauPetri` → `Place`, `Transition`, `Arc` | composition, navigable du réseau vers ses éléments | 3 listes `final` dans `ReseauPetri` ✅ |
| `Arc` → `Place` | unidirectionnelle : la place ne connaît pas ses arcs | attribut `place` dans `Arc`, rien dans `Place` ✅ |
| `Transition` → `ArcEntrant` / `ArcSortant` | navigable, deux listes typées | `arcsEntrants`, `arcsSortants` ✅ |
| `Arc` → `Transition` | navigable (redondance volontaire, maintenue par `addArc`) | attribut `transition` dans `Arc` ✅ |

Deux remarques :
- L'outil ne distingue pas composition et simple association : il dessine une flèche pour chaque attribut. La composition reste une intention de conception (le réseau crée et supprime ses éléments, et `removePlace`/`removeTransition` suppriment aussi les arcs liés).
- Les getters ne changent pas la navigabilité, mais ils exposent les listes : une classe extérieure pourrait modifier `Transition.arcsEntrants` sans passer par `ReseauPetri.addArc`, ce que la visibilité paquet de `addIncomingArc` devait empêcher.

**Comparaison avec PNE :** notre modèle type les extrémités des arcs (un arc relie toujours une `Place` et une `Transition`) et utilise l'héritage pour les types d'arcs. PNE type les extrémités en `AbstractNode` et utilise des booléens ; il doit donc caster et tester le type, ce que notre conception évite (sauf dans `addArc`).

---