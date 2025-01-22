/*
Problem Statement:
You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top: 1 step + 1 step or 2 steps.

Input: n = 3
Output: 3
Explanation: There are three ways: 1+1+1, 1+2, or 2+1.
*/

package Dynamic;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        for(int i = 0; i < n ; i++){
            ways[i] = 0;
        }
        ways[0] = 1;
        ways[1] = 2;
        for(int i = 2; i < n ; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n-1];
    }
}
