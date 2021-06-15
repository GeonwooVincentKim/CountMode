package sub;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import feature.Value.RandomNumber;

public class T1 {
    public static int randomNumber(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public static Scanner readFile() throws Exception {
        Scanner sc = null;
        File file = new File("T1.txt");

        sc = new Scanner(file);
        return sc;
    }

    public static void writeFile(String getResult) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("T1_result.txt");
            fileWriter.write(getResult);
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 0. random 값을 n1 ~ n2 의 값만큼 범위를 지정받는다.
    public static int randomList(RandomNumber randomNumber, int n1, int n2) {
        return randomNumber.extractRandomNumber(n1, n2);
    }

    // 1. randomList 의 값의 범위는 11 ~ 99 로 지정,
    // 그리고 지정된 값 내의 값들을 getRandomArray 의 크기만큼
    // random 된 수를 넘겨받는다.
    public static int[] getRandomNumber(RandomNumber randomNumber, int[] getRandomArray) {
        return randomNumber.getRandomNumber(getRandomArray);
    }

    // 2. getRandomArray 로부터 넘겨받은 값들을 출력한다.
    public static String printRandomNumber(RandomNumber randomNumber, int[] getRandomArray) {
        return randomNumber.printRandomNumber(getRandomArray);
    }

    // 랜덤 값을 넘겨받는 과정부터, 랜덤 값을 출력을 진행하는 Method 이다.
    public static String getData(int getUserInput) {
        String result = "";
        String loopResult = "";

        int[] getArraySize = new int[getUserInput];
        RandomNumber randomNumber = new RandomNumber();

        getArraySize = getRandomNumber(randomNumber, getArraySize);
        out.println();

        loopResult = printRandomNumber(randomNumber, getArraySize);
        out.println(loopResult);

        result = loopResult + "\n";

        return result;
    }

    // getData 의 result 값을 출력한다.
    public static void getResult(int getValue) {
        String getResult = getData(getValue);
        writeFile(getResult);
    }

    // T1.java 의 전체적인 Process 를 조절하는 Method 이다.
    public static void t1_main(int selectNum) throws Exception {
        Scanner sc = new Scanner(System.in);
        out.println("메뉴를 선택하세요\n1. 파일 입출력\n2. 직접 입력");

        int userSubMenuInput = sc.nextInt();
        Scanner fileReader = null;

        if (userSubMenuInput == 1) {
            fileReader = readFile();
            int getValue = Integer.parseInt(fileReader.nextLine());
            getResult(getValue);
            fileReader.close();
        } else if (userSubMenuInput == 2) {
            fileReader = new Scanner(System.in);
            out.print("데이터 수량을 입력해주세요 : ");
            int getValue = fileReader.nextInt();
            getResult(getValue);
            fileReader.close();
        }

        sc.close();
    }
}
