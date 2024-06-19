package com.jedi.problems.dp;

public class LongestPalindromeSubstring {
    static int count = 0;
    static int start = 0;
    static int end = 0;
    public static void main(String[] args) {
        String s = "kabacbbbbd";
        System.out.println(lps(s,0,s.length()-1));
        System.out.println("count = "+count);
        System.out.println("start = " + start);
        System.out.println("end = "  + end);
        System.out.println("res = " + s.substring(start,end+1));
        count =0;
        dplps(s);
        System.out.println(count);

    }

    public static int lps(String s, int i , int j)
    {
        count++;
        if(i>j) return 0;
        if(i==j) return 1;
        if(s.charAt(i) == s.charAt(j) && isPalindrome(s,i,j))
        {
            return j-i+1;
        }
        else
        {
            return Math.max(lps(s,i,j-1 ), lps(s,i+1,j));
        }
    }

    private static boolean isPalindrome(String s, int i, int j) {
        int st = i;
        int en = j;

        while(i<=j)
        {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        if((en-st)>(end-start))
        {
            start = st;
            end = en;
        }
        return true;
    }

    /**
     * dp[i][j] :
     *      i -> j represent if startIndex=i and endIndex=j , whether
     *      string in [i,j] is palindrome Or not
     *
     *      When i=j , it means single character hence true
     *      when i>j , it will be false because we are not seeing String backwards
     * @param s
     */
    private static void dplps(String s)
    {
        int n = s.length();
        boolean dp[][] = new boolean[s.length()][s.length()];
        //Fill the single chars to true
        for(int i=0 ; i<n; i++)
        {
            dp[i][i] = true;
        }
        int max = 0;
        int start = 0;
        //Fill for length 2
        for(int i = 0 ; i < n-1 ;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1] =true;
                start=i;
                max=2;
            }
        }
        //Fill for length 3 and above
        for(int len = 3 ; len <=n;len++)
    {
        for(int i =0 ; i <= ((n-1) - len + 1) ;i++)  //endIndex-startIndex+1 = length
        {                                            //startIndex = endIndex - length + 1
            count++;
            int j = len + i - 1;   //endIndex = length + startIndex -1

            if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
            {
                dp[i][j] =true;
                if(len > max)
                {
                    start=i;
                    max = len;
                }
            }
        }
    }

        System.out.println("longest palindromic substring is of length = " + max);
        System.out.println(s.substring(start,start+max));
    }
}
