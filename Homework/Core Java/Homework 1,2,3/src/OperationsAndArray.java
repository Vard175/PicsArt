public class OperationsAndArray {
    public static void main(String[] args) {
        int a=4;
        int b=5;

        System.out.println(a++ + ++a); // 4+6 , a=6
        System.out.println(++a + b++ + b-- + a++); // 7+5+6+7 , a=8 ,b=5
        System.out.println(a + " + " + b + " = " + (a+b)); // 13
        System.out.println(a + " - " + b + " = " + (a-b)); // 3
        System.out.println(a + " * " + b + " = " + (a*b)); // 40
        System.out.println(a + " / " + b + " = " + (a/b)); // 1
        System.out.println(a + " % " + b + " = " + (a%b)); // 3

        System.out.println(b%2!=1 ? "b is even" : "b is odd");

        if(a%2==0){
            System.out.println("a is even");
        }

        if(a==4 && b==4){
            System.out.println("both a and b are 4");
        }
        else if(a==4 || b==4){
            System.out.println("either a or b is 4");
        }else{
            System.out.println("neither a nor b is 4");
        }

        int[] arr={a,b};
        System.out.println("first element of the array before change is " + arr[0]); // 8
        arr[0]=25;
        System.out.println("first element of the array after change is " + arr[0]); //25
        System.out.println("last element of the array is " + arr[arr.length-1]); // 5
        System.out.println("length of the array is " + arr.length); // 2

        int[][] n=new int[3][2];
        System.out.println(n.length);
        System.out.println(n[0].length);

        int[][] m = {{11,12,13},{24,25},{33,36,37,38,39}};
        System.out.println(m[0][1]); // 12
        System.out.println(m[m.length-1][m[m.length-1].length-1]); // 39

        byte c=10; // 1010
        byte d=8; // 1000

        System.out.println(c&d); // 1000 => 8
        System.out.println(c|d); // 1010 => 10
        System.out.println(c^d); // 0010 => 2
        System.out.println(~d); // 0111 => 7 (output: -9)
        // 0000 1000 positive
        // 1111 0111 invert
        // -128 + 64 + 32 + 16 + 4 + 2 + 1 = -9
        // or simply -16 + 4 + 2 + 1
        //
        // from 9 to -9
        //  0.000 1001
        //  1.111 0110
        // +         1
        //  1.111 0111 = -9
        //
        // two's complement of 8 is -9
        System.out.println(d); //8
        System.out.println(c<<2); // 101000 => 40
        System.out.println(c>>3); // 1 => 1
        System.out.println(c); // 10
    }
}

