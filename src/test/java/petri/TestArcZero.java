package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArcZero {
    private Place p;
    private Transition t;
    private ArcZero a;

    @BeforeEach
    void setUp() {
        p = new Place("P0", 0);
        t = new Transition("T0");
        a = new ArcZero(p, t);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testArcZero() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testEstActifPlaceVide() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testNonActifPlaceNonVide() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testActiver() {
        // TODO
        fail("Pas encore implémenté");
    }
}
