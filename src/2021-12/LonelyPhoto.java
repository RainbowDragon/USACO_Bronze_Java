/**
 *      USACO 2021 - 12 - Problem 1 - Lonely Photo
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class LonelyPhoto {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(f.readLine());
        String str = f.readLine();

        long result = getCount(str, 'G') + getCount(str, 'H');

        out.println(result);
        out.close();
    }

    public static long getCount(String str, char c) {

        long result = 0;

        int start = 0;
        int end = 0;
        int count = 0;
        int last = -1;
        for (end = 0; end < str.length(); end++)
        {
            if (str.charAt(end) == c) {
                count++;

                if (count > 1) {
                    start = last + 1;
                    count--;
                }

                last = end;
            }

            if (count == 1 && end - start >= 2) {

                int endLength = end - last + 1;
                result += last - start;

                if (endLength >= 3) {
                    result++;
                }
                if (endLength == 1) {
                    result--;
                }
            }
        }

        return result;
    }
}