package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.UnimplementedCaseException;

import petri.Place;
import petri.ReseauPetri;
import petri.Transition;

/**
 * Adaptateur (patron Adapter) : PNE manipule une {@link PetriNetInterface},
 * chaque appel doit être traduit vers notre ReseauPetri.
 * PNE charge cette classe par son nom : elle doit s'appeler PetriNetAdapter
 * et avoir un constructeur sans argument.
 */
public class PetriNetAdapter extends PetriNetInterface {

    private final ReseauPetri reseau = new ReseauPetri();

    @Override
    public AbstractPlace addPlace() {
        Place place = new Place("P", 0);
        reseau.addPlace(place);
        return new PlaceAdapter(place);
    }

    @Override
    public AbstractTransition addTransition() {
        Transition transition = new Transition("T");
        reseau.addTransition(transition);
        return new TransitionAdapter(transition);
    }

    @Override
    public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination)
            throws UnimplementedCaseException {
        // TODO : place -> transition = ArcEntrant, transition -> place = ArcSortant,
        //        sinon UnimplementedCaseException ; ajouter l'arc au réseau, renvoyer un ArcAdapter
        return null;
    }

    @Override
    public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
            throws UnimplementedCaseException {
        // TODO : arc inhibiteur = ArcZero
        return null;
    }

    @Override
    public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
            throws UnimplementedCaseException {
        // TODO : arc reset = ArcVideur
        return null;
    }

    @Override
    public void removePlace(AbstractPlace place) {
        // TODO
    }

    @Override
    public void removeTransition(AbstractTransition transition) {
        // TODO
    }

    @Override
    public void removeArc(AbstractArc arc) {
        // TODO
    }

    @Override
    public boolean isEnabled(AbstractTransition transition) {
        // TODO : correspond à isFireable()
        return false;
    }

    @Override
    public void fire(AbstractTransition transition) {
        // TODO : correspond à step(t)
    }
}
