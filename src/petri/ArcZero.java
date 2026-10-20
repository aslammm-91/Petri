package petri;

public class ArcZero extends ArcEntrant {

    public ArcZero(Place place, Transition transition) {

        super(place, transition, 1);
    }

    @Override
    public boolean estActif() {
        Place p = getPlace();
        return p.getJetons() == 0 ;
        }

    @Override
    public void activer() {
    }
}
