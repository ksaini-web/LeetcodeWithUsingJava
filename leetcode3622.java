class Solution {
    public boolean checkDivisibility(int n) {


        int sum = 0;
        int multiple = 1;

        int m = n;

        while(m >0)
        {

            int t = m % 10;
            sum = sum +t;

            multiple = multiple * t;

            m = m/10;

            



        }

  return n % (sum + multiple) == 0;


        
    }
}
