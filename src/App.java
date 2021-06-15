import static java.lang.System.out;
import static sub.T1.t1_main;
import static sub.T2.t2_main;
import static sub.T3.t3_main;
import static sub.T4.t4_main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        out.println("메뉴 선택\n1. T1\n2. T2\n3. T3\n4. T4\nOther Key. Quit");
        int userSelectionInput = sc.nextInt();

        if (userSelectionInput == 1) {
            t1_main(userSelectionInput);
        } else if (userSelectionInput == 2) {
            t2_main(userSelectionInput);
        } else if (userSelectionInput == 3) {
            t3_main(userSelectionInput);
        } else if (userSelectionInput == 4) {
            t4_main(userSelectionInput);
        } else {
            out.println("종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
