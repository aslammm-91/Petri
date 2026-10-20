package petri;

public class ArcZero extends ArcEntrant {

    public ArcZero(Place place, Transition transition) {
        super(place, transition, 1);
    }

    @Override
    public boolean estActif() {
        // TODO
        return false;
    }

    @Override
    public void activer() {
        // TODO
    }
}
