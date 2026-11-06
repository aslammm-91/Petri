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
    void testAddIncomingArc() {
        // pIn n'a qu'un jeton : un arc entrant de poids 2 rend t non franchissable
        t.addIncomingArc(new ArcEntrant(pIn, t, 2));
        assertFalse(t.isFireable());
    }

    @Test
    void testAddOutgoingArc() {
        t.addOutgoingArc(new ArcSortant(pOut, t, 3));
        t.fire();
        assertEquals(3, pOut.getTokens());
    }

    @Test
    void testIsFireableWithoutArc() {
        // Une transition sans arc entrant est toujours franchissable
        assertTrue(t.isFireable());
        t.addOutgoingArc(new ArcSortant(pOut, t, 1));
        assertTrue(t.isFireable());
    }

    @Test
    void testIsFireable() {
        Place p2 = new Place("P2", 3);
        t.addIncomingArc(new ArcEntrant(pIn, t, 1));
        t.addIncomingArc(new ArcEntrant(p2, t, 2));
        assertTrue(t.isFireable());
    }

    @Test
    void testIsNotFireable() {
        // Un seul arc entrant inactif suffit
        Place p2 = new Place("P2", 1);
        t.addIncomingArc(new ArcEntrant(pIn, t, 1));
        t.addIncomingArc(new ArcEntrant(p2, t, 2));
        assertFalse(t.isFireable());
    }

    @Test
    void testIsFireableSpecialArcs() {
        Place empty = new Place("Vide", 0);
        Place full = new Place("Pleine", 4);
        t.addIncomingArc(new ArcZero(empty, t));
        t.addIncomingArc(new ArcVideur(full, t));
        assertTrue(t.isFireable());
        empty.addTokens(1);
        assertFalse(t.isFireable());
    }

    @Test
    void testFire() {
        // Cas simple du diagramme de séquence : pIn -> t -> pOut
        t.addIncomingArc(new ArcEntrant(pIn, t, 1));
        t.addOutgoingArc(new ArcSortant(pOut, t, 2));
        t.fire();
        assertEquals(0, pIn.getTokens());
        assertEquals(2, pOut.getTokens());
    }

    @Test
    void testFireSamePlaceInAndOut() {
        // Une place à la fois en entrée et en sortie : on retire puis on ajoute
        t.addIncomingArc(new ArcEntrant(pIn, t, 1));
        t.addOutgoingArc(new ArcSortant(pIn, t, 1));
        t.fire();
        assertEquals(1, pIn.getTokens());
    }
}
