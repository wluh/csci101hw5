package luh.ANALYSIS;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class SymbolAnalysis {

    static final String DIR = "C:\\Users\\wluh1\\IdeaProjects\\csci101hw5\\src\\luh\\MAIN\\";

    public static int characterCount(String fp) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<String> charList = new LinkedList<>();
        try {
            while (input.available() > 0){
                String newChar = input.readUTF();
                if (!newChar.equals("\n")){
                    charList.add(newChar);
                }
            }
        } catch (EOFException e){
            e.printStackTrace();
        }

        return charList.size();
    };

    public static int countSpecifiedCharacter(String fp, char c) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<String> charList = new LinkedList<>();
        try {
            while (input.available() > 0){
                String newChar = input.readUTF();
                if (newChar.equals("c")){
                    charList.add(newChar);
                }
            }
        } catch (EOFException e){
            e.printStackTrace();
        }

        return charList.size();
    };

    public static int wordCount(String fp) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<String> stringList = new LinkedList<>();
        try {
            while (input.available() > 0){
                String newString = input.readUTF();
                if (!newString.equals("\n")){
                    stringList.add(newString);
                }
            }
        } catch (EOFException e){
            e.printStackTrace();
        }

        return stringList.size();
    };

    public static int countSpecifiedWord(String fp, String wrd) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fp));
        Queue<String> stringList = new LinkedList<>();
        try {
            while (input.available() > 0){
                String newString = input.readUTF();
                if (newString.equals("c")){
                    stringList.add(newString);
                }
            }
        } catch (EOFException e){
            e.printStackTrace();
        }

        return stringList.size();
    };

}
