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
        assertEquals(3, p3.getTokens());
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
    void testGetTokens() {
        assertEquals(0, p.getTokens());
    }

    @Test
    void testAddTokens() {
        p.addTokens(2);
        assertEquals(2, p.getTokens());
        p.addTokens(3);
        assertEquals(5, p.getTokens());
    }

    @Test
    void testRemoveTokens() {
        p.addTokens(5);
        p.removeTokens(2);
        assertEquals(3, p.getTokens());
        p.removeTokens(3);
        assertEquals(0, p.getTokens());
    }

    @Test
    void testRemoveTooManyTokens() {
        Place p1 = new Place("P0",5);
        assertEquals(5,p1.getTokens());
        p1.removeTokens(8);
        assertEquals(5,p1.getTokens());
    }
}
