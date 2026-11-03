package petri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlace {
    private Place p;

    @BeforeEach
    void setUp() {
        p = new Place("P0", 0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPlace() {
        Place p3 = new Place("P3", 3);
        assertEquals("P3", p3.getName());
        assertEquals(3, p3.getJetons());
    }

    @Test
    void testGetName() {
        assertEquals("P0", p.getName());
    }

    @Test
    void testToString() {
        assertTrue(p.toString().contains("P0"));
    }

    @Test
    void testGetJetons() {
        assertEquals(0, p.getJetons());
    }

    @Test
    void testAjouterJetons() {
        p.ajouterJetons(2);
        assertEquals(2, p.getJetons());
        p.ajouterJetons(3);
        assertEquals(5, p.getJetons());
    }

    @Test
    void testRetirerJetons() {
        p.ajouterJetons(5);
        p.retirerJetons(2);
        assertEquals(3, p.getJetons());
        p.retirerJetons(3);
        assertEquals(0, p.getJetons());
    }

    @Test
    void testRetirerJetonsTropNombreux() {
        Place p1 = new Place("P0",5);
        assertEquals(5,p1.getJetons());
        p1.retirerJetons(8);
        assertEquals(5,p1.getJetons());
    }
}
