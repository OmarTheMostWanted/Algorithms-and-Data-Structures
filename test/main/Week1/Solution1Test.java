package main.Week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Solution1Test {

    @Test
    public void checkPrime1() {
        boolean res = Solution1.isPrime(0);
        assertFalse(res);
    }

    @Test
    public void checkTotalPNumbers1() {
        int res = Solution1.numPrimes(10);
        assertEquals(4, res);
    }

}