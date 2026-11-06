package petri;

/**
 * Arc reliant une {@link Place} et une {@link Transition}.
 * Le sens est donné par la sous-classe : {@link ArcEntrant} (place vers transition)
 * ou {@link ArcSortant} (transition vers place).
 * Le poids est toujours strictement positif (exigence 6).
 */
public abstract class Arc {

    private int poids;
    private Place place;
    private Transition transition;

    /**
     * @throws IllegalArgumentException si le poids est nul ou négatif
     */
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

    /**
     * @throws IllegalArgumentException si le poids est nul ou négatif
     */
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

    /**
     * Effet de l'arc sur sa place quand la transition est tirée.
     * Redéfini par chaque type d'arc.
     */
    public abstract void activate();
}
