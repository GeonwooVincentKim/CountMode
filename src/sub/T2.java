package sub;

import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import feature.Files.Manager.FileManager;
import feature.Value.RandomNumber;

public class T2 {
    // 불러 올 파일과 그 파일의 이름을 가지고 와 파일을 읽는다.
    public static Scanner readFile(FileManager fileManager, String fileName) {
        return fileManager.readFile(fileName);
    }

    // 저장할 파일과 그 파일의 이름을 가지고 온 후, 파일을 저장한다.
    public static void writeFile(FileManager fileManager, String fileName, String result) {
        fileManager.writeFile(fileName, result);
    }

    // Random 숫자들의 특정 범위를 지정하며, 특정 범위 내에 있는 값들을 return 한다.
    public static int extractRandomNumber(int minimum, int maximum) {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.extractRandomNumber(minimum, maximum);
    }

    // public static int extractRandomNumber(int minimum, int maximum) {
    // return (int) (Math.random() * (maximum - minimum + 1)) + minimum;
    // }

    // 4-1. 가지고 온 random 값의 중복이 제거 된 countArray 와 중복 제거가 되지 않은 randomArray 의
    // 각 데이터를 하나씩 가지고 온 후, 서로 같은 수가 나올 때마다 true 를 return 시킨다.
    public static boolean isContains(int[] countArray, int randomValue) {
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == randomValue) {
                return true;
            }
        }

        return false;
    }

    // 4-2. 가지고 온 random 값의 중복까지 모두 포함한 randomArray 배열의 값을 가져온다.
    // randomArray 배열 끝까지 돌면서, 만약 서로 같은 수가 나올 때마다 현재 빈도 수의 값을 나타내는 count 값을 1씩
    // 증가시킨다.
    public static int checkArrayFrequency(int[] randomArray, int randomValue) {
        int count = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == randomValue) {
                count++;
            }
        }

        return count;
    }

    // 4-3. 중복을 제거하지 않은 배열(countArray)를 가지고 온다.
    // 가지고 온 countArray 배열의 빈도 수 및 값들을 비교할 때,
    // 큰 빈도 수 또는 큰 값들은 뒤에서 앞으로 위치를 변경시키고,
    // 작은 빈도 수 또는 작은 값들은 앞에서 뒤로 위치를 변경시킨다.
    public static int swapArray(int[] array, int i, int j) {
        int tempValue = array[i];
        array[i] = array[j];
        array[j] = tempValue;

        return tempValue;
    }

    // 1. randomNumber 에서 가지고 온 random 수(난수)들을 randomArray 에 저장한다.
    // 사용자가 정한 읽어올 데이터의 개수만큼, 랜덤 수들을 temp 배열에 저장한다.
    public static int[] getRandomArray(int getDataValue) {
        int[] randomArray = new int[getDataValue];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = extractRandomNumber(11, 99);
        }

        return randomArray;
    }

    // 2. 현재 randomArary 배열 안에 있는 random 수들을 출력한 후, 확인한다.
    // 가져온 랜덤 수들을 담은 randomArray 를 출력한다.
    public static String printRandomArray(int[] randomArray) {
        String loopResult = ""; // random 수들을 출력하기 위해 사용하는 변수

        for (int i = 0; i < randomArray.length; i++) {
            loopResult += randomArray[i] + " ";
        }

        return loopResult;
    }

    // 3. 가져온 random 값들 중, 중복된 값들을 모두 제거하고, 중복되지 않은 random 값들만 가지고 와 저장한다.
    public static int[] getCountArray(int[] randomArray) {
        int[] countArray = new int[randomArray.length];

        for (int i = 0; i < randomArray.length; i++) {
            if (!(isContains(countArray, randomArray[i]))) {
                countArray[i] = randomArray[i];
                out.print(countArray[i] + " ");
            }
        }

        return countArray;
    }

    // 4. 중복을 제거하지 않고 모든 랜덤 수들을 저장한 배열(randomArary)과, 중복을 제거한 랜덤 수들이 담겨진
    // 배열(countArray) 를 가지고 온다.
    // 가장 먼저, 숫자들의 빈도 수를 서로 확인한 후, 큰 빈도 수대로 정렬을 하고,
    // 그 다음 가지고 온 수의 빈도 수가 서로 같다면, 값을 비교하여 큰 수부터 작은 수 순서로 내림차순 정렬을 한다.
    public static int[] getSortArray(int[] randomArray, int[] countArray) {
        int[] sortArray = new int[countArray.length];
        // int[] sortArray = countArray;
        // int[] sortArray = getCountArray(randomArray);

        int currentValue = 0; // 현재 countArray 의 값을 가져온다.
        int nextValue = 0; // 현재 countArray 의 값과 비교를 진행할 그 다음 값인 currentValue 를 가지고 와 값을 비교한다.

        int currentCount = 0; // 현재 countArray 의 빈도 수를 가져온다.
        int nextCount = 0; // 현재 countArray 의 빈도 수하고 비교를 진행할 그 다음 값인 nextCount 를 가지고 와 값을 비교한다.
        // int swapRandomValue = 0; // randomArray 내 서로 큰 빈도 수 및 큰 수에 따라 서로 위치가 교환된 값들을
        // // 저장한다.
        // int swapCountValue = 0; // countArray 내 서로 큰 빈도 수 및 큰 수에 따라 서로 위치가 교환된 값들을
        // // 저장한다.

        for (int i = 0; i < countArray.length; i++) {
            for (int j = i + 1; j < countArray.length; j++) {
                currentValue = countArray[i];
                nextValue = countArray[j];

                // 현재 값의 빈도 수를 확인한다.
                currentCount = checkArrayFrequency(randomArray, currentValue);

                // 다음 값의 빈도 수를 확인한다.
                nextCount = checkArrayFrequency(randomArray, nextValue);

                // 현재 빈도 수의 값이 다음 빈도 수의 값보다 작을 때,
                // 중복 제거가 되지 않은 배열 및 중복 제거가 된 배열 인덱스의
                // 위치를 서로 교환한다.
                if (currentCount < nextCount) {
                    // swapRandomValue = randomArray[i];
                    // randomArray[i] = randomArray[j];
                    // randomArray[j] = swapRandomValue;

                    // swapCountValue = countArray[i];
                    // countArray[i] = countArray[j];
                    // countArray[j] = swapCountValue;

                    // 중복된 배열인 randomArray 따로, 중복된 값을 제거한 countArray 따로,
                    // 각각의 배열에 값을 집어넣는다.
                    // swapRandomValue = swapArray(randomArray, i, j); // 값의 빈도 수에 따라 정렬
                    // out.print(swapRandomValue + " ");
                    // out.print(swapRandomValue + " ....test.....");
                    // swapCountValue = swapArray(countArray, i, j); // 빈도 수가 아닌 큰 수에 따라 정렬
                    // out.print(swapCountValue + " ");

                    // out.print(swapCountValue + "-----test-----");

                    swapArray(randomArray, i, j); // 값의 빈도 수에 따라 정렬
                    swapArray(countArray, i, j); // 빈도 수가 아닌 큰 수에 따라 정렬
                    // countArray 의 값을 sortArray 에 넣는다.
                    // 빈도 수, 그리고 값에 따라 내림차순으로 정렬한 countArray 배열의 값을 sortArray 에 하나씩 대입한다.
                    sortArray[i] = countArray[i];
                    // sortArray = countArray;
                    // sortArray[j] = swapRandomValue;
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    // 현재 빈도 수의 값과 다음 빈도 수의 값이 같고,
                    // 중복 제거가 되지 않은 배열의 값과 중복 제거된 배열의 값이 같을 때,
                    // 위치를 서로 교환한다.
                    // swapRandomValue = randomArray[i];
                    // randomArray[i] = randomArray[j];
                    // randomArray[j] = swapRandomValue;

                    // swapCountValue = countArray[i];
                    // countArray[i] = countArray[j];
                    // countArray[j] = swapCountValue;

                    // swapRandomValue = swapArray(randomArray, i, j); // 값의 빈도 수에 따라 정렬
                    // out.print(swapRandomValue + ",,,,test,,,,");
                    // swapCountValue = swapArray(countArray, i, j); // 빈도 수가 아닌 큰 수에 따라 정렬
                    // out.print(swapCountValue + "____test____");

                    swapArray(randomArray, i, j); // 값의 빈도 수에 따라 정렬
                    swapArray(countArray, i, j); // 빈도 수가 아닌 큰 수에 따라 정렬
                    // countArray 의 값을 sortArray 에 넣는다.
                    // 빈도 수, 그리고 값에 따라 내림차순으로 정렬한 countArray 배열의 값을 sortArray 에 하나씩 대입한다.
                    sortArray[i] = countArray[i];
                    // sortArray = countArray;
                    // sortArray[j] = swapRandomValue;
                }
            }
        }

        return sortArray;
    }

    // 5. 중복 값이 모두 제거가 된 후, 빈도 수에 따른 정렬, 그리고 큰 값부터 차례대로 오는 sortArray 와
    // 중복 값이 모두 포함된 randomArray 의 빈도 수를 확인하는 괄호 부분을 만들어
    // 정렬된 수와 빈도 수를 동시에 확인할 수 있도록 결과 변수인 getResult 에 저장한다.
    public static String printArray(int printValue, int[] sortArray, int[] randomArray, int[] countArray) {
        String getResult = "";

        for (int i = 0; i < printValue; i++) {
            getResult += "#" + (i + 1) + " " + sortArray[i] + " (" + checkArrayFrequency(randomArray, randomArray[i])
                    + ")" + "\n";
        }

        return getResult;
    }

    // 읽어온 파일의 데이터를 가지고 와 그 데이터의 최빈값과 빈도 수가 많은 수들, 그리고 빈도 수가 하나 밖에 없는 수들의
    // 데이터들을 출력 및 result 에 저장한다.
    public static String getData(int getDataValue) {
        int printT = 5; // 결과를 출력할 개수이다.
        String result = ""; // 전체 결과값을 저장한다.
        String loopResult = ""; // 저장한 배열 안에 있는 random 수들을 출력한다.

        // 1. 사용자가 정한 입력받을(또는 파일로부터 받을) 데이터의 개수만큼, 랜덤 수들을 temp 배열에 저장한다.
        int[] randomArray = getRandomArray(getDataValue);
        out.println(randomArray.length);

        // 2. 현재 temp 배열 안에 있는 random 수들을 출력한 후, 확인한다.
        loopResult = printRandomArray(randomArray);

        // 3. 중복 된 값들을 제거하여 겹치지 않는 수들을 countArray 배열에 저장한다.
        int[] countArray = getCountArray(randomArray);
        out.println(countArray);

        // 4. 중복 된 값들이 포함되어 있는 배열(randomArray)과 중복되지 않는 값들이 담겨진 배열(countArray)을 가지고 온다.
        // 숫자들의 빈도 수, 그리고 전체 배열을 먼저 빈도 수에 따라 정렬하며, 그 다음, 빈도 수가 아닌 값들을 정렬하여
        // 큰 수를 먼저 출력하고, 작은 수를 나중에 출력하는 내림차순 형태로 출력한다.
        int[] sortArray = getSortArray(randomArray, countArray);
        out.println(sortArray);

        // 5. 중복된 값들이 포함된 randomArray 의 빈도 수, 그리고 값들을 정렬한 결과를 출력한다.
        result = loopResult + "\n" + printArray(printT, sortArray, randomArray, countArray);
        out.println(result);

        return result;
    }

    // 최빈값과 빈도 수가 많은 수들, 그리고 빈도 수가 하나 밖에 없는 수들의 데이터들을
    // 저장할 파일과 그 새로 저장할 파일의 이름을 함께 가지고 와 파일을 저장한다.
    public static void getResult(String fileWriteName, FileManager fileManager, int getValue) {
        String getData = getData(getValue);
        writeFile(fileManager, fileWriteName, getData);
    }

    // T2.java 에서 거의 main 역할을 하는 함수이다.
    public static void t2_main(int userInput) {
        File file = null;
        Scanner readFile = null;
        FileWriter writeFile = null;

        String fileReadName = "input.txt";
        String fileWriteName = "output.txt";
        FileManager fileManager = new FileManager(file, readFile, writeFile);

        Scanner sc = new Scanner(System.in);
        out.println("메뉴를 선택해주세요.\n1. File 입출력\n2. 직접 입력하여 데이터 출력");

        int getUserInput = sc.nextInt();

        if (getUserInput == 1) {
            readFile = readFile(fileManager, fileReadName);
            int getValue = Integer.parseInt(readFile.nextLine());
            getResult(fileWriteName, fileManager, getValue);
        } else if (getUserInput == 2) {
            readFile = new Scanner(System.in);
            out.print("데이터 개수를 입력하세요 : ");
            int getValue = readFile.nextInt();
            getResult(fileWriteName, fileManager, getValue);
        }

        sc.close();
    }
}
