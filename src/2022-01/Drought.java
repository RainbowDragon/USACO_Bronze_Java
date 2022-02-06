/**
 *      USACO 2022 - 01 - Problem 3 - Drought
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Drought {

    static BufferedReader f;
    static long[] results;

    public static void main(String[] args) throws IOException {

        // Input:
        f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(f.readLine());
        results = new long[T];

        for (int i = 0; i < T; i++)
        {
            results[i] = solve();
        }

        for (int i = 0; i < T; i++)
        {
            out.println(results[i]);
        }

        out.close();
    }

    static long solve() throws IOException {

        int N = Integer.parseInt(f.readLine());
        long[] hunger = new long[N];

        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++)
        {
            hunger[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;
        long last = hunger[0];
        boolean isValid = true;
        for (int i = 1; i < N; i++)
        {
            if (hunger[i] < last) {
                if (i % 2 == 1) {
                   isValid = false;
                }
                else {
                    result += i * (last - hunger[i]);
                    last = hunger[i];
                }
            }
            else if (hunger[i] > last) {
                if (i < N-1 && hunger[i+1] >= hunger[i] - last) {
                    result += 2 * (hunger[i] - last);
                    hunger[i+1] -= hunger[i] - last;
                }
                else {
                    isValid = false;
                }
            }
        }

        if (!isValid) {
            result = -1;
        }

        return result;
    }
}