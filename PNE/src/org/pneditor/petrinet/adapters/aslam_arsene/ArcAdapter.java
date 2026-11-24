package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;

import petri.Arc;

/**
 * Adapte un arc régulier de notre modèle à l'{@link AbstractArc} attendu par PNE.
 */
public class ArcAdapter extends AbstractArc {

    private final Arc arc;
    private final AbstractNode source;
    private final AbstractNode destination;

    ArcAdapter(Arc arc, AbstractNode source, AbstractNode destination) {
        this.arc = arc;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public AbstractNode getSource() {
        return source;
    }

    @Override
    public AbstractNode getDestination() {
        return destination;
    }

    @Override
    public boolean isReset() {
        return false;
    }

    @Override
    public boolean isRegular() {
        return true;
    }

    @Override
    public boolean isInhibitory() {
        return false;
    }

    @Override
    public int getMultiplicity() {
        return arc.getWeight();
    }

    @Override
    public void setMultiplicity(int multiplicity) {
        arc.setWeight(multiplicity);
    }
}
