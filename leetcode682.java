class Solution {
    public int calPoints(String[] operations) {

        List<Integer> ans = new ArrayList<>();

        for(int i=0 ;i<operations.length ; i++){

            String ch = operations[i];
             int n = ans.size() - 1;

            if(ch.equals("+")){

               
              
              if(n >0){
                ans.add(ans.get(n-1)+ans.get(n));
              }
             
            }else if(ch.equals("C")){
                
                ans.remove(n);
            }else if(ch.equals("D")){

                ans.add(2*ans.get(n));
            }else{
                ans.add(Integer.parseInt(ch));
            }
        }
        int sum =0;

        for(int num : ans){

            sum+=num;
        }

        return sum;
        
    }
}
