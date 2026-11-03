package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArcEntrant {
    private Place p;
    private Transition t;
    private ArcEntrant a;

    @BeforeEach
    void setUp() {
        p = new Place("P0", 2);
        t = new Transition("T0");
        a = new ArcEntrant(p, t, 2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testArcEntrant() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testPoidsNonPositif() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testSetPoids() {
        // TODO
        fail("Pas encore implémenté");
    }

    void testSetPoidsNonPositif() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testEstActif() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testNonActif() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testActiver() {
        // TODO
        fail("Pas encore implémenté");
    }
}
