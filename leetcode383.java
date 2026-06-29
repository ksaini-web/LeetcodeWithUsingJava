class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int [] Freq = new int[26];

        for(int i = 0;i<magazine.length() ;i++){

            

            Freq[magazine.charAt(i) - 'a']++;
        }

 for(int i = 0;i<ransomNote.length() ;i++){

    if(Freq[ransomNote.charAt(i) - 'a'] == 0){

        return false;
    }
Freq[ransomNote.charAt(i) - 'a']--;

 }

 return true;
        
        
    }
}
