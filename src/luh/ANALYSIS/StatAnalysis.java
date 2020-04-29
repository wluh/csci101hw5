package luh.ANALYSIS;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StatAnalysis {

    static final String DIR = "C:\\Users\\wluh1\\IdeaProjects\\csci101hw5\\src\\luh\\MAIN\\";

    private static Queue<Double> getDoubleList(DataInputStream input) throws IOException {
        Queue<Double> doubleList = new LinkedList<>();
        int newNum;
        double newDub;
        try {
            try{
                while (input.available() > 0){

                    newNum = input.readInt();
                    doubleList.add((double)newNum);

                    if (doubleList.size() % 10 == 0){
                        input.readUTF();
                    }

                }
            }catch (EOFException e){
                while (input.available() > 0){
                    newDub = input.readDouble();
                    doubleList.add(newDub);

                    if (doubleList.size() % 10 == 0){
                        input.readUTF();
                    }
                }
//                e.printStackTrace();
            }
        } catch (EOFException e){
            e.printStackTrace();
        }
        return doubleList;
    }

    public static int countValues(String fp) throws IOException {

        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<Double> doubleList = getDoubleList(input);
        return doubleList.size();
    }

    public static double sumValues(String fp) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<Double> doubleList = getDoubleList(input);
        double listSum = 0.0;
        while (! doubleList.isEmpty()){
            listSum += doubleList.remove();
        }
        return listSum;
    }

    public static double muValue(String fp) throws IOException {
        return sumValues(fp) / countValues(fp);
    }

    public static double sigma2(String fp) throws IOException {

        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        LinkedList<Double> doubleList = (LinkedList<Double>) getDoubleList(input);
        double listSum = 0.0;
        for (int i = 0; i < doubleList.size(); i++) {
            doubleList.set(i, i - muValue(fp));
        }
        while (! doubleList.isEmpty()) {
            listSum += doubleList.remove(0);
        }
        return (listSum/(countValues(fp) - 1));
    }

    public static double sigma(String fp) throws IOException {
        return Math.sqrt(sigma2(fp));
    };

    public static double maxValue(String fp) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        LinkedList<Double> doubleList = (LinkedList<Double>) getDoubleList(input);
            double maxVal = doubleList.get(0);
            while (! doubleList.isEmpty()){
                if (maxVal < doubleList.get(0)){
                    maxVal = doubleList.get(0);
                }
                doubleList.remove(0);
            }
            return maxVal;
    }

    public static double minValue(String fp) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        LinkedList<Double> doubleList = (LinkedList<Double>) getDoubleList(input);
            double minVal = doubleList.get(0);
            while (! doubleList.isEmpty()){
                if (minVal > doubleList.get(0)){
                    minVal = doubleList.get(0);
                }
                doubleList.remove(0);
            }
            return minVal;
    }

    public static double rangeValues(String fp) throws IOException {
        return maxValue(fp) - minValue(fp);
    }

}
