package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    Quiz quiz = new Quiz();

    @BeforeEach
    void init() {
        quiz.readFile(Paths.get("src/test/resources/results.txt"));
    }

    @Test
    void testReadFile() {
        assertEquals("ABACD", quiz.getCorrectAnswer());
        assertEquals(4, quiz.getPlayers().keySet().size());
    }

    @Test
    void testReadFileException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> quiz.readFile(Paths.get("src/test/resources/resaaaults.txt")));
        assertEquals("Can not read file.", iae.getMessage());
    }

    @Test
    void testGaveCorrectAnswer() {
        assertTrue(quiz.gaveCorrectAnswer("AH2", 2));
        assertFalse(quiz.gaveCorrectAnswer("AB123", 3));
    }

    @Test
    void testPlayerWithMostPoints() {
        assertEquals("GH1234", quiz.playerWithMostPoints());
    }

    @Test
    void testGetPlayerPoints(){
        assertEquals(-5, quiz.getPlayerPoints("AB123"));
        assertEquals(10, quiz.getPlayerPoints("AH2"));
        assertEquals(2, quiz.getPlayerPoints("BD452"));
        assertEquals(15, quiz.getPlayerPoints("GH1234"));
    }
}