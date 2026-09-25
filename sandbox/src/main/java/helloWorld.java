import java.io.File;

public class helloWorld {
    public static void main(String[] args) {
        System.out.println("hello, World!");

        System.out.println(2 + 2);
        System.out.println(2 * 3);
        System.out.println(2 - 1);
        System.out.println(2 / 3);

        System.out.println("hello, " + "QA-" + "engineer");
        System.out.println("2 + 3 = " + 5);
        System.out.println("2 + 2 = " + 2 + 2);
        System.out.println("2 + 2 = " + (2 + 2));

        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.exists());
        System.out.println(configFile.getAbsolutePath());
    }
}
