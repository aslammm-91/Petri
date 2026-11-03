package petri;

import java.util.ArrayList;
import java.util.List;

public class ReseauPetri {

    private List<Place> places;
    private List<Transition> transitions;
    private List<Arc> arcs;

    public boolean executerPas(Transition t) {
        if (t.estFranchissable()){
            t.franchir();
            return true;
        }
        return false;
    }
    
    public boolean executerPas() {
        if (getTransitionsFranchissables().isEmpty()){
            return false ;
        }
        for (Transition t : getTransitionsFranchissables()){
            t.franchir(); 
        }
        return true;
    }


    public List<Transition> getTransitionsFranchissables() {
        List<Transition> list=new ArrayList<Transition>();
        for (Transition t: transitions){
            if (t.estFranchissable()){
                list.add(t);  
            }
        }
        return list;
    }

    public void ajouterPlace(Place p) {
        // TODO
    }

    public void supprimerPlace(Place p) {
        // TODO
    }

    public void ajouterTransition(Transition t) {
        // TODO
    }

    public void supprimerTransition(Transition t) {
        // TODO
    }

    public void ajouterArc(Arc a) {
        // TODO
    }

    public void supprimerArc(Arc a) {
        // TODO
    }

    private Transition choisir(List<Transition> l) {
        // TODO
        return null;
    }
}
