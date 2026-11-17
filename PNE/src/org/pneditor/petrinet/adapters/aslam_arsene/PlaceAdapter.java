package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractPlace;

/**
 * Adapte une Place de notre modèle à l'{@link AbstractPlace} attendue par PNE.
 */
public class PlaceAdapter extends AbstractPlace {

    // TODO : attribut Place (la place de notre modèle)

    public PlaceAdapter(String label) {
        // TODO : recevoir aussi la Place adaptée
        super(label);
    }

    @Override
    public void addToken() {
        // TODO
    }

    @Override
    public void removeToken() {
        // TODO
    }

    @Override
    public int getTokens() {
        // TODO
        return 0;
    }

    @Override
    public void setTokens(int tokens) {
        // TODO : notre Place n'a pas de setter
    }
}
