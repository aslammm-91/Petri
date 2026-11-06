package petri;

/**
 * Arc zéro (extension de l'exercice 2) : actif seulement si la place est vide,
 * il ne retire aucun jeton. Son poids n'a pas de sens et vaut toujours 1.
 */
public class ArcZero extends ArcEntrant {

    public ArcZero(Place place, Transition transition) {

        super(place, transition, 1);
    }

    @Override
    public boolean isActive() {
        Place p = getPlace();
        return p.getTokens() == 0 ;
        }

    @Override
    public void activate() {
    }
}
