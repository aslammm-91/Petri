package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

/**
 * Adapte un Arc de notre modèle à l'{@link AbstractArc} attendu par PNE.
 * Régulier = ArcEntrant / ArcSortant, inhibiteur = ArcZero, reset = ArcVideur.
 */
public class ArcAdapter extends AbstractArc {

    // TODO : attributs (l'Arc de notre modèle, la source et la destination côté PNE, le type d'arc)

    @Override
    public AbstractNode getSource() {
        // TODO
        return null;
    }

    @Override
    public AbstractNode getDestination() {
        // TODO
        return null;
    }

    @Override
    public boolean isReset() {
        // TODO
        return false;
    }

    @Override
    public boolean isRegular() {
        // TODO
        return false;
    }

    @Override
    public boolean isInhibitory() {
        // TODO
        return false;
    }

    @Override
    public int getMultiplicity() throws ResetArcMultiplicityException {
        // TODO : un arc reset n'a pas de poids
        return 0;
    }

    @Override
    public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
        // TODO : un arc reset n'a pas de poids
    }
}
