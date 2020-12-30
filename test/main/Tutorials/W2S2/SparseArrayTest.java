package main.Tutorials.W2S2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SparseArrayTest {

    @Test
    public void testExample() {
        SparseArray.Street street = new SparseArray.Street(Arrays.asList("Ernie", "Cookie Monster", "Bert", "Count von Count", "Sam Eagle", "Statler", "Waldorf", "Big Bird", "Oscar the Grouch", "Elmo"));
        SparseArray.CookieList cookieList = new SparseArray.CookieList(street);
        cookieList.pruneStreet(Arrays.asList("Bert", "Sam Eagle", "Statler", "Waldorf", "Oscar the Grouch"));
        List<SparseArray.House> expected = Arrays.asList(new SparseArray.House(0, "Ernie"), new SparseArray.House(1, "Cookie Monster"), new SparseArray.House(3, "Count von Count"), new SparseArray.House(7, "Big Bird"), new SparseArray.House(9, "Elmo"));
        List<SparseArray.House> res = cookieList.listAllFriendlyHouses();
        assertEquals(expected, res);
    }

    @Test
    public void testNonInhabitants() {
        SparseArray.Street street = new SparseArray.Street(Arrays.asList("Ernie", "Cookie Monster", "Bert", "Count von Count", "Sam Eagle", "Statler", "Waldorf", "Big Bird", "Oscar the Grouch", "Elmo"));
        SparseArray.CookieList cookieList = new SparseArray.CookieList(street);
        cookieList.pruneStreet(Arrays.asList("Bert", "Grumpy", "Squidward", "Sam Eagle", "Statler", "Waldorf", "Eeyore", "Oscar the Grouch"));
        List<SparseArray.House> expected = Arrays.asList(new SparseArray.House(0, "Ernie"), new SparseArray.House(1, "Cookie Monster"), new SparseArray.House(3, "Count von Count"), new SparseArray.House(7, "Big Bird"), new SparseArray.House(9, "Elmo"));
        List<SparseArray.House> res = cookieList.listAllFriendlyHouses();
        assertEquals(expected, res);
    }

}