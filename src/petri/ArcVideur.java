package petri;

public class ArcVideur extends ArcEntrant {

    public ArcVideur(Place place, Transition transition) {
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
