package petri;

public class ArcEntrant extends Arc {

    public ArcEntrant(Place place, Transition transition, int poids) {

        super(place, transition, poids);
    }

    public boolean estActif() {
        Place p = getPlace();
        int weight = getPoids();
        return p.getJetons() >= weight;
    }

    @Override
    public void activer() {
        if (estActif()) {
            Place p = getPlace();
            int weight = getPoids();
            p.retirerJetons(weight);
        }
    }
}
