package petri;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ReseauPetri {

    private final List<Place> places = new ArrayList<>();
    private final List<Transition> transitions = new ArrayList<>();
    private final List<Arc> arcs = new ArrayList<>();

    public List<Place> getPlaces() {
        return places;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public List<Arc> getArcs() {
        return arcs;
    }

    public boolean step(Transition t) {
        if (t.isFireable()){
            t.fire();
            return true;
        }
        return false;
    }
    
    public boolean step() {
    List<Transition> transi = getFireableTransitions();
    if (transi.isEmpty()) {
        return false;
    }
    choose(transi).fire();
    return true;
    }


    public List<Transition> getFireableTransitions() {
        List<Transition> list=new ArrayList<Transition>();
        for (Transition t: transitions){
            if (t.isFireable()){
                list.add(t);  
            }
        }
        return list;
    }

    public void addPlace(Place p) {
        places.add(p);
    }

    public void removePlace(Place p) {
        places.remove(p);
        for (Arc a : new ArrayList<>(arcs)) {
            if (a.getPlace() == p) {
                removeArc(a);
            }
        }
    }

    public void addTransition(Transition t) {
        transitions.add(t);
    }

    public void removeTransition(Transition t) {
        transitions.remove(t);
        for (Arc a : new ArrayList<>(arcs)) {
            if (a.getTransition() == t) {
                removeArc(a);
            }
        }
    }

    public void addArc(Arc a) {
    for (Arc existing : arcs) {
        boolean memeSens = (existing instanceof ArcEntrant && a instanceof ArcEntrant)
                        || (existing instanceof ArcSortant && a instanceof ArcSortant);
        if (memeSens
                && existing.getPlace() == a.getPlace()
                && existing.getTransition() == a.getTransition()) {
            throw new IllegalArgumentException("Un arc existe déjà dans ce sens");
        }
    }
    arcs.add(a);
    if (a instanceof ArcEntrant) {
        a.getTransition().addIncomingArc((ArcEntrant) a);
    } else if (a instanceof ArcSortant) {
        a.getTransition().addOutgoingArc((ArcSortant) a);
    }
}

    public void removeArc(Arc a) {
        arcs.remove(a);
        a.getTransition().getIncomingArcs().remove(a);
        a.getTransition().getOutgoingArcs().remove(a);
    }

    private Transition choose (List<Transition> l) {
        Random rand = new Random();
        Transition tr= l.get(rand.nextInt(l.size()));
        l.remove(tr);
        return tr;
    }
}
