/**
 *      USACO 2022 - 01 - Problem 2 - Non-Transitive Dice
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class NonTransitiveDice {

    static BufferedReader f;

    public static void main(String[] args) throws IOException {

        // Input:
        f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = Integer.parseInt(f.readLine());

        for (int i = 0; i < t; i++)
        {
            if (solve()) {
                out.println("yes");
            }
            else {
                out.println("no");
            }
        }

        out.close();
    }

    static boolean solve() throws IOException {

        StringTokenizer st = new StringTokenizer(f.readLine());

        int[] A = new int[4];
        int[] B = new int[4];
        for (int i = 0; i < 4; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 4; i++)
        {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int acb = compare(A, B);
        if (acb == 0) {
            return false;
        }

        if (acb < 0) {
            for (int i = 0; i < 4; i++)
            {
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            }
        }

        int[] C = new int[4];
        for (int a = 1; a <= 10; a++)
            for (int b = a; b <= 10; b++)
                for (int c = b; c <= 10; c++)
                    for (int d = c; d <= 10; d++)
                    {
                        C[0] = a;
                        C[1] = b;
                        C[2] = c;
                        C[3] = d;
                        if (compare(A, C) < 0 && compare(B, C) > 0) {
                            return true;
                        }
                    }

        return false;
    }

    static int compare(int[] A, int[] B) {

        int winA = 0;
        int winB = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
            {
                if (A[i] > B[j]) {
                    winA++;
                }
                else if (A[i] < B[j]) {
                    winB++;
                }
            }

        return winA - winB;
    }
}