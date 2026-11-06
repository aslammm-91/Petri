package petri;

public class ArcVideur extends ArcEntrant {

    public ArcVideur(Place place, Transition transition) {
        super(place, transition, 1);
    }

    @Override
    public boolean isActive() {
        Place p = getPlace();
        return p.getTokens() >= 1;
    }


    @Override
    public void activate() {
        Place p = getPlace();
        int nbJetons = p.getTokens();
        p.removeTokens(nbJetons);

    }
}
