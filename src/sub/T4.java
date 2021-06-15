package sub;

// import java.util.Arrays;
// import java.util.Scanner;

import static java.lang.System.out;

public class T4 {
    public static void t4_main(int userSelect) throws Exception {
        // Scanner sc = new Scanner(System.in);

        // out.print("입력받을 줄의 개수를 입력하세요");
        // int userInput = sc.nextInt();
        // out.println(userInput);

        // String result = "";

        // for (int i = 0; i < userInput; i++) {

        // }

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // for (int i = 1; i <= n; i++) {
        // String str = sc.next();
        // for (int j = 1; j <= 10; j++) {
        // if (str.substring(0, j).equals(str.substring(j, j * 2))) {
        // out.println("#" + i + " " + j);
        // break;
        // } else if (!(str.substring(0, j).equals(str.substring(j, j + 1)))) {
        // out.println("#" + i + " " + j);
        // }
        // }
        // }

        // sc.close();

        // Scanner sc = new Scanner(System.in);
        // out.println("총 개수 입력 : ");
        // int userInputNumber = sc.nextInt();

        // int count = 0;
        // int inputNum = 0;

        // for (int i = 0; i < userInputNumber; i++) {
        // out.print("숫자 입력 : ");
        // inputNum = sc.nextInt();

        // // if (inputNum % 42 != 0) {
        // // out.print(inputNum + " - ");
        // // count++;
        // // }

        // if (!(inputNum % 42 == 0)) {
        // count++;
        // }
        // }

        // out.println(count);
        // sc.close();

        boolean bool[] = new boolean[10];
        // boolean notBoolArray = true;
        // Arrays.fill(bool, true);
        // Arrays.fill(bool, Boolean.TRUE);

        int count = 0;
        int countNormalValue = 0;

        out.println(bool.length);
        out.println(bool.toString());

        out.println("When its even and the `bool array` saves odd value..");
        // When the `i` is even number, then saves into the `countNormalValue`.
        // Other wise, check that the `i` is odd number and saves into the `count`.
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                countNormalValue++;
            } else {
                if (!(bool[i % 2])) {
                    out.println(i + " -- " + count);
                    count++;
                }
                bool[i % 2] = false;
            }
        }

        out.println(count);
        out.println(countNormalValue + "---.");
        out.println("\n\n");

        // Initialize countNormalValue and count as `0`.
        countNormalValue = count = 0;

        out.println("When its odd and the `bool array` saves even value..");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                countNormalValue++;
            } else {
                if (bool[i % 2]) {
                    count++;
                }
                bool[i % 2] = true;
            }
        }

        out.println(count);
        out.println(countNormalValue + "---.");
    }
}
