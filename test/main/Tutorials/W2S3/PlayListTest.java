package main.Tutorials.W2S3;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PlayListTest {
    public final String[] SONGS = {"Raise Your Banner - Within Temptation", "Pearl in a World of Dirt - Beyond the Black", "Bring Me to Life - Evanescence", "I Am the Fire - Halestorm", "All Star - Smash Mouth", "Never Gonna Give You Up - Rick Astley", "That's mathematics - Tom Lehrer", "Finite simple group of order two - Klein Group", "Labochevsky - Tom Lehrer", "A song about a circle constant - Vihart", "An awful lot of running - Chameleon Circuit", "The Element Song - Tom Lehrer", "Wonderwall - Oasis", "One - U2", "Californication - Red Hot Chili Peppers"};

    @Test
    public void testPlay() {
        String[] exampleSongs = {"That's mathematics - Tom Lehrer", "Finite simple group of order two - Klein Group", "Labochevsky - Tom Lehrer", "A song about a circle constant - Vihart", "An awful lot of running - Chameleon Circuit", "The Element Song - Tom Lehrer"};
        PlayList playList = new PlayList(exampleSongs);
        assertEquals("That's mathematics - Tom Lehrer", playList.playSong());
    }

    @Test
    public void testPlayNext() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        assertEquals("Pearl in a World of Dirt - Beyond the Black", playList.nextSong());
    }

    @Test
    public void testPlayNextTwice() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        playList.nextSong();
        assertEquals("Bring Me to Life - Evanescence", playList.nextSong());
    }

    @Test
    public void testNextPrevious() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        playList.nextSong();
        playList.nextSong();
        playList.nextSong();
        assertEquals("Bring Me to Life - Evanescence", playList.previousSong());
    }

    @Test
    public void testNextPreviousNext() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        playList.nextSong();
        playList.previousSong();
        assertEquals("Pearl in a World of Dirt - Beyond the Black", playList.nextSong());
    }

    @Test
    public void testPreviousTwice() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        for (int i = 0; i < 5; i++) {
            playList.nextSong();
        }
        playList.previousSong();
        assertEquals("I Am the Fire - Halestorm", playList.previousSong());
    }

    @Test
    public void testBigEfficiency() {
        PlayList playList = new PlayList(SONGS);
        playList.playSong();
        for (int i = 0; i < 23000; i++) {
            for (int j = 0; j < 13; j++) {
                playList.nextSong();
            }
            for (int j = 0; j < 13; j++) {
                playList.previousSong();
            }
        }
        for (int i = 0; i < 13; i++) {
            playList.nextSong();
        }
        assertEquals("Californication - Red Hot Chili Peppers", playList.nextSong());
    }
}