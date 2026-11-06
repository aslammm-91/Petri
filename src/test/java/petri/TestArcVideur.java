package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArcVideur {
    private Place p;
    private Transition t;
    private ArcVideur a;

    @BeforeEach
    void setUp() {
        p = new Place("P0", 5);
        t = new Transition("T0");
        a = new ArcVideur(p, t);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testArcVideur() {
        assertEquals(p,a.getPlace());
        assertEquals(t,a.getTransition());
    }

    @Test
    void testEstActif() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testNonActifPlaceVide() {
        // TODO
        fail("Pas encore implémenté");
    }


    @Test
    void testActiver() {
        // TODO
        fail("Pas encore implémenté");
    }
}
