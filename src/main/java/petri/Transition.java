package petri;

import java.util.ArrayList;
import java.util.List;

/**
 * Transition d'un réseau de Petri.
 * Elle connaît ses arcs entrants et sortants, sait si elle est franchissable et se tire elle-même.
 * Les arcs lui sont ajoutés par {@link ReseauPetri#addArc(Arc)}.
 */
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

    /**
     * Une transition est franchissable si tous ses arcs entrants sont actifs.
     * Une transition sans arc entrant est donc toujours franchissable.
     */
    public boolean isFireable() {
        for (ArcEntrant arc : arcsEntrants) {
            if (!arc.isActive()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tire la transition : active d'abord les arcs entrants (retrait des jetons),
     * puis les arcs sortants (ajout des jetons).
     * L'appelant doit avoir vérifié {@link #isFireable()} avant.
     */
    public void fire() {
        for (ArcEntrant arc : arcsEntrants) {
            arc.activate();
        }
        for (ArcSortant arc : arcsSortants){
            arc.activate();
        }
    }

    // Visibilité paquet : seul ReseauPetri.addArc ajoute des arcs
    void addIncomingArc(ArcEntrant a) {
        arcsEntrants.add(a);
    }

    void addOutgoingArc(ArcSortant a) {
        arcsSortants.add(a);
    }
}
