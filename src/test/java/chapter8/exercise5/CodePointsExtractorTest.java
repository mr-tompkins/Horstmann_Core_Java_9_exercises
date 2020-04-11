package chapter8.exercise5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

//TODO finish

@RunWith(JUnit4.class)
public class CodePointsExtractorTest {

    final String TEST_STRING = "dziad\ud835\udd46iniceięcy";
    private CodePointsExtractor codePointsExtractor;

    public CodePointsExtractorTest() {
        this.codePointsExtractor = new CodePointsExtractor();
    }

    @Test
    public void generates() {
        codePointsExtractor.extract(TEST_STRING).forEach(System.out::println);
        //System.out.println(codePointsExtractor.extract(TEST_STRING));
        System.out.println("\nCode Points:" +  TEST_STRING.codePoints().count());
        System.out.println("Code Units:" +  TEST_STRING.length());
    }

}
