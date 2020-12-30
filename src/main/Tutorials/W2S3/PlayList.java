package main.Tutorials.W2S3;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private LibraryStack libraryStack;
    private LibraryQueue libraryQueue;
    private String playing;

    /**
     * Constructor of the playlist, creates a playlist with the given songs.
     *
     * @param songs - the songs that will be part of this playlist
     */
    public PlayList(String[] songs) {
        libraryQueue = new LibraryQueue();
        libraryStack = new LibraryStack();
        playing = null;

        for (String s : songs) {
            libraryQueue.enqueueBack(s);
        }
    }

    /**
     * Starts playing the first song in the playlist, if no songs was playing yet.
     *
     * @return the first song that will be played if no song was playing, otherwise null
     */
    public String playSong() {
        if (playing == null) {
            playing = libraryQueue.dequeue();
            return playing;
        } else return null;
    }

    /**
     * Switches to the next song in the playlist.
     *
     * @return the next song in the playlist
     */
    public String nextSong() {
        if (playing != null) libraryStack.push(playing);
        if (!libraryQueue.isEmpty()) {
            playing = libraryQueue.dequeue();
        }
        return playing;
    }

    /**
     * Switches back to the previous song in the playlist.
     *
     * @return the previous song in the playlist
     */
    public String previousSong() {
        if (!libraryStack.isEmpty()) {
            if (playing != null) {
                libraryQueue.enqueueFront(playing);
                playing = libraryStack.pop();
                return playing;
            }
        }

        return null;
    }

    class LibraryStack {

        List<String> items;

        public LibraryStack() {
            items = new ArrayList<>();
        }

        public boolean isEmpty() {
            return this.items.isEmpty();
        }

        public void push(String s) {
            this.items.add(s);
        }

        public String pop() {
            return this.items.remove(this.items.size() - 1);
        }

        public String top() {
            return this.items.get(this.items.size() - 1);
        }
    }

    class LibraryQueue {

        List<String> items;

        public LibraryQueue() {
            items = new ArrayList<>();
        }

        public boolean isEmpty() {
            return this.items.isEmpty();
        }

        public void enqueueFront(String s) {
            this.items.add(0, s);
        }

        public void enqueueBack(String s) {
            this.items.add(s);
        }

        public String dequeue() {
            return this.items.remove(0);
        }

        public String first() {
            return this.items.get(0);
        }
    }
}
