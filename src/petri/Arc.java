package petri;

public abstract class Arc {

    private int poids;
    private Place place;
    private Transition transition;

    public Arc(Place place, Transition transition, int poids) {
        // TODO
    }

    public int getPoids() {
        // TODO
        return 0;
    }

    public void setPoids(int poids) {
        // TODO
    }

    public Place getPlace() {
        // TODO
        return null;
    }

    public Transition getTransition() {
        // TODO
        return null;
    }

    public abstract void activer();
}
