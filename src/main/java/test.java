import system.Admin;
import system.Student;
import system.Teacher;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("1");
        arr1.add("2");
        arr1.add("3");

        ArrayList<String> arr2 = new ArrayList<>(arr1);

        arr2.set(1, "10");

        for (String e : arr1) {
            System.out.println(e);
        }

        System.out.println("*************************\n");

        for (String e : arr2) {
            System.out.println(e);
        }
    }
}
