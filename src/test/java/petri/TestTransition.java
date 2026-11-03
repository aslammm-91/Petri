package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTransition {
    private Transition t;
    private Place pIn;
    private Place pOut;

    @BeforeEach
    void setUp() {
        t = new Transition("T0");
        pIn = new Place("PIn", 1);
        pOut = new Place("POut", 0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testTransition() {
        Transition t = new Transition("T0");
        assertEquals("T0",t.getName());
    }

    @Test
    void testAjouterArcEntrant() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testAjouterArcSortant() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testEstFranchissableSansArc() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testEstFranchissable() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testNonFranchissable() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testFranchir() {
        // TODO
        fail("Pas encore implémenté");
    }
}
