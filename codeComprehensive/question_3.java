package codeComprehensive;

import java.util.Arrays;
import java.util.Scanner;

public class question_3 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) throws Exception {
        // Sort the integers
        Arrays.sort(arr);
        int minSum = 0, maxSum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= 1 && arr[i] <= 1000) {
                minSum+= arr[i];
            } else {
                throw new Exception("Integer Value Out Of Constraints");
            }
        }

        for (int i = 4; i > 0; i--) {
            if (arr[i] >= 1 && arr[i] <= 1000) {
                maxSum+= arr[i];
            } else {
                throw new Exception("Integer Value Out Of Constraints");
            }
        }
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
