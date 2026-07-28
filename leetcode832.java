class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for (int[] row : image) {
            int left = 0, right = row.length - 1;
            
            while (left <= right) {
                
                // If both are same, flip & invert
                if (row[left] == row[right]) {
                    row[left] = row[right] = row[left] ^ 1;
                }
                
                // else just swap (inversion handled automatically)
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                
                left++;
                right--;
            }
        }
        
        return image;
    }
}
