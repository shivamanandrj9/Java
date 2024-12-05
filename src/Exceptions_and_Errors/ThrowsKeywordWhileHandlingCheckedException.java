package Exceptions_and_Errors;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeywordWhileHandlingCheckedException {
    public static void main(String[] args) throws IOException {
        System.out.println(5/1);
        method1();
    }

    public static void method1() throws IOException {
        method2();
    }

    public static void method2() throws IOException {
        FileReader file = new FileReader("C:\\test\\a.txt");
    }
}
