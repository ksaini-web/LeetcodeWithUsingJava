class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
int n=grid.length;

        int [] freq = new int [n*n+1];

        int repitedNumber = 0;
        int missionNumber = 0;

      for(int i =0 ;i<n;i++){

        for(int j=0;j<grid[i].length;j++){
             
             int num=grid[i][j];

             freq[num]++;

             if(freq[num]==2){


repitedNumber = num;
                
             }

            
        }}

        for(int i =1;i<freq.length ;i++){

            if(freq[i] == 0){
          missionNumber = i; 

            }


        
        }

        return new int[]{repitedNumber,missionNumber};
    }
}
