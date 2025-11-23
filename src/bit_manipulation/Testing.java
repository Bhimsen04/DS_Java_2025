package bit_manipulation;


public class Testing {
    public static void main(String[] args) {
        int num = 17;
        int times = 4;
//        isEven(num);
//        multiplyByTwo_byLeftShift(num, times);
//        divideByTwo_byRightShift(num, times);// it basically adds 0 at the last
//        digitOfGivenNumberIsSet_byRightShift(num, 5);
//        digitOfGivenNumberIsSet_byLeftShift(num, 5);
        countSetBits(num);
        xSetBitsFollowedByYZeroes(3, 4); // 1110000

    }

    private static void xSetBitsFollowedByYZeroes(int x, int y) {
        System.out.println(((1 << x) - 1) << y);
    }

    private static void countSetBits(int num) {

        int count = 0;
        while (num > 0) {
            if ((num & 1) != 0) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println(count);
    }

    private static void digitOfGivenNumberIsSet_byLeftShift(int decimalNum, int digit) {

        int i = 1 << (digit - 1);
        boolean result = (decimalNum & i) == 0;
        System.out.println(result);
        System.out.println((decimalNum & (1 << (digit - 1))) == 0);
        System.out.println("/////////////////////");

    }

    private static void digitOfGivenNumberIsSet_byRightShift(int decimalNum, int digit) {
        decimalNum = decimalNum >> (digit - 1);
        boolean result = (decimalNum & 1) == 0;
        System.out.println(result);
        System.out.println("/////////////////////");

    }

    private static void divideByTwo_byRightShift(int num, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(num >> i);
        }
        System.out.println("/////////////////////");
    }

    private static void multiplyByTwo_byLeftShift(int num, int times) {

        for (int i = 0; i < times; i++) {
            System.out.println(num << i);
        }
        System.out.println("/////////  2^5 ////////////");
        System.out.println(1 << 5);
        System.out.println("////////////////////////");
    }

    private static void isEven(int num) {
        System.out.println((num & 1) == 0);
        System.out.println("////////////////////////");
    }
}
