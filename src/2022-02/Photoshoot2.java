/**
 *      USACO 2022 - 02 - Problem 2 - Photoshoot 2
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Photoshoot2 {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        int[] lineup = new int[n+1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 1; i <= n; i++)
        {
            lineup[i] = Integer.parseInt(st.nextToken());
        }

        int[] order = new int[n+1];
        st = new StringTokenizer(f.readLine());
        for (int i = 1; i <= n; i++)
        {
            int index = Integer.parseInt(st.nextToken());
            order[index] = i;
        }

        int[] number = new int[n+1];
        for (int i = 1; i <= n; i++)
        {
            number[i] = order[lineup[i]];
        }

        int result = 0;
        int last = 0;
        for (int i = 1; i <= n; i++)
        {
            if (number[i] > last) {
                last = number[i];
            }
            else {
                result++;
            }
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(result);
        out.close();
    }
}