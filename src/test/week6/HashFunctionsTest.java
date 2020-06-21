package test.week6;

import main.week6.HashFunctions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashFunctionsTest {
    private static final int DEFAULT_SIZE = 4;

    @Test
    public void testETHHashNull() {
        assertEquals(0, new ETHHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testETHHashHelloWorld() {
        assertEquals(1, new ETHHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testETHHashHelloWorld2xSize() {
        assertEquals(5, new ETHHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testETHHashArthurDent2xSize() {
        assertEquals(4, new ETHHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testETHHashFortyTwo2xSize() {
        assertEquals(2, new ETHHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }


    @Test
    public void testGNUCPPHashNull() {
        assertEquals(0, new GNUCPPHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testGNUCPPHashHelloWorld() {
        assertEquals(1, new GNUCPPHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCPPHashHelloWorld2xSize() {
        assertEquals(1, new GNUCPPHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCPPHashArthurDent2xSize() {
        assertEquals(4, new GNUCPPHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testGNUCPPHashFortyTwo2xSize() {
        assertEquals(3, new GNUCPPHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }


    @Test
    public void testGNUCC1HashNull() {
        assertEquals(0, new GNUCC1Hash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testGNUCC1HashHelloWorld() {
        assertEquals(1, new GNUCC1Hash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCC1HashHelloWorld2xSize() {
        assertEquals(1, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCC1HashArthurDent2xSize() {
        assertEquals(0, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testGNUCC1HashFortyTwo2xSize() {
        assertEquals(6, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }


    @Test
    public void testHashCodeHashNull() {
        assertEquals(0, new HashCodeHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testHashCodeHashHelloWorld() {
        assertEquals(3, new HashCodeHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testHashCodeHashHelloWorld2xSize() {
        assertEquals(3, new HashCodeHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testHashCodeHashArthurDent2xSize() {
        assertEquals(3, new HashCodeHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testHashCodeHashFortyTwo2xSize() {
        assertEquals(6, new HashCodeHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }
}
