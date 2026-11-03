package petri;

public class ArcVideur extends ArcEntrant {

    public ArcVideur(Place place, Transition transition) {
        super(place, transition, 1);
    }

    @Override
    public boolean estActif() {
        Place p = getPlace();
        return p.getJetons() >= 1;
    }


    @Override
    public void activer() {
        Place p = getPlace();
        int nbJetons = p.getJetons();
        p.retirerJetons(nbJetons);

    }
}
