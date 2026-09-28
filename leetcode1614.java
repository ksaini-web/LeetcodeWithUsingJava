class Solution {
    public int maxDepth(String s) {

        int count = 0;

        int maxdepth = 0;
        
        for(int i=0 ;i<s.length() ;i++){

            if(s.charAt(i) == '('){

                count ++;

                maxdepth = Math.max(maxdepth,count);
            }
            else if(s.charAt(i) == ')'){

                count--;

            }
        }

        return maxdepth
        ;
    }
}
