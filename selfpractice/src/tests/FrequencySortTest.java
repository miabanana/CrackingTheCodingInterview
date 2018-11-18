package tests;

import main.FrequencySort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by huaying on 2018/11/17.
 */
public class FrequencySortTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private FrequencySort frequencySort;
    @Before
    public void setUp() throws Exception {
        frequencySort = new FrequencySort();
    }

    @Test
    public void frequencySort_oneDuplicateChar() throws Exception {
        String input = "abbbc";
        String expected1 = "bbbac";
        String expected2 = "bbbca";

        String actual = frequencySort.frequencySort(input);

        Assert.assertTrue(actual.equals(expected1) || actual.equals(expected2));
    }

    @Test
    public void frequencySort_twoDuplicateChar() throws Exception {
        String input = "abbccc";
        String expected = "cccbba";

        String actual = frequencySort.frequencySort(input);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void frequencySort_null_throwNullPointerException() throws Exception {
        String input = null;

        exception.expect(NullPointerException.class);

        frequencySort.frequencySort(input);
    }
}