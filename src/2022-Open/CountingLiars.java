/**
 *      USACO 2022 - Open - Problem 2 - Counting Liars
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class CountingLiars {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        ArrayList<Interval> points = new ArrayList<>();
        int numLe = 0;
        int numGr = 0;

        for (int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            points.add(new Interval(op, num));

            if (op.equals("L")) {
                numLe++;
            }
            else {
                numGr++;
            }
        }

        int result = 0;

        if (numLe != 0 && numGr != 0) {

            Collections.sort(points);

            int countLe = 0;
            int countGr = 0;

            for (int i = 0; i < n; i++)
            {
                if (points.get(i).dir.equals("L")) {
                    result = Math.max(result, countGr+numLe-countLe);
                    countLe++;
                }
                else {
                    countGr++;
                    result = Math.max(result, countGr+numLe-countLe);
                }
            }

            result = n - result;
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(result);
        out.close();
    }

    static class Interval implements Comparable<Interval> {

        public String dir;
        public int point;

        public Interval (String dir, int point) {
            this.dir = dir;
            this.point = point;
        }

        public int compareTo(Interval other) {

            if (this.point != other.point) {
                return this.point - other.point;
            }
            else {
                if (this.dir.equals("G")) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }
    }
}