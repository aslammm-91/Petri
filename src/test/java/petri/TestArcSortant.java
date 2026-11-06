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
        assertEquals(p,a.getPlace());
        assertEquals(t,a.getTransition());
        assertEquals(2, a.getWeight());
    }

    @Test
    void testActivate() {
        Place p1 = new Place ("P0",5);
        ArcSortant a1 = new ArcSortant(p1,t,3);
        assertEquals(5,p1.getTokens());
        a1.activate();
        assertEquals(8,p1.getTokens());
    }

    @Test
    void testActivateTwice() {
        a.activate();
        a.activate();
        assertEquals(4, p.getTokens());
    }
}
