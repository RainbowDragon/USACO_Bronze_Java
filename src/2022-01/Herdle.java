/**
 *      USACO 2022 - 01 - Problem 1 - Herdle
 *
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Herdle {

    public static void main(String[] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] answer = new String[3];
        for (int i = 0; i < 3; i++)
        {
            answer[i] = f.readLine();
        }

        String[] guess = new String[3];
        int[] answerCount = new int[26];
        int[] guessCount = new int[26];
        int result1 = 0;
        for (int i = 0; i < 3; i++)
        {
            guess[i] = f.readLine();
            for (int j = 0; j < 3; j++)
            {
                if (answer[i].charAt(j) == guess[i].charAt(j)) {
                    result1++;
                }
                else {
                    answerCount[answer[i].charAt(j)-'A']++;
                    guessCount[guess[i].charAt(j)-'A']++;
                }
            }
        }

        int result2 = 0;
        for (int i = 0; i < 26; i++)
        {
            result2 += Math.min(answerCount[i], guessCount[i]);
        }

        out.println(result1);
        out.println(result2);
        out.close();
    }
}