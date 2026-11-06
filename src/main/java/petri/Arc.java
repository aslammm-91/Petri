package petri;

public abstract class Arc {

    private int poids;
    private Place place;
    private Transition transition;

    public Arc(Place place, Transition transition, int poids) {
        if (poids <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement positif");
        }
        this.place = place;
        this.transition = transition;
        this.poids = poids;
    }

    public int getWeight() {
        return this.poids;
    }

    public void setWeight(int p) {
        if (p <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement positif");
        }
        this.poids = p;
    }

    public Place getPlace() {
        return this.place;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public abstract void activate();
}
