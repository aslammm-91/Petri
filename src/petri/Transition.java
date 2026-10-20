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
        for (ArcEntrant arc : arcsEntrants) {
            if (!arc.estActif()) {
                return false;
            }
        }
        return true;
    }

    public void franchir() {
        for (ArcEntrant arc : arcsEntrants) {
            arc.activer();
        }
        for (ArcSortant arc : arcsSortants){
            arc.activer();
        }
    }

    void ajouterArcEntrant(ArcEntrant a) {
        // TODO
    }

    void ajouterArcSortant(ArcSortant a) {
        // TODO
    }
}
