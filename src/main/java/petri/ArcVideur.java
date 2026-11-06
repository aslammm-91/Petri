package petri;

/**
 * Arc videur (extension de l'exercice 2) : actif dès que la place contient un jeton,
 * il vide la place. Son poids n'a pas de sens et vaut toujours 1.
 */
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
