package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz(Path.of("src/test/resources/result.txt"));

    @Test
    void isAnswerCorrect() {
        assertFalse(quiz.isAnswerCorrect("AH2",1));
        assertTrue(quiz.isAnswerCorrect("AH2",2));
    }

    @Test
    void getWinner() {
        assertEquals("GH1234",quiz.getWinner());
    }


    @Test
    void testCreate() {
        assertEquals(4,quiz.getContestants().size());
        assertEquals("ACCBX",quiz.getContestants().get("AB123"));
    }
}