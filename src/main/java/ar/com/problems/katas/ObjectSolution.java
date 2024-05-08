package ar.com.problems.katas;

import java.lang.reflect.Method;

public class ObjectSolution {

    public static void main(String[] args) throws Exception {
        int num = 8;

        // Create an instance of Inner class
        Inner inner = new Inner();

        // Get the Class object for Inner.Private class
        Class<?> innerPrivateClass = Inner.Private.class;

        // Create an instance of Inner.Private class using reflection
        Object innerPrivateObj = innerPrivateClass.getDeclaredConstructors()[0].newInstance(inner);

        // Get the powerof2 method from Inner.Private class
        Method powerOf2Method = innerPrivateClass.getDeclaredMethod("powerof2", int.class);

        // Set the accessibility of the method to true
        powerOf2Method.setAccessible(true);

        // Invoke the powerof2 method on the instance of Inner.Private class
        String result = (String) powerOf2Method.invoke(innerPrivateObj, num);

        System.out.println(result);

        // Print the name of the created class
        System.out.println("An instance of class: " + innerPrivateClass.getName() + " has been created");
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? num + " is power of 2" : num + " is not power of 2";
            }
        }
    }

}
