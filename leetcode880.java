class Solution {
    public String decodeAtIndex(String s, int k) {
        
        long size = 0;
        
        // Step 1: Find total decoded length
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }
        
        // Step 2: Traverse backwards
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            k %= size;
            
            // If k == 0 and current is letter → answer
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            
            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }
        
        return "";
    }
}
