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
        assertEquals(1,a.getPoids());

    }

    @Test
    void testSetPoids() {
        ArcEntrant a = new ArcEntrant(p,t,0);
        assertEquals(0,a.getPoids());
        a.setPoids(3);
        assertEquals(3,a.getPoids());
    }

    @Test
    void testEstActif() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,3);
        assertTrue(a1.estActif());
        p1.retirerJetons(4);
        assertFalse(a1.estActif());
    }

    @Test
    void testNonActif() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,8);
        assertFalse(a1.estActif());
        p1.retirerJetons(4);
        assertFalse(a1.estActif());
        p1.ajouterJetons(6);
        assertFalse(a1.estActif());
    }

    @Test
    void testActiver() {
        Place p1 = new Place ("P0",5);
        ArcEntrant a1 = new ArcEntrant(p1,t,3);
        assertEquals(5,p1.getJetons());
        a1.activer();
        assertEquals(2,p1.getJetons());
    }
}
