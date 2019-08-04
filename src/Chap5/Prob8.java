package Chap5;

import java.util.Collections;

/* Contains methods for the purpose of drawing a horizontal line from (x1, y) to (x2, y). A monochrome
*  screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one
*  byte.  The screen has width w, where w is divisible by 8 (i.e. no byte will be split across rows).
*  The height of the screen, of course, can be derived from the length of the array and the width. */
public class Prob8 {

    /* We recognize that if x1 and x2 are far away from each other, several full bytes will be
    *  contained between them.  These full bytes can be set one at a time by doing screen[byte_pos] =
    *  0xFF.  The residual start and end of the line can be set using masks. This method takes O(N) time
    *  where N is the number of full bytes between x1 and x2 and O(1) space. */
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;

        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width/8)*y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> (start_offset));
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        if ((x1/8) == (x2/8)) {
            byte mask = (byte) (start_mask & end_mask);
            screen[(width/8) * y + (x1/8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width/8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width/8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    // Prints a screen with a given width.
    public static void printScreen(byte[] screen, int width) {
        int height = screen.length / (width/8);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < (width/8); j++) {
                String str = Integer.toBinaryString(0x000000FF & screen[(width/8)*i + j]);
                String padding = String.join("", Collections.nCopies(8 - str.length(), "0"));
                System.out.print(padding + str);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        byte[] screen = new byte[16];
        drawLine(screen, 24, 2, 15, 0);
        drawLine(screen, 24, 6, 20, 1);
        printScreen(screen, 24);
    }
}
