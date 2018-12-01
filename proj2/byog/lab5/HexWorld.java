package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    class Position {
        public int xx;
        public int yy;

        public Position(int x, int y) {
            this.xx = x;
            this.yy = y;
        }
    }

    public static void main(String[] args) {
    }



    /**
     * rowNumber [0. 2*sideLength-1]  if rowNumber >= sideLength,
     * return rowNumber - (2*sideLength-1).
     */
    public static int nthRowOffPos(int sideLength, int n) {
        int offPosition = -n;
        if (n >= sideLength) {
            offPosition = n - (2 * sideLength - 1);
        }
        return offPosition;
    }

    public static int nthRowLength(int sideLength, int n) {
        int length = sideLength;
        if (n <= sideLength - 1) {
            length += 2 * n;
        } else {
            length += 2 * (2 * sideLength - 1 - n);
        }

        return length;
    }

    @Test
    public void testForNthRowOffPos() {
        assertEquals(-3, (nthRowOffPos(4, 3)));
        assertEquals(-3, (nthRowOffPos(4, 4)));
    }

    @Test
    public void testForNthRowLength() {
        assertEquals(10, nthRowLength(4,3));
        assertEquals(10, nthRowLength(4,4));
        assertEquals(8, nthRowLength(4,5));
    }

    public static void addHexagon(TETile[][] world, Position p, int sideLength, TETile tile) {
        for (int n = 0; n < 2 * sideLength; n++) {
            int startPosXX = p.xx + nthRowOffPos(sideLength, n);
            int yyPos = p.yy + n;

            for (int xxPos = startPosXX; xxPos < nthRowLength(sideLength, n); xxPos++) {
                world[xxPos][yyPos] = tile;
            }
        }
    }


}
