public class ArrayTasks {
    public static void main(String[] args) {

        System.out.println("1. Create an array and fill it with 2 number.\n Done. \n");
        int[] arr1 = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        System.out.println("2. Create an array and fill it with numbers from 1:1000. \n Done. \n");
        int[] arr2 = new int[1000];

        for (int i = 0; i < 1000; i++)
            arr2[i] = i + 1;

        System.out.println("3. Create an array and fill it with odd numbers from -20:20 \n Done. \n");
        int[] arr3 = new int[20];

        for (int i = 0, odd = -19; i < arr3.length; i++, odd += 2) {
            arr3[i] = odd;
        }

        System.out.println("4. Create an array and fill it. Print all elements which can be divided by 5.");
        int[] arr4 = {4, 15, 25, 12, 89, 5};

        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] % 5 == 0)
                System.out.print(arr4[i] + " ");
        }

        System.out.println();
        System.out.println("\n 5. Create an array and fill it. Print all elements which are between 24.12 and 467.23. ");
        float[] arr5 = {24.5f, 25.45f, 458f, 895.4545f, 255.256f};

        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] >= 24.12 && arr5[i] <= 467.23)
                System.out.print(arr5[i] + " ");
        }

        System.out.println();
        System.out.println("\n6. Create an array and fill it. Print count of elements which can be divided by 2. ");
        int[] arr6 = {45, 12, 12, 15, 45, 48, 78, 79, 36};
        int countOfEvens = 0;

        for (int i = 0; i < arr6.length; i++) {
            if (arr6[i] % 2 == 0)
                countOfEvens++;
        }
        System.out.println(countOfEvens);

        System.out.println();
        System.out.println(" 7. Given an integer, 0< N < 21 , print its first 10 multiples.Each multiple  N x i (where 0<i<11) should be printed on a new line in the form: N x i = result.");
        int N = 5;

        for (int i = 1; i < 11; i++) {
            System.out.printf("%d * %d = %d \n", N, i, N * i);
        }

        System.out.println();
        System.out.println("Task: Find number with no pair using XOR");
        int[] arr = {5, 8, 7, 7, 6, 5, 8, 9, 9, 9, 9};
        int singleNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            singleNum ^= arr[i];
        }
        System.out.println(singleNum);
    }
}
