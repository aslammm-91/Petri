package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReseauPetri {
    private ReseauPetri rp;
    private Place pIn;
    private Place pOut;
    private Transition t;
    private ArcEntrant arcE;
    private ArcSortant arcS;

    @BeforeEach
    void setUp() {
        // Réseau du diagramme de séquence, cas simple : pIn -> t -> pOut
        rp = new ReseauPetri();
        pIn = new Place("PIn", 1);
        pOut = new Place("POut", 0);
        t = new Transition("T0");
        arcE = new ArcEntrant(pIn, t, 1);
        arcS = new ArcSortant(pOut, t, 1);
        // TODO : ajouter ces éléments au réseau quand ajouterXxx sera implémenté
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAjouterPlace() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testSupprimerPlace() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testAjouterTransition() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testSupprimerTransition() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testAjouterArc() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testAjouterArcDoublon() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testSupprimerArc() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testGetTransitionsFranchissables() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testExecuterPasTransition() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testExecuterPasTransitionNonFranchissable() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testExecuterPas() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testExecuterPasAucuneFranchissable() {
        // TODO
        fail("Pas encore implémenté");
    }
}
