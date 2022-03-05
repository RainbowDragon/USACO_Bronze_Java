/**
 *      USACO 2022 - 02 - Problem 3 - Blocks
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Blocks {

    static boolean[][] blocks;
    static boolean[] results;

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        blocks = new boolean[4][26];
        for (int i = 0; i < 4; i++)
        {
            String str = f.readLine();
            for (int j = 0; j < str.length(); j++)
            {
                blocks[i][str.charAt(j)-'A'] = true;
            }
        }

        results = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            String word = f.readLine();
            ArrayList<Integer> order = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++)
            {
                order.add(j);
            }
            results[i] = solve(word, order, 0, 0);
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for (int i = 0; i < n; i++)
        {
            if (results[i]) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
        }

        out.close();
    }

    public static boolean solve(String word, ArrayList<Integer> order, int first, int index) {

        if (index == word.length()) {
            return true;
        }

        for (int i = first; i < order.size(); i++)
        {
            Collections.swap(order, first, i);
            if (blocks[order.get(first)][word.charAt(index)-'A'] && solve(word, order, first+1, index+1)) {
                return true;
            }
            Collections.swap(order, first, i);
        }

        return false;
    }
}