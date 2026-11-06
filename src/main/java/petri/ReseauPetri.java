package petri;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ReseauPetri {

    private List<Place> places;
    private List<Transition> transitions;
    private List<Arc> arcs;

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
        List<Transition> transi =getFireableTransitions();
        if (transi.isEmpty()){
            return false ;
        }
        int size=transi.size();
        for (int i=0; i<size;i++){
            choose(transi).fire(); 
        }
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
    }

    public void addTransition(Transition t) {
        transitions.add(t);
    }

    public void removeTransition(Transition t) {
        transitions.remove(t);
    }

    public void addArc(Arc a) {
        arcs.add(a);
    }

    public void removeArc(Arc a) {
        arcs.remove(a);
    }

    private Transition choose (List<Transition> l) {
        Random rand = new Random();
        Transition tr= l.get(rand.nextInt(l.size()));
        l.remove(tr);
        return tr;
    }
}
