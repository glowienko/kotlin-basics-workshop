package org.sytac.workshop;

import java.util.Arrays;
import java.util.List;

public class JavaVararg {

    public static void printAll(String... args) {
        String string = "";

        Arrays.stream(args).forEach(arg -> System.out.print(arg + "  "));
    }

    public static void examplePrintAllVararg() {
        //        printAll("Java", "Vararg", "Print");
        List<String> list = List.of("Java", "Vararg", "Print");
        System.out.println("list elements print:");
        printAll(list.toArray(new String[0])); //we must convert manually
    }

}
