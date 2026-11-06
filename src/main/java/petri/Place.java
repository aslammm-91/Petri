package petri;

public class Place extends Noeud {

    private int nbJetons;

    public Place(String name, int nbJetons) {
        super(name);
        this.nbJetons=nbJetons;
    }

    public int getTokens() {
        return this.nbJetons;
    }

    public void addTokens(int nb) {
        this.nbJetons+=nb ;
    }

    // Exigence 7 : si la place n'a pas assez de jetons, rien n'est retiré
    public void removeTokens(int nb) {
        if (nb <= this.nbJetons) {
            this.nbJetons -= nb;
        }
    }
}
