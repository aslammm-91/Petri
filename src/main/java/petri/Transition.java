package petri;

import java.util.ArrayList;
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


    public List<ArcEntrant> getIncomingArcs() {
        return arcsEntrants;
    }

    public List<ArcSortant> getOutgoingArcs() {
        return arcsSortants;
    }

    public boolean isFireable() {
        for (ArcEntrant arc : arcsEntrants) {
            if (!arc.isActive()) {
                return false;
            }
        }
        return true;
    }

    public void fire() {
        for (ArcEntrant arc : arcsEntrants) {
            arc.activate();
        }
        for (ArcSortant arc : arcsSortants){
            arc.activate();
        }
    }

    void addIncomingArc(ArcEntrant a) {
        arcsEntrants.add(a);
    }

    void addOutgoingArc(ArcSortant a) {
        arcsSortants.add(a);
    }
}
