import java.io.*;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
        double a = 22.65;
        double b = 14.00;
        double c = ((a - b) * 100);
        System.out.println(c);
        double d = (Math.round(c));
        double e = d / 100;
        System.out.println(e);
        System.out.println(22.65-14.00);

        System.out.println(roundNum(22.65-14.00));
    }


        public static double roundNum(double a){
        double number = Math.round(a*100);
        return number/100 ;
    }
}
