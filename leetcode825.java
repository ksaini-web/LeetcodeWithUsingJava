class Solution {
    public String toGoatLatin(String sentence) {

        StringBuilder str = new StringBuilder();

        int count = 1;

        String [] words = sentence.split("\\s+");

        for(String word : words){

            char ch  = Character.toLowerCase(word.charAt(0));

            if(ch == 'a'|| ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u'){

                 str.append(word);

            }else{

                str.append(word.substring(1));
                str.append(word.charAt(0));
            }

            str.append("ma");

            for(int i = 0 ; i<count;i++){

                str.append("a");


            }
            count++;

            str.append(" ");

        }

     return   str.toString().trim();
        
    }
}
