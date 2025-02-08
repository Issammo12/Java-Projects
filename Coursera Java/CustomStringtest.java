import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringTest {

    // Declare custom string for testing
    CustomString myCustomString;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize custom string for testing
        this.myCustomString = new CustomString();
    }

    @Test
    void testGetString() {
        // String should be null to start, before setting it
        assertNull(this.myCustomString.getString());

        this.myCustomString.setString("hello");
        assertEquals("hello", this.myCustomString.getString());

        // Additional test cases
        this.myCustomString.setString("123");
        assertEquals("123", this.myCustomString.getString());

        this.myCustomString.setString("ABcd");
        assertEquals("ABcd", this.myCustomString.getString());

        this.myCustomString.setString("");
        assertEquals("", this.myCustomString.getString());
    }

    @Test
    void testSetString() {
        // String should be null to start, before setting it
        assertNull(this.myCustomString.getString());

        this.myCustomString.setString("Good-bye!");
        assertEquals("Good-bye!", this.myCustomString.getString());

        // Additional test cases
        this.myCustomString.setString("Hello World!");
        assertEquals("Hello World!", this.myCustomString.getString());

        this.myCustomString.setString("JAVA");
        assertEquals("JAVA", this.myCustomString.getString());

        this.myCustomString.setString(null);
        assertNull(this.myCustomString.getString());
    }

    @Test
    void testRemove() {
        assertEquals("", this.myCustomString.remove(""));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.remove(""));

        this.myCustomString.setString("my lucky numbers are 6, 8, and 19.");
        assertEquals("my lucky numbes e 6, 8, nd 19.", this.myCustomString.remove("ra6"));

        // Additional test cases
        this.myCustomString.setString("apple");
        assertEquals("pple", this.myCustomString.remove("a"));

        this.myCustomString.setString("banana");
        assertEquals("bn", this.myCustomString.remove("aa"));

        this.myCustomString.setString("hello world");
        assertEquals("hello wrld", this.myCustomString.remove("o"));
    }

    @Test
    void testReverse() {
        assertEquals("", this.myCustomString.reverse(""));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.reverse(""));

        this.myCustomString.setString("abc, XYZ; 123.");
        assertEquals("aBC, xyz; 123.", this.myCustomString.reverse("bcdxyz@3210."));

        // Additional test cases
        this.myCustomString.setString("Java");
        assertEquals("jAVa", this.myCustomString.reverse("ja"));

        this.myCustomString.setString("Hello");
        assertEquals("hELLo", this.myCustomString.reverse("he"));

        this.myCustomString.setString("world");
        assertEquals("woRLd", this.myCustomString.reverse("wr"));
    }

    @Test
    void testFilterLetters() {
        assertEquals("", this.myCustomString.filterLetters('E', false));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.filterLetters('E', false));

        // Additional test cases
        this.myCustomString.setString("hello world");
        assertEquals("hll wrld", this.myCustomString.filterLetters('o', false));

        this.myCustomString.setString("Hello");
        assertEquals("e", this.myCustomString.filterLetters('e', true));

        this.myCustomString.setString("Java");
        assertEquals("J", this.myCustomString.filterLetters('j', true));
    }
}
