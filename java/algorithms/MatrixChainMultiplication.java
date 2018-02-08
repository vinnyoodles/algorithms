public class MatrixChainMultiplication {
    public static void main(String[] args) {
        System.out.println(solve(new int[] { 6, 4, 30, 2, 10, 5 }));
    }

    public static int solve(int[] matrices) {
        int length = matrices.length;
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int jump = 1; jump < length - 1; jump ++) {
            for (int i = 1; i + jump < length; i ++) {
                int j = i + jump;
                int product = matrices[i - 1] * matrices[j];
                for (int k = i; k < j; k ++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (product * matrices[k]));
                }
            }
        }

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    System.out.print("-\t");
                } else {
                    System.out.print(dp[i][j] + "\t");
                }
            }
            System.out.println("");
        }

        return dp[1][length - 1];
        
    }
}
