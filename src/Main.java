/**
 * Created by ml996 on 4/12/17.
 */
import java.util.*;
import java.io.*;

public class Main {
    public static double getPoints(String s){
        Scanner sc = new Scanner(s);
        double d = 0;
        while(sc.hasNext()){
            if(sc.hasNextDouble()){
                d += sc.nextDouble();
            }
            else{
                sc.next();
            }
        }
        return d;
    }
    public static void main(String[] args) throws IOException{
        double[][] data  = new double[28][4]; //secret number, total avg, fr1, fr2
        Scanner sc = new Scanner(new File("rawDataU6.txt"));
        /*
        secret number,
        */

        sc.nextLine();
        for(int i = 0; i < 1; i++) {
            data[i][0] = sc.nextDouble();
            sc.useDelimiter("\t");
            String fr1A = sc.next();
            String fr1B = sc.next();
            String fr1Syntax = sc.next();
            String fr1Comments = sc.next();
            String fr2A = sc.next();
            String fr2B = sc.next();
            String fr2C = sc.next();
            String fr2Syntax = sc.next();
            String fr2Comments = sc.next();

            //FR1
            data[i][2] += getPoints(fr1A) + getPoints(fr1B);
            data[i][2] -= Double.parseDouble(fr1Syntax) * 0.25;
            //FR2
            data[i][3] += getPoints(fr2B) + getPoints(fr2B);
            data[i][3] -= Double.parseDouble(fr2Syntax) * 0.25;
            //Total
            data[i][1] = (data[i][2] + data[i][3])/2;
        }
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0] + "\t"
                                + String.valueOf(data[i][1]) + "/19" + "\t"
                                + data[i][2] + "\t"
                                + data[i][3]);
        }
    }
}
