package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractTransition;

import petri.Transition;

/**
 * Adapte une Transition de notre modèle à l'{@link AbstractTransition} attendue par PNE.
 */
public class TransitionAdapter extends AbstractTransition {

    private final Transition transition;

    public TransitionAdapter(Transition transition) {
        super(transition.getName());
        this.transition = transition;
    }

    Transition getTransition() {
        return transition;
    }
}
