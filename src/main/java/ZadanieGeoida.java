import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class ZadanieGeoida {
    public ZadanieGeoida() throws IOException {
    }
//    final double gridStep = findStep();
//    final double rangeXMax = (readRow(3));
//    final double rangeXMin = (readRow(1));
//    final double rangeYMax = (readRow(4));
//    final double rangeYMin = (readRow(2));
    final int colNumber= (int) readRow(5);
    final int rowNumber= (int) readRow(6);
    // Odczytywanie wskzanego wiersza z pliku geoidy
    public static double readRow(int n) throws IOException {
        File file = new File("EVRF 2007.gsf");
        LineNumberReader ln = new LineNumberReader(new FileReader(file));
        String row = null;
        boolean isNumeric = true;
        for (int i = 0; i <= n-1; i++) {
            row = ln.readLine();
        }
        isNumeric(row);
        double rowValue = Double.parseDouble(row);
        ln.close();
        return rowValue;
    }
    //Wprowadzanie szerokości geograficznej szukanego punktu
    public static double insertPointX() throws IOException {
        double rangeXMax = (readRow(3));
        double rangeXMin = (readRow(1));
        Scanner pointX = new Scanner(System.in);
        System.out.println("Wprowadź szerokość geograficzną");
        double X = pointX.nextDouble();
        if (X>=rangeXMin && X<=rangeXMax) {
            return X;
        } else {
            System.out.println("Podana wartość szerokości geograficznej jest poza zakresem, wprowadź poprawną wartość:");
            return insertPointX();
        }
    }
    // Wprowadzanie długości geograficznej szukanego punktu
    public static double insertPointY() throws IOException {
        double rangeYMax = (readRow(4));
        double rangeYMin = (readRow(2));
        Scanner pointY = new Scanner(System.in);
        System.out.println("Wprowadź długość geograficzną");
        double Y = pointY.nextDouble();
        if (Y>=rangeYMin && Y<=rangeYMax) {
            return Y;
        } else {
            System.out.println("Podana wartość długości geograficznej jest poza zakresem, wprowadź poprawną wartość:");
            return insertPointY();
        }
    }
    //dczytywanie skoku siatki grid
    public static double findStep() throws IOException {
        double step = ((readRow(3)-readRow(1))/(readRow(6)));
        return step;
    }
    // wartość wspolrzednych wezlów po uwzglednieniu osi X

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            System.out.println("we skzazanym pkt wartośc geoidy wynosi N");
            return false;
        }
    }
    public static double roundNum(double a){
        double number = Math.round(a);
        return (number/100) ;
    }

    public static double searchXNode1(double pointX) throws IOException {
        Double rangeXMin = (readRow(1));
        double gridStep = findStep();
        double nodeX = roundNum(((pointX-rangeXMin)/gridStep)-((pointX-rangeXMin)%gridStep)/100);
//        double nodeX = ((pointX-rangeXMin)/gridStep)/100;
//        double nodeX=pointX-rangeXMin;
        return nodeX;
    }
    public static double searchYNode1(double pointY) throws IOException {
        int rangeYMin = (int) readRow(2);
        //double rangeYMin = 14.00;

        double gridStep = findStep();
        double nodeY = roundNum(((pointY-rangeYMin)/gridStep)-((pointY-rangeYMin)%gridStep)/100);
//        Double nodeY=pointY-rangeYMin;
        return nodeY;
    }
    public static double searchValueNode1(double nodeX, double nodeY) throws IOException {
        double gridStep = findStep();
        int gridStartInFile = 7;
        int colNumber= (int) readRow(5)+1;
        double nodeNumber = 0;
        if (nodeX == 0){
            nodeNumber = roundNum((((nodeY/gridStep)))+gridStartInFile)*100;
            System.out.println("a");
        }
        else{
            nodeNumber = roundNum((((nodeX/gridStep)*colNumber)+((nodeY/gridStep)))+gridStartInFile)*100;
            System.out.println("b");
        }
        int nodeNumberParse = (int) nodeNumber;
        System.out.println(nodeNumberParse);
        double vauleNode=readRow(nodeNumberParse);
        System.out.println(vauleNode);
        return vauleNode;

    }
    public static void main(String[] args) throws IOException {
//        System.out.println(searchValueNode1(searchXNode1(49.00),searchYNode1((22.65))));
//        System.out.println(37.2196);
//        System.out.println(searchValueNode1(searchXNode1(49.00),searchYNode1((22.89))));
//        System.out.println(36.7878);
//        System.out.println(searchValueNode1(searchXNode1(49.36213),searchYNode1((22.053213))));
//        System.out.println(36.8674);
//        System.out.println(searchValueNode1(searchXNode1(52.503213),searchYNode1((22.293213))));
//        System.out.println(28.5956);
//        System.out.println(searchValueNode1(searchXNode1(53.0812),searchYNode1((15.30789))));
//        System.out.println(34.9783);
//        System.out.println(searchValueNode1(searchXNode1(53.77),searchYNode1((18.23))));
//        System.out.println(29.4011);
//        System.out.println(searchValueNode1(searchXNode1(54.05),searchYNode1((20.01))));
//        System.out.println(29.0006);

    }

}

