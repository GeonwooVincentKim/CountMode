package feature.Value;

import static java.lang.System.out;

public class RandomNumber {
    private int n1;
    private int n2;
    private int[] getRandomNumber;
    private String loopResult;

    public RandomNumber() {

    }

    public RandomNumber(int n1, int n2, int[] getRandomNumber, String loopResult) {
        this.setN1(n1);
        this.setN2(n2);
        this.setGetRandomNumber(getRandomNumber);
        this.setLoopResult(loopResult);
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getLoopResult() {
        return loopResult;
    }

    public void setLoopResult(String loopResult) {
        this.loopResult = loopResult;
    }

    public int[] getGetRandomNumber() {
        return getRandomNumber;
    }

    public void setGetRandomNumber(int[] getRandomNumber) {
        this.getRandomNumber = getRandomNumber;
    }

    public int extractRandomNumber(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1)) + n1;
    }

    public int[] getRandomNumber(int[] getRandomArray) {
        for (int i = 0; i < getRandomArray.length; i++) {
            getRandomArray[i] = extractRandomNumber(11, 99);
            out.print(getRandomArray[i] + " ");
        }

        return getRandomArray;
    }

    public String printRandomNumber(int[] getRandomArray) {
        String printNumber = "";

        for (int i = 0; i < getRandomArray.length; i++) {
            printNumber += getRandomArray[i] + " ";
        }

        return printNumber;
    }
}
