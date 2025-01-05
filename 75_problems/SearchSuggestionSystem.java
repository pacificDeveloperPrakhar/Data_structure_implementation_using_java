import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the products lexicographically
        Arrays.sort(products);

        int l = 0; // Left pointer
        int r = products.length - 1; // Right pointer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            // Move left pointer to filter out products that don't match
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }

            // Move right pointer to filter out products that don't match
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }

            // Collect up to 3 products that match the current prefix
            List<String> t = new ArrayList<>();
            for (int j = l; j <= r && t.size() < 3; j++) {
                t.add(products[j]);
            }

            ans.add(t); // Add the current suggestions to the answer
        }

        return ans;
    }
}
