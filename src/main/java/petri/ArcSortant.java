package petri;

public class ArcSortant extends Arc {

    public ArcSortant(Place place, Transition transition, int poids) {

        super(place, transition, poids);
    }

    @Override
    public void activer() {
        Place p = getPlace();
        int weight = getPoids();
        p.ajouterJetons(weight);
    }
}
