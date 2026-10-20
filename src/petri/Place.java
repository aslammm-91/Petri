package petri;

public class Place extends Noeud {

    private int nbJetons;

    public Place(String name, int nbJetons) {
        super(name);
        this.nbJetons=nbJetons;
    }

    public int getJetons() {
        return this.nbJetons;
    }

    public void ajouterJetons(int nb) {
        this.nbJetons+=nb ;
    }

    public void retirerJetons(int nb) {
        this.nbJetons-= nb ;
    }
}
