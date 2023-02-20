package codeComprehensive;

import java.util.Arrays;
import java.util.Scanner;

public class question_1 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) throws Exception {
        // Sort the integers
        Arrays.sort(arr);
        long minSum = arr[0] + arr[1] + arr[2] + arr[3];
        long maxSum = arr[4] + arr[3] + arr[2] + arr[1];
        System.out.print(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
