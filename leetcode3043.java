class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

  HashSet<String> prefixs = new HashSet<>();

  int maxlength = 0;

  for(int nums : arr1){

    String s = String.valueOf(nums);

    for(int i = 1 ; i<=s.length() ; i++){

        prefixs.add(s.substring(0,i));
    }
  }


  for(int nums : arr2){

    String s = String.valueOf(nums);

    for(int i = 1;i<=s.length() ; i++ ){



        String prefix = s.substring(0,i);

        if(prefixs.contains(prefix)){
            maxlength = Math.max(maxlength,prefix.length());

        }
    }
  }


  return maxlength;

        
    }
}
