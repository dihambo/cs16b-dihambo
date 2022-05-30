public class App {
    public static void main(String[] args) throws Exception {
        Lab lab = new Lab();
        HomeWork hw = new HomeWork();
        // lab.helloWorld();
        // lab.loopTest();
        // lab.loopTestWhioutSpace();
        // lab.loopTestSum();
        lab.sumCommandlineArgs(args);

        // hw.drawTriangle();
        // hw.drawTriangle(10);
        // hw.maxTest();
        // hw.testWindowPosSum();

    }
}

class Lab {
    public void sumCommandlineArgs(String[] args){
        int sum = 0;
        for(String arg:args){
            sum+=Integer.parseInt(arg);
        }
        System.out.println("The sum is: "+sum);
    }
    public void helloWorld() {
        System.out.println("Hello, world!");
    }

    public void loopTest() {
        int x = 0;
        while (x < 10) {
            System.out.print(x + " ");
            x++;
        }
    }

    public void loopTestWhioutSpace() {
        int x = 0;
        while (x < 10) {
            System.out.print(x);
            x++;
        }
    }

    public void loopTestSum() {
        int x = 0;
        int sum = 0;
        while (x < 10) {
            sum += x;
            System.out.print(sum + " ");
            x++;
        }
    }
}

class HomeWork {
    public void drawTriangle() {
        for (int i = 0; i <= 5; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public void drawTriangle(int N) {
        for (int i = 0; i <= N; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public int max(int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public void maxTest() {
        int[] numbers = new int[] { 9, 2, 15, 2, 22, 10, 6 };
        System.out.println(max(numbers));
    }

    public void windowPosSum(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                continue;
            }
            for (int j = 1; j <= n && i + j < array.length; j++) {
                array[i] += array[i + j];
            }
        }
    }

    public void testWindowPosSum(){
        int[] array = new int[]{1, 2, -3, 4, 5, 4};
        int[] array2 = new int[]{1, -1, -1, 10, 5, -1};
        windowPosSum(array,3);
        windowPosSum(array2,2);
        System.out.println(java.util.Arrays.toString(array));
        System.out.println(java.util.Arrays.toString(array2));
    }
}
