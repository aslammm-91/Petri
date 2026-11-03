package petri;

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
