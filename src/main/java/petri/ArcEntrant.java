package petri;

public class ArcEntrant extends Arc {

    public ArcEntrant(Place place, Transition transition, int poids) {

        super(place, transition, poids);
    }

    public boolean isActive() {
        Place p = getPlace();
        int weight = getWeight();
        return p.getTokens() >= weight;
    }

    @Override
    public void activate() {
        if (isActive()) {
            Place p = getPlace();
            int weight = getWeight();
            p.removeTokens(weight);
        }
    }
}
