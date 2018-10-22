package com.test.arrays;

public class ShuffleArray {
    // Shuffles an array of size 2n.
// Indexes are considered starting
// from 1.
    static void shufleArray(int []a, int n)
    {
        int temp;
        n = n / 2;

        for (int start = n + 1, j = n + 1, done = 0, i;
             done < 2 * n - 2; done++)
        {
            if (start == j)
            {
                start--;
                j--;
            }

            i = j > n ? j - n : j;
            j = j > n ? 2 * i : 2 * i - 1;
            temp= a[start];
            a[start]= a[j];
            a[j]= temp;

        }
    }

    // Driver code
    static public void main (String[] args)
    {
        // The first element is bogus. We have used
        // one based indexing for simplicity.
        int []a = {-1, 1, 3, 5, 7, 2, 4, 6, 8};
        int n = a.length;

        shufleArray(a, n);

        for (int i = 1; i < n; i++)
            System.out.print(a[i] +" ");

    }
}
