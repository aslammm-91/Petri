package petri;

import java.util.List;

public class Transition extends Noeud {

    private List<ArcEntrant> arcsEntrants;
    private List<ArcSortant> arcsSortants;

    public Transition(String name) {
        super(name);
        // TODO
    }

    public boolean estFranchissable() {
        // TODO
        return false;
    }

    public void franchir() {
        // TODO
    }

    void ajouterArcEntrant(ArcEntrant a) {
        // TODO
    }

    void ajouterArcSortant(ArcSortant a) {
        // TODO
    }
}
