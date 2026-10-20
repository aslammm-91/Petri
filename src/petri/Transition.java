package petri;

import java.util.List;

public class Transition extends Noeud {

    private List<ArcEntrant> arcsEntrants;
    private List<ArcSortant> arcsSortants;

    public Transition(String name,List<ArcEntrant> arcsEntrants,List<ArcSortant> arcsSortants ) {
        super(name);
        this.arcsEntrants=arcsEntrants;
        this.arcsSortants=arcsSortants;
    }
    public Transition(String name){
        this(name, new ArrayList<>(), new ArrayList<>());
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
