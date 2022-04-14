/**
 *      USACO 2022 - Open - Problem 3 - Alchemy
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Alchemy {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        int[] units = new int[n+1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 1; i <= n; i++)
        {
            units[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] recipes = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)
        {
            recipes[i] = new ArrayList<>();
        }

        int k = Integer.parseInt(f.readLine());
        for (int i = 0; i < k; i++)
        {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++)
            {
                int metal = Integer.parseInt(st.nextToken());
                recipes[l].add(metal);
            }
        }

        int result = 0;
        while (hasMore(units, recipes, n)) {
            result++;
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(result);
        out.close();
    }

    public static boolean hasMore(int[] units, ArrayList<Integer>[] recipes, int metal) {

        if (units[metal] > 0) {
            units[metal]--;
            return true;
        }

        if (recipes[metal].size() == 0) {
            return false;
        }

        for (int component : recipes[metal])
        {
            if (!hasMore(units, recipes, component)) {
                return false;
            }
        }

        return true;
    }
}