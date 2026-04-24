class Solution {
    public int furthestDistanceFromOrigin(String moves) {
     int count =0 ;
     int black= 0;
        for(char c : moves.toCharArray()){

            if(c=='L'){
                count--;
            }
            else if(c=='R'){
                count++;
            }else{
                black++;
            }

        }

        return Math.abs(count)+black;
        
    }
}
