package petri;

public abstract class Arc {

    private int poids;
    private Place place;
    private Transition transition;

    public Arc(Place place, Transition transition, int poids) {
        this.place = place;
        this.transition = transition;
        this.poids = poids;
    }

    public int getPoids() {
        return this.poids;
    }

    public void setPoids(int p) {
        this.poids = p;
    }

    public Place getPlace() {
        return this.place;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public abstract void activer();
}
