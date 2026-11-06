package petri;

/**
 * Place d'un réseau de Petri : elle contient des jetons.
 * Il n'y a pas de setter : seuls {@link #addTokens(int)} et {@link #removeTokens(int)}
 * modifient le nombre de jetons.
 */
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

    /**
     * Retire {@code nb} jetons de la place.
     * Exigence 7 : si la place n'a pas assez de jetons, rien n'est retiré.
     */
    public void removeTokens(int nb) {
        if (nb <= this.nbJetons) {
            this.nbJetons -= nb;
        }
    }
}
