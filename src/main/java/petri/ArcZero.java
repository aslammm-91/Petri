package petri;

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
