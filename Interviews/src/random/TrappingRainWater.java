package random;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedWater = 0;

        // Compute left max for each index
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Compute right max for each index
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {

            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
            System.out.println("i: " + i + " Left: " + leftMax[i] + " Right: " + rightMax[i] + " TrappedWater: " + trappedWater);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("Output 1: " + trap(height1) + "\n"); // Output: 6
        System.out.println("Output 2: " + trap(height2)); // Output: 9
    }
}