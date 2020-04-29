package luh.FILECREATION;

import luh.MAIN.Analytically;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DataGenerator implements Analytically {

    public static final String DIR = "C:\\Users\\wluh1\\IdeaProjects\\csci101hw5\\src\\luh\\MAIN\\";

    public static void buildIntegerFile(String fp, int count) throws IOException {
        int[] numArray = new int[count];

        for (int i = 0; i < count; i += 1){
            Random r = new Random();
            numArray[i] = (r.nextInt(101));
        }

        DataOutputStream output = new DataOutputStream(new FileOutputStream(fp));
        try {
            int lineCounter = 0;
            for (int i : numArray){

                output.writeInt(i);
                lineCounter += 1;

                if (lineCounter % 10 == 0){
                    output.writeUTF("\n");
                }
            }
        } catch (IOException e){
          e.printStackTrace();
        }
        output.close();

    };

    public static void buildDecimalFile(String fp, int count) throws IOException{
        double[] decList = new double[count];

        for (int i = 0; i < count; i += 1){
            Random r = new Random();
            decList[i] = (r.nextInt(10001) / 100.0);
        }

        DataOutputStream output = new DataOutputStream(new FileOutputStream(fp));
        try {
            int lineCounter = 0;
            for (double i : decList){

                output.writeDouble(i);
                lineCounter += 1;

                if (lineCounter % 10 == 0){
                    output.writeUTF("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        output.close();
    };

    public static void buildCharacterFile(String fp, int count) throws IOException{
        char[] charList = new char[count];

        for (int i = 0; i < count; i += 1){
            Random r = new Random();
            charList[i] = (Analytically.ALPHABET[r.nextInt(52)]);
        }

        DataOutputStream output = new DataOutputStream(new FileOutputStream(fp));
        try {
            int lineCounter = 0;
            for (int c : charList){

                output.writeUTF(String.valueOf(c));
                lineCounter += 1;

                if (lineCounter % 10 == 0){
                    output.writeUTF("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        output.close();
    };

    public static void buildAlphaNumericFile(String fp, int count) throws IOException{
        String[] alphaList = new String[count];

        for (int i = 0; i < count; i += 1){
            Random rc = new Random();
            Random rn = new Random();
            String alphanum = "";
            alphanum += (Analytically.ALPHABET[rc.nextInt(52)]);
            alphanum += rn.nextInt(10);
            alphaList[i] = alphanum;
        }

        DataOutputStream output = new DataOutputStream(new FileOutputStream(fp));
        try {
            int lineCounter = 0;
            for (String s : alphaList){

                output.writeUTF(s);
                lineCounter += 1;

                if (lineCounter % 10 == 0){
                    output.writeUTF("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        output.close();
    };

}
