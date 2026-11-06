package petri;

/**
 * Élément nommé d'un réseau de Petri : classe mère de {@link Place} et de {@link Transition}.
 * Le nom est fixé à la construction et ne change plus.
 */
public abstract class Noeud {

    private String name;

    public Noeud(String name) {
        this.name=name ;
    }

    public String getName() {
        return this.name ;
    }

    @Override
    public String toString() {
        return "Nom :"+this.name;
    }
}
