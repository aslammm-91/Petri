package petri;
import java.util.Random;
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
        List<Transition> transi =getTransitionsFranchissables();
        if (transi.isEmpty()){
            return false ;
        }
        int size=transi.size();
        for (int i=0; i<size;i++){
            choisir(transi).franchir(); 
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
        places.add(p);
    }

    public void supprimerPlace(Place p) {
        places.remove(p);
    }

    public void ajouterTransition(Transition t) {
        transitions.add(t);
    }

    public void supprimerTransition(Transition t) {
        transitions.remove(t);
    }

    public void ajouterArc(Arc a) {
        arcs.add(a);
    }

    public void supprimerArc(Arc a) {
        arcs.remove(a);
    }

    private Transition choisir (List<Transition> l) {
        Random rand = new Random();
        Transition tr= l.get(rand.nextInt(l.size()));
        l.remove(tr);
        return tr;
    }
}
