/**
 *      USACO 2022 - 02 - Problem 1 - Sleeping in Class
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class SleepingInClass {

    static BufferedReader f;
    static int[] results;

    public static void main(String[] args) throws IOException {

        // Input:
        f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = Integer.parseInt(f.readLine());
        results = new int[t];

        for (int i = 0; i < t; i++)
        {
            results[i] = solve();
        }

        for (int i = 0; i < t; i++)
        {
            out.println(results[i]);
        }

        out.close();
    }

    static int solve() throws IOException {

        int n = Integer.parseInt(f.readLine());
        int[] sleep = new int[n];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++)
        {
            sleep[i] = Integer.parseInt(st.nextToken());
            sum += sleep[i];
        }

        int result = 0;
        for (int k = 1; k <= sum; k++)
        {
            if (sum % k == 0) {

                int current = k;
                boolean isValid = true;
                for (int i = 0; i < n; i++)
                {
                    if (sleep[i] > current) {
                        isValid = false;
                        break;
                    }
                    else {
                        current -= sleep[i];
                        if (current == 0) {
                            current = k;
                        }
                    }
                }

                if (current != k) {
                    isValid = false;
                }

                if (isValid) {
                    result = n - (sum / k);
                    break;
                }
            }
        }

        return result;
    }
}