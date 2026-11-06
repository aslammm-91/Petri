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
        ArcEntrant a = new ArcEntrant(p,t, 1);
        assertEquals(t,a.getTransition());
        assertEquals(p,a.getPlace());
        assertEquals(1,a.getWeight());

    }

    @Test
    void testSetWeight() {
        ArcEntrant a = new ArcEntrant(p,t,1);
        assertEquals(1,a.getWeight());
        a.setWeight(3);
        assertEquals(3,a.getWeight());
    }

    @Test
    void testIsActive() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,3);
        assertTrue(a1.isActive());
        p1.removeTokens(4);
        assertFalse(a1.isActive());
    }

    @Test
    void testIsNotActive() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,8);
        assertFalse(a1.isActive());
        p1.removeTokens(4);
        assertFalse(a1.isActive());
        p1.addTokens(6);
        assertFalse(a1.isActive());
    }

    @Test
    void testActivate() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,3);
        assertEquals(5,p1.getTokens());
        a1.activate();
        assertEquals(2,p1.getTokens());
    }

    @Test
    void testActivateNotActive() {
        // Arc inactif : activate() ne retire rien
        Place p1 = new Place("P1", 1);
        ArcEntrant a1 = new ArcEntrant(p1, t, 3);
        a1.activate();
        assertEquals(1, p1.getTokens());
    }

    @Test
    void testWeightNotPositive() {
        // Exigence 6 : un poids nul ou négatif est refusé
        assertThrows(IllegalArgumentException.class, () -> new ArcEntrant(p, t, 0));
        assertThrows(IllegalArgumentException.class, () -> new ArcEntrant(p, t, -1));
        assertThrows(IllegalArgumentException.class, () -> a.setWeight(0));
    }
}
