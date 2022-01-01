/**
 *      USACO 2021 - 12 - Problem 3 - Walking Home
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class WalkingHome {

    static BufferedReader f;
    static int[] results;

    public static void main(String[] args) throws IOException {

        // Input:
        f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(f.readLine());
        results = new int[T];

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

    static int solve() throws IOException {

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] empty = new boolean[N][N];
        for (int i = 0; i < N; i++)
        {
            String str = f.readLine();
            for (int j = 0; j < N; j++)
            {
                empty[i][j] = (str.charAt(j) == '.');
            }
        }

        int[][][][] grid = new int[N][N][K+1][2];
        grid[0][1][0][0] = empty[0][0] && empty[0][1] ? 1 : 0;
        grid[1][0][0][1] = empty[0][0] && empty[1][0] ? 1 : 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k <= K; k++)
                {
                    if (empty[i][j]) {
                        if (i > 0) {
                            grid[i][j][k][1] += grid[i-1][j][k][1];

                            if (k > 0) {
                                grid[i][j][k][1] += grid[i-1][j][k-1][0];
                            }
                        }
                        if (j > 0) {
                            grid[i][j][k][0] += grid[i][j-1][k][0];

                            if (k > 0) {
                                grid[i][j][k][0] += grid[i][j-1][k-1][1];
                            }
                        }
                    }
                }

        int result = 0;
        for (int k = 0; k <= K; k++)
        {
            result += grid[N-1][N-1][k][0] + grid[N-1][N-1][k][1];
        }

        return result;
    }
}