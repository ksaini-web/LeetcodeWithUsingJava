class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String ,Integer> map = new HashMap<>();
        Set<String>set = new HashSet<>();

        for(String str : banned){
       set.add(str);
          }

          paragraph = paragraph.toLowerCase().replaceAll("[^a-z]"," ");

          String [] words = paragraph.split("\\s+");

          String ans = "";

          int max = 0;

          for(String word : words){

            if(word.length() == 0 || set.contains(word))
            continue;

            map.put(word,map.getOrDefault(word,0)+1);

            if(map.get(word)>max){

                max = map.get(word);

                ans = word;
            }
          } 

          return ans;

      
        


        
        
    }
}
