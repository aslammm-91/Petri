package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests de {@link ArcVideur} : actif dès un jeton, vide la place. */
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
        assertEquals(1, a.getWeight());
    }

    @Test
    void testIsActive() {
        assertTrue(a.isActive());
        Place p1 = new Place("P1", 1);
        assertTrue(new ArcVideur(p1, t).isActive());
    }

    @Test
    void testIsNotActiveEmptyPlace() {
        Place p1 = new Place("P1", 0);
        assertFalse(new ArcVideur(p1, t).isActive());
    }

    @Test
    void testActivate() {
        a.activate();
        assertEquals(0, p.getTokens());
        assertFalse(a.isActive());
    }
}
