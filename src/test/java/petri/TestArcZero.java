package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests de {@link ArcZero} : actif seulement si la place est vide, ne retire rien. */
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
        assertEquals(p, a.getPlace());
        assertEquals(t, a.getTransition());
        assertEquals(1, a.getWeight());
    }

    @Test
    void testIsActiveEmptyPlace() {
        assertTrue(a.isActive());
    }

    @Test
    void testIsNotActiveNonEmptyPlace() {
        p.addTokens(1);
        assertFalse(a.isActive());
        p.addTokens(4);
        assertFalse(a.isActive());
    }

    @Test
    void testActivate() {
        a.activate();
        assertEquals(0, p.getTokens());
        Place p1 = new Place("P1", 3);
        new ArcZero(p1, t).activate();
        assertEquals(3, p1.getTokens());
    }
}
