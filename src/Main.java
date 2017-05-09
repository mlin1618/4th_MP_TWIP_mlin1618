/**
 * Created by ml996 on 4/12/17.
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void SOP(Object s){
        System.out.println(s);
    }
    public static double getPoints(String s){
        Scanner sc = new Scanner(s);
        double d = 0;
        for(int i = 0; i < s.length()-4; i++){
            if(s.substring(i, i+1).equals("+")){
                if(s.substring(i+2, i+3).equals(".") || s.substring(i+2, i+3).matches("\\d+")) {
                    d += Double.parseDouble(s.substring(i + 2, i + 4).trim());
                }
            }
        }

        /*while(sc.hasNext()){
            if(sc.hasNextDouble()){
                d += sc.nextDouble();
            }
            else{
                sc.next();
            }
        }*/
        return d;
    }
    public static void main(String[] args) throws IOException{
        double[][] data = new double[28][8]; // 0secret number, 1total avg, 2total1, 3fr1, 4fr2, 5total2, 6fr1, 7fr2
        for(int i = 0; i< data.length; i++){
            data[i][0] = i;
        }
        int t = 0;
        Scanner sc2 = new Scanner(new File("rawDataU6.txt"));
        sc2.nextLine();
        while(sc2.hasNext()){
            if(sc2.hasNextInt()){
                int x = sc2.nextInt()-1;
                sc2.useDelimiter("\t");
                int c = 0;
                if(t % 2 != 0){
                    c = 3;
                }
                String fr1A = sc2.next();
                String fr1B = sc2.next();
                String fr1Syntax = sc2.next().trim();
                sc2.next();
                String fr2A = sc2.next();
                String fr2B = sc2.next();
                String fr2C = sc2.next();
                sc2.useDelimiter("\t|\r");
                String fr2Syntax = sc2.next().trim();
                sc2.useDelimiter("\t");
                sc2.nextLine();

                //FR1
                data[x][3+c] += getPoints(fr1A) + getPoints(fr1B);
                if(!fr1Syntax.isEmpty())
                    data[x][3+c] -= Double.parseDouble(fr1Syntax) * 0.25;
                //FR2
                data[x][4+c] += getPoints(fr2A) + getPoints(fr2B) + getPoints(fr2C);
                if(!fr2Syntax.isEmpty())
                    data[x][4+c] -= Double.parseDouble(fr2Syntax) * 0.25;
                //Total
                data[x][2+c] = data[x][3+c] + data[x][4+c];
            }
            else{
                sc2.nextLine();
            }
            t++;
        }
        for(int i = 0; i < data.length; i++){
            data[i][1] = (data[i][2] + data[i][5])/2;
        }
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0]+1 + "\t"
                    + String.valueOf(data[i][1]) + "/19" + "\t"
                    + data[i][2] + "\t"
                    + data[i][5]);
        }

        //System.out.println("\n \n \n");



        /*Scanner sc = new Scanner(new File("rawDataU6.txt"));
        sc.useDelimiter("\t");
        sc.nextLine();
        for(int j = 0; j < 56; j++){

            int i = (j/2);
            int c = 0;
            if(j % 2 != 0){
                c = 3;
            }

            data[i][0] = i;
            sc.next();
            String fr1A = sc.next();
            String fr1B = sc.next();
            String fr1Syntax = sc.next().trim();
            sc.next();
            String fr2A = sc.next();
            String fr2B = sc.next();
            String fr2C = sc.next();
            sc.useDelimiter("\t|\r");
            String fr2Syntax = sc.next().trim();
            sc.useDelimiter("\t");
            sc.nextLine();


            data[i][3+c] += getPoints(fr1A) + getPoints(fr1B);
            if(!fr1Syntax.isEmpty())
                data[i][3+c] -= Double.parseDouble(fr1Syntax) * 0.25;

            data[i][4+c] += getPoints(fr2A) + getPoints(fr2B) + getPoints(fr2C);
            if(!fr2Syntax.isEmpty())
                data[i][4+c] -= Double.parseDouble(fr2Syntax) * 0.25;

            data[i][2+c] = data[i][3+c] + data[i][4+c];
        }
        for(int i = 0; i < data.length; i++){
            data[i][1] = (data[i][2] + data[i][5])/2;
        }
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0]+1 + "\t"
                    + String.valueOf(data[i][1]) + "/19" + "\t"
                    + data[i][2] + "\t"
                    + data[i][5]);
        }
    }
    */

    /*public static void main(String[] args) throws IOException{
        double[][] data  = new double[14][8]; //secret number, total avg, total 1, fr1, fr2, total 2, fr 1, fr 2
        Scanner sc = new Scanner(new File("rawDataU6.txt"));

        secret number,

        //just delete #12
        sc.nextLine();
        for(double j = 0; j < 6; j++) {
            int i = (int)j;
            int c = 0;
            if(j % 2 == 1){
                c = 3;
            }
            data[i][0] = sc.nextDouble();
            sc.useDelimiter("\t");
            String fr1A = sc.next();
            String fr1B = sc.next();
            String fr1Syntax = sc.next();
            sc.next();
            String fr2A = sc.next();
            String fr2B = sc.next();
            String fr2C = sc.next();
            String fr2Syntax = sc.next();
            sc.nextLine();
            //FR1
            data[i][2+c] += getPoints(fr1A) + getPoints(fr1B);
            if(!fr1Syntax.isEmpty())
                data[i][2+c] -= Double.parseDouble(fr1Syntax) * 0.25;
            //FR2
            data[i][3+c] += getPoints(fr2A) + getPoints(fr2B);
            if(!fr2Syntax.isEmpty())
                data[i][3+c] -= Double.parseDouble(fr2Syntax) * 0.25;
            //Total
            data[i][2+c] = data[i][3+c] + data[i][4+c];

        }
        for(int i = 0; i < data.length; i++){
            data[i][1] = (data[i][2] + data[i][5])/2;
        }
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0] + "\t"
                                + String.valueOf(data[i][1]) + "/19" + "\t"
                                + data[i][2] + "\t"
                                + data[i][5]);
        }
    }*/

}
