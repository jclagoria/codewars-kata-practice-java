package ar.com.problems.string;

public class Others {

    public static void main(String[] args) {
        String str = "hola";
        String newwStr = String.format("%-15s", str);

        System.out.println(newwStr.length());

        int number = 9;
        String stNUmber = String.format("%1$3s", number).replace(' ', '0');
        System.out.println(String.format("%-15s", str) + String.format("%1$3s", number).replace(' ', '0'));
    }

}
