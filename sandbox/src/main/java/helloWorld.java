public class helloWorld {
    public static void main(String[] args) {

       // System.out.println("hello, World!");

        //System.out.println(2 + 2);
        //System.out.println(2 * 3);
        //System.out.println(2 - 1);
        //System.out.println(2 / 3);

        //System.out.println("hello, " + "QA-" + "engineer");
        //System.out.println("2 + 3 = " + 5);
        //System.out.println("2 + 2 = " + 2 + 2);
        //System.out.println("2 + 2 = " + (2 + 2));

        //var configFile = new File("sandbox/build.gradle");
        //System.out.println(configFile.exists());
        //System.out.println(configFile.getAbsolutePath());

            var x = 1;
            var y = 1;
            if (y == 0) {
                System.out.println("Division by zero is not allowed");
            } else {
                var z = divide(x, y);
                System.out.println("Hello");
            }
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}
