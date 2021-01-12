package main.Week3.MainMatter.LazyDepthFirsttIterator;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(String string) {
        super(string);
    }

    public InvalidPositionException() {
        super("Invalid position");
    }
}
