package online.javabook.leetcode.array;

public class No1672RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{1, 2, 3}, {3, 2, 1}};
        int result = maximumWealth(nums);
        System.out.println(result);
    }

    public static int maximumWealth(int[][] accounts) {

        int maximumWealth = 0;
        for (int accountIndex = 0; accountIndex < accounts.length; accountIndex++) {
            int wealths[] = accounts[accountIndex];

            int totalWealth = 0;
            for (int wealthIndex = 0; wealthIndex < wealths.length; wealthIndex++) {
                totalWealth += wealths[wealthIndex];
            }

            if(totalWealth> maximumWealth) {
                maximumWealth = totalWealth;
            }
        }
        return maximumWealth;
    }
}
