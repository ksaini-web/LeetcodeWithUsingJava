class Solution {
    public int maximumSwap(int arr) { 

        char [] num = String.valueOf(arr).toCharArray();

        int  ans = arr ;

        for(int i =0 ;i<num.length ; i++){

            for(int j = i+1 ;j<num.length ; j++){

                char temp = num[i];
            num[i] = num[j];
            num[j] = temp;


            ans =  Math.max(ans,Integer.parseInt(new String(num)));

            char temp2 = num[i];
            num[i] = num[j];
            num[j] = temp2;


            }
        }

        return ans;
        
    }
}
