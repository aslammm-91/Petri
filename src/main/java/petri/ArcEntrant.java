package petri;

/**
 * Arc allant d'une place vers une transition.
 * Il est actif si la place contient au moins {@code poids} jetons ; activé, il retire ces jetons.
 * {@link ArcZero} et {@link ArcVideur} redéfinissent ces deux comportements.
 */
public class ArcEntrant extends Arc {

    public ArcEntrant(Place place, Transition transition, int poids) {

        super(place, transition, poids);
    }

    public boolean isActive() {
        Place p = getPlace();
        int weight = getWeight();
        return p.getTokens() >= weight;
    }

    /**
     * Retire {@code poids} jetons de la place. Ne fait rien si l'arc n'est pas actif.
     */
    @Override
    public void activate() {
        if (isActive()) {
            Place p = getPlace();
            int weight = getWeight();
            p.removeTokens(weight);
        }
    }
}
