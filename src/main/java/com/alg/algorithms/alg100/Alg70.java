package com.alg.algorithms.alg100;

public class Alg70 {
    /**
     * 69. x的平方根
     * 二分查找
     * tag:BinarySearch
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int low=0,high=x,ans=-1;
        while (low<=high){
            int middle = (low+high)/2;
            long temp = (long) middle *middle;
            if (temp <=x){
                ans=middle;
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return ans;
    }

    /**
     * 70.爬楼梯
     * DP
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<=2) return n;
        int F1=1;
        int F2=2;
        int sum=0;
        for (int i=3;i<=n;i++){
            sum = F1+F2;
            F1=F2;
            F2=sum;
        }
        return sum;
    }
}
