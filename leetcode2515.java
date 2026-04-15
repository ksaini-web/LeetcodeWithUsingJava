class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {

    int n = words.length;

    for(int i =0 ;i<n ; i++){

        int left = (startIndex+i)%n;
        int right = (startIndex-i+n)%n;

        if(words[left].equals(target) || words[right].equals(target)){

            return i;
        }
    }

    return -1;




        
        
    }
}
