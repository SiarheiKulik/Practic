package by.htp.epam12.task02.comparator;

import by.htp.epam12.task02.composite.Component;
import by.htp.epam12.task02.composite.ComponentType;
import by.htp.epam12.task02.composite.TextComposite;
import by.htp.epam12.task02.composite.Word;
import by.htp.epam12.task02.exception.ProjectException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WordLenghtComparatorTest {
    TextComposite firstSentence;
    TextComposite secondSentence;
    TextComposite lexeme;
    TextComposite word;

    @BeforeClass
    public void setUp() {
        firstSentence = new TextComposite(ComponentType.SENTENCE);
        secondSentence = new TextComposite(ComponentType.SENTENCE);
        lexeme = new TextComposite(ComponentType.LEXEME);
        word = new TextComposite(ComponentType.WORD);
    }

    @Test
    public void compareTest() {
        List<Component> expected;
        List<Component> actual;

        try {
            word.add(new Word("example"));
        } catch (ProjectException e) {
            Assert.fail();
        }

        lexeme.add(word);
        firstSentence.add(lexeme);

        secondSentence = new TextComposite(ComponentType.SENTENCE);
        lexeme = new TextComposite(ComponentType.LEXEME);
        word = new TextComposite(ComponentType.WORD);

        try {
            word.add(new Word("q"));
        } catch (ProjectException e) {
            Assert.fail();
        }

        lexeme.add(word);
        secondSentence.add(lexeme);

       /* expected = (List.of(secondSentence, firstSentence));
        actual = new ArrayList<>(List.of(firstSentence, secondSentence));
        actual.sort(new WordLenghtComparator());

        Assert.assertEquals(actual, expected);*/
    }
}
