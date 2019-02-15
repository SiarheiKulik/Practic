package by.htp.epam12.task02.comparator;

import by.htp.epam12.task02.composite.Component;
import by.htp.epam12.task02.composite.ComponentType;
import by.htp.epam12.task02.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceCountComparatorTest {
    TextComposite firstParagraph;
    TextComposite secondParagraph;
    TextComposite sentence;

    @BeforeClass
    public void init() {
        firstParagraph = new TextComposite(ComponentType.PARAGRAPH);
        secondParagraph = new TextComposite(ComponentType.PARAGRAPH);
        sentence = new TextComposite(ComponentType.SENTENCE);
    }

    @Test
    public void compareTest() {
        firstParagraph.add(sentence);
        firstParagraph.add(sentence);

        secondParagraph.add(sentence);

        List<Component> expected = Arrays.asList(secondParagraph, firstParagraph);
        List<Component> actual = Arrays.asList(firstParagraph, secondParagraph);

        actual.sort(new SentenceCoutComparator());

        Assert.assertEquals(actual, expected);
    }
}
