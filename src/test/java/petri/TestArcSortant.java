package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArcSortant {
    private Place p;
    private Transition t;
    private ArcSortant a;

    @BeforeEach
    void setUp() {
        p = new Place("P0", 0);
        t = new Transition("T0");
        a = new ArcSortant(p, t, 2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testArcSortant() {
        // TODO
        fail("Pas encore implémenté");
    }

    @Test
    void testActiver() {
        // TODO
        fail("Pas encore implémenté");
    }
}
