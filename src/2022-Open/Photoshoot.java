/**
 *      USACO 2022 - Open - Problem 1 - Photoshoot
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Photoshoot {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        String str = f.readLine();
        int result = 0;
        int last = 0;
        boolean init = false;
        for (int i = 0; i < str.length(); i += 2)
        {
            int cur = 0;
            if (str.charAt(i) == 'G' && str.charAt(i+1) == 'H') {
                cur = -1;
                init = true;
            }
            else if (str.charAt(i) == 'H' && str.charAt(i+1) == 'G') {
                cur = 1;
                init = true;
            }

            if (!init) {
                last = cur;
            }

            if (cur != 0 && cur != last) {
                last = cur;
                result++;
            }
        }

        if (last == 1) {
            result--;
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(result);
        out.close();
    }
}