package org.pneditor.petrinet.adapters.aslam_arsene;

import org.pneditor.petrinet.AbstractPlace;

import petri.Place;

/**
 * Adapte une Place de notre modèle à l'{@link AbstractPlace} attendue par PNE.
 */
public class PlaceAdapter extends AbstractPlace {

    private final Place place;

    Place getPlace() {
        return place;
    }

    public PlaceAdapter(Place place) {
        super(place.getName());
        this.place = place;
    }

    @Override
    public void addToken() {
        place.addTokens(1);
    }

    @Override
    public void removeToken() {
        place.removeTokens(1);
    }

    @Override
    public int getTokens() {
        return place.getTokens();
    }

    @Override
    public void setTokens(int tokens) {
        place.removeTokens(place.getTokens());
        place.addTokens(tokens);
    }
}