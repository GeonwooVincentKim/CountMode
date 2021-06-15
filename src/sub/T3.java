package sub;

import java.util.Scanner;

import static java.lang.System.out;

public class T3 {
    public static void t3_main(int userSelectionInput) {
        Scanner sc = new Scanner(System.in);
        // out.println("문자 총 길이 입력 : ");

        int getInputStringLength = sc.nextInt();
        // char[] storeGetUserInput = new char[stringLength];

        // for (int i = 1; i <= stringLength; i++) {
        // // out.println("한 줄씩 입력하세요 : ");
        // getUserInput = sc.nextLine();

        // // storeGetUserInput = new char[getUserInput.length()];

        // for (int j = 1; j <= getUserInput.length(); j++) {
        // out.println(getUserInput);
        // }
        // }

        String first = "";
        String last = "";

        String result = ""; // pattern 이 있는 문자열을 저장한다.
        // String 을 입력받을 줄의 갯수만큼 순환시킨다.
        for (int i = 1; i <= getInputStringLength; i++) {
            // char[] storeArray = new char[getUserInput.length()];
            String pattern = ""; // 현재 문자열의 pattern 이 있는지 없는지 확인한다.

            boolean[] isCorrect = new boolean[200];
            // String first = "";

            int stringLength = 0;
            String getUserInput = sc.next(); // 각 줄마다 입력하는 getUserInput

            for (int j = 1; j <= getUserInput.length(); j++) {
                // storeArray[j] = getUserInput.charAt(j);
                // first = getUserInput.substring(0, j);
                // last = getUserInput.substring(j, j * 2);

                // if (first.equals(last)) {
                // result += "#" + i + " " + first.length() + "\n";
                // break;
                // } else {
                // if (!isCorrect[(int) getUserInput.charAt(j)]) {
                // isCorrect[(int) getUserInput.charAt(j)] = true;
                // pattern += getUserInput.charAt(j);
                // out.println(pattern);
                // }
                // // else {

                // // }
                // else {
                // String competition = "";
                // stringLength = pattern.length();
                // for (int k = stringLength; k < stringLength * 2; k++) {
                // competition += getUserInput.charAt(k);
                // // out.println(competition);
                // }
                // if (pattern.equals(competition))
                // break;
                // else {
                // pattern += getUserInput.charAt(i);
                // out.println(pattern);
                // }
                // }
                // }

                if (!isCorrect[(int) getUserInput.charAt(j)]) {
                    isCorrect[(int) getUserInput.charAt(j)] = true;
                    pattern += getUserInput.charAt(j);
                    out.println(pattern);
                }
                // else {

                // }
                else {
                    String competition = "";
                    stringLength = pattern.length();
                    for (int k = stringLength; k < stringLength * 2; k++) {
                        competition += getUserInput.charAt(k);
                        // out.println(competition);
                    }
                    if (pattern.equals(competition))
                        break;
                    else {
                        pattern += getUserInput.charAt(i);
                        out.println(pattern);
                    }
                }

                // out.print(getUserInput.charAt(j) + " ");
            }

            // out.println("#" + i + " " + stringLength);
            // result += "#" + i + " " + stringLength;
        }
        out.println(result);

        sc.close();
    }
}
