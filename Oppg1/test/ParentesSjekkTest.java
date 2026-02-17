import Stabel.ParantesSjekk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestParentesSjekk {

    private ParantesSjekk sjekk1 = new ParantesSjekk();

    @BeforeEach
    void clear() {
        sjekk1.clear();
        sjekk1.push("([{}])");
    }

    @Test
    void peek() {
        assertEquals("([{}])", sjekk1.peek());
    }

    @Test
    void push() {
        assertEquals("([{}])", sjekk1.peek());
        sjekk1.push("(([[]]))");
        assertEquals("(([[]]))", sjekk1.peek());
    }

    @Test
    void pop() {
        assertEquals("([{}])", sjekk1.peek());
        sjekk1.pop();
        assertEquals(null, sjekk1.peek());
    }

    @Test
    void isEmpty() {
        assertFalse(sjekk1.isEmpty());
        sjekk1.clear();
        assertTrue(sjekk1.isEmpty());
    }

    @Test
    void SjekkParenteser() {
        assertTrue(sjekk1.SjekkParenteser("{ [ ( ) ] }"));
        assertFalse(sjekk1.SjekkParenteser("{ [ ( ) }"));
        assertFalse(sjekk1.SjekkParenteser("[ ( ) ] }"));
        assertFalse(sjekk1.SjekkParenteser("{ [ ( ] ) }"));
    }

}
