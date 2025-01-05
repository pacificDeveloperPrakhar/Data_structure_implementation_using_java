class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (p2 > p1) {
            // Determine the index of the shorter line
            int min_index = height[p2] > height[p1] ? p1 : p2;

            // Calculate the new area
            int new_area = (p2 - p1) * height[min_index];

            // Update the maximum area
            area = Math.max(area, new_area);

            // Move pointers to find a potentially larger area
            while (height[min_index] >= height[p2] && p2 > p1) {
                p2--;
            }
            while (height[min_index] >= height[p1] && p2 > p1) {
                p1++;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Call the maxArea method and print the result
        int result = solution.maxArea(height);
        System.out.println("The maximum area is: " + result);
    }
}
