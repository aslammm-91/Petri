package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractTransition;

/**
 * Adapte une Transition de notre modèle à l'{@link AbstractTransition} attendue par PNE.
 */
public class TransitionAdapter extends AbstractTransition {

    // TODO : attribut Transition (la transition de notre modèle)

    public TransitionAdapter(String label) {
        // TODO : recevoir aussi la Transition adaptée
        super(label);
    }
}
