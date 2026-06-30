class Solution {
    public boolean detectCapitalUse(String word) {

        int n  = word.length();

        if(n>1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && word.charAt(1) >= 'A' && word.charAt(1) <= 'Z' ){

            for(int i =2 ;i<n;i++){

                if(!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')){
                    return false;
                }
            }
            return true;
        }

        for(int  i = 1;i<n ;i++){

            if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                return false;
            }
        }

        return true;
        
    }
}
