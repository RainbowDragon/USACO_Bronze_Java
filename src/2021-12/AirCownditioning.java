/**
 *      USACO 2021 - 12 - Problem 2 - Air Cownditioning
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class AirCownditioning {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(f.readLine());

        int[] prefers = new int[n+1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 1; i <= n; i++)
        {
            prefers[i] = Integer.parseInt(st.nextToken());
        }

        int[] diffs = new int[n+2];
        st = new StringTokenizer(f.readLine());
        for (int i = 1; i <= n; i++)
        {
            diffs[i] = prefers[i] - Integer.parseInt(st.nextToken());
        }

        long result = 0;
        for (int i = 0; i <= n; i++)
        {
            result += Math.abs(diffs[i+1] - diffs[i]);
        }
        result = result / 2;

        out.println(result);
        out.close();
    }
}