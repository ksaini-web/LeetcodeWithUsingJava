class Solution {
    public boolean canReach(int[] arr, int start) {

        boolean[]vistied = new boolean[arr.length];

         return dfs(arr,start,vistied); 
        
    }

    private boolean dfs(int [] arr, int index,boolean [] vistied){

        if(index<0 || index>=arr.length){
            return false;
        }

        if(vistied[index]==true){
            return false;
        }

        if(arr[index]==0){
            return true;
        }

        vistied[index] = true;

        return dfs(arr,index+arr[index],vistied)||dfs(arr,index-arr[index],vistied);
    }
}
