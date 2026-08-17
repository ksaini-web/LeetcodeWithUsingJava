class Solution {
   
    public int solve(int l ,int r ,int [] prefix,int[][] dp){

        if(l>=r){

        return 0;

        }
       if(dp[l][r] != -1){
        return dp[l][r];
       }
        int score = 0;

        for(int mid = l ; mid<r ; mid++){

            int leftsum = prefix[mid+1] - prefix[l];

            int rightsum = prefix[r+1] - prefix[mid+1];


            if(leftsum < rightsum){
               
               score = Math.max(score,leftsum+solve(l,mid,prefix,dp));
                
            }else if(leftsum > rightsum){
                score = Math.max(score,rightsum+solve(mid+1,r,prefix,dp));
            }else{
                  
                score =  Math.max(Math.max(score,leftsum+solve(l,mid,prefix,dp)),Math.max(score,rightsum+solve(mid+1,r,prefix,dp)));
            }
        }

        dp[l][r] = score;

        return score;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        int [] prefix = new int[n+1];

        for(int i =0 ;i<n ;i++){

            prefix[i+1] = prefix[i] + stoneValue[i];
        }

        int [][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0,n-1,prefix,dp);






        
    }
}
