package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.UnimplementedCaseException;

import petri.Arc;
import petri.ArcEntrant;
import petri.ArcSortant;
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
        Arc arc;
        if (source instanceof PlaceAdapter && destination instanceof TransitionAdapter) {
            Place place = ((PlaceAdapter) source).getPlace();
            Transition transition = ((TransitionAdapter) destination).getTransition();
            arc = new ArcEntrant(place, transition, 1);
        } else if (source instanceof TransitionAdapter && destination instanceof PlaceAdapter) {
            Transition transition = ((TransitionAdapter) source).getTransition();
            Place place = ((PlaceAdapter) destination).getPlace();
            arc = new ArcSortant(place, transition, 1);
        } else {
            throw new UnimplementedCaseException("Un arc régulier doit relier une place et une transition.");
        }

        if (!reseau.getPlaces().contains(arc.getPlace())
                || !reseau.getTransitions().contains(arc.getTransition())) {
            throw new UnimplementedCaseException("Les deux extrémités doivent appartenir à ce réseau.");
        }

        try {
            reseau.addArc(arc);
        } catch (IllegalArgumentException e) {
            throw new UnimplementedCaseException(e.getMessage());
        }
        return new ArcAdapter(arc, source, destination);
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
        reseau.removePlace(place);
    }

    @Override
    public void removeTransition(AbstractTransition transition) {
        reseau.removeTransition(transition);
    }

    @Override
    public void removeArc(AbstractArc arc) {
        reseau.removeArc(arc);
    }

    @Override
    public boolean isEnabled(AbstractTransition transition) {
        return transition.isFireable();
    }

    @Override
    public void fire(AbstractTransition transition) {
        // TODO : correspond à step(t)
    }
}
