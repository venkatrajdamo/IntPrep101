/*
*You are given an integer array coins representing denominations of coins and an integer amount representing a total amount of money.
*Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
*Input:
*coins = [1, 2, 5], amount = 11
*Output:
*3
*/
package Dynamic;

public class FewestCoin {
    public int findFewestCoin(int[] coins, int target){
        int[] mem = new int[target+1];
        for(int i=0; i<=target; i++){
            mem[i] = Integer.MAX_VALUE;
        }
        mem[0]=0;
        for(int i=1; i<=target; i++){
            findSmallTarget(coins, i,0, 0, mem);
        }
        return mem[target] == Integer.MAX_VALUE? -1 : mem[target];
    }

    private int findSmallTarget(int[] coins, int target, int l, int x, int[] mem){
        if(target < 0 || x >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if(mem[target] != Integer.MAX_VALUE) return mem[target] + 1;
        if(target == 0){
            return l;
        }
        for(int i = x; i<coins.length; i++) {
            if(target >= coins[i]) {
                int a = findSmallTarget(coins, target - coins[i], l + 1, i, mem);
                int b = mem[target];//findSmallTarget(coins, target - coins[i], l + 1, i + 1, mem);
                int min = Math.min(a, b);
                if (mem[target] > min)
                    mem[target] = min;
            }
        }
        return mem[target];
    }
}
