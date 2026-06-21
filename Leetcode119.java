class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> Ans = new ArrayList<>();

        for(int i = 0;i<=rowIndex ;i++){
     List<Integer> row = new ArrayList<>();

            for(int j =0 ;j<=i ;j++){

              

                if(j==0 || j==i){

                    row.add(1);
                }else{

                   row.add(Ans.get(i-1).get(j-1)+Ans.get(i-1).get(j));
                }


            }
            Ans.add(row);
        }

        return Ans.get(rowIndex);
        
    }
}
