package petri;

public class ArcEntrant extends Arc {

    public ArcEntrant(Place place, Transition transition, int poids) {
        super(place, transition, poids);
    }

    public boolean estActif() {
        // TODO
        return false;
    }

    @Override
    public void activer() {
        // TODO
    }
}
