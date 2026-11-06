package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReseauPetri {
    private ReseauPetri rp;
    private Place pIn;
    private Place pOut;
    private Transition t;
    private ArcEntrant arcE;
    private ArcSortant arcS;

    @BeforeEach
    void setUp() {
        // Réseau du diagramme de séquence, cas simple : pIn -> t -> pOut
        rp = new ReseauPetri();
        pIn = new Place("PIn", 1);
        pOut = new Place("POut", 0);
        t = new Transition("T0");
        arcE = new ArcEntrant(pIn, t, 1);
        arcS = new ArcSortant(pOut, t, 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testReseauPetri() {
        // Un réseau neuf est vide
        assertEquals(0, rp.getPlaces().size());
        assertEquals(0, rp.getTransitions().size());
        assertEquals(0, rp.getArcs().size());
    }

    @Test
    void testAddPlace() {
        rp.addPlace(pIn);
        assertEquals(1, rp.getPlaces().size());
        assertTrue(rp.getPlaces().contains(pIn));
    }

    @Test
    void testRemovePlace() {
        rp.addPlace(pIn);
        rp.removePlace(pIn);
        assertFalse(rp.getPlaces().contains(pIn));
    }

    @Test
    void testRemovePlaceRemovesArcs() {
        // Supprimer une place supprime aussi les arcs qui la touchent
        rp.addPlace(pIn);
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.removePlace(pIn);
        assertFalse(rp.getArcs().contains(arcE));
    }

    @Test
    void testAddTransition() {
        rp.addTransition(t);
        assertEquals(1, rp.getTransitions().size());
        assertTrue(rp.getTransitions().contains(t));
    }

    @Test
    void testRemoveTransition() {
        rp.addTransition(t);
        rp.removeTransition(t);
        assertFalse(rp.getTransitions().contains(t));
    }

    @Test
    void testRemoveTransitionRemovesArcs() {
        // Supprimer une transition supprime aussi ses arcs
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.addArc(arcS);
        rp.removeTransition(t);
        assertFalse(rp.getArcs().contains(arcE));
        assertFalse(rp.getArcs().contains(arcS));
    }

    @Test
    void testAddArc() {
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.addArc(arcS);
        // L'arc est dans le réseau...
        assertEquals(2, rp.getArcs().size());
        // ...et aussi dans la bonne liste de sa transition
        assertTrue(t.getIncomingArcs().contains(arcE));
        assertTrue(t.getOutgoingArcs().contains(arcS));
    }

    @Test
    void testAddDuplicateArc() {
        // Exigence 3 : un seul arc par sens entre une place et une transition
        rp.addArc(arcE);
        assertThrows(IllegalArgumentException.class, () -> rp.addArc(new ArcEntrant(pIn, t, 2)));
        assertEquals(1, rp.getArcs().size());
    }

    @Test
    void testRemoveArc() {
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.removeArc(arcE);
        // L'arc disparaît du réseau et de sa transition
        assertFalse(rp.getArcs().contains(arcE));
        assertFalse(t.getIncomingArcs().contains(arcE));
    }

    @Test
    void testGetFireableTransitions() {
        // t peut être tirée, t2 non (sa place d'entrée est vide)
        Place vide = new Place("Vide", 0);
        Transition t2 = new Transition("T2");
        rp.addTransition(t);
        rp.addTransition(t2);
        rp.addArc(arcE);
        rp.addArc(new ArcEntrant(vide, t2, 1));
        assertEquals(1, rp.getFireableTransitions().size());
        assertTrue(rp.getFireableTransitions().contains(t));
    }

    @Test
    void testStepTransition() {
        // Exigence 5 : l'utilisateur choisit t, le jeton passe de pIn à pOut
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.addArc(arcS);
        assertTrue(rp.step(t));
        assertEquals(0, pIn.getTokens());
        assertEquals(1, pOut.getTokens());
    }

    @Test
    void testStepTransitionNotFireable() {
        // pIn est vide : step(t) rend false et rien ne bouge
        pIn.removeTokens(1);
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.addArc(arcS);
        assertFalse(rp.step(t));
        assertEquals(0, pOut.getTokens());
    }

    @Test
    void testStep() {
        // Une seule transition franchissable : step() la tire
        rp.addTransition(t);
        rp.addArc(arcE);
        rp.addArc(arcS);
        assertTrue(rp.step());
        assertEquals(0, pIn.getTokens());
        assertEquals(1, pOut.getTokens());
    }

    @Test
    void testStepFiresOnlyOneTransition() {
        // t et t2 envoient chacune un jeton dans pOut : un pas n'en tire qu'une
        Transition t2 = new Transition("T2");
        rp.addTransition(t);
        rp.addTransition(t2);
        rp.addArc(arcS);
        rp.addArc(new ArcSortant(pOut, t2, 1));
        rp.step();
        assertEquals(1, pOut.getTokens());
    }

    @Test
    void testStepNoFireableTransition() {
        // pIn est vide : aucune transition franchissable, step() rend false
        pIn.removeTokens(1);
        rp.addTransition(t);
        rp.addArc(arcE);
        assertFalse(rp.step());
    }
}
