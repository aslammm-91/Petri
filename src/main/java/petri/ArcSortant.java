package petri;

/**
 * Arc allant d'une transition vers une place : activé, il ajoute {@code poids} jetons à la place.
 */
public class ArcSortant extends Arc {

    public ArcSortant(Place place, Transition transition, int poids) {

        super(place, transition, poids);
    }

    @Override
    public void activate() {
        Place p = getPlace();
        int weight = getWeight();
        p.addTokens(weight);
    }
}
