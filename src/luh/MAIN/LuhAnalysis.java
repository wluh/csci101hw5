package luh.MAIN;

import luh.ANALYSIS.StatAnalysis;
import luh.ANALYSIS.SymbolAnalysis;
import luh.FILECREATION.DataGenerator;
import java.io.IOException;

public class LuhAnalysis {

    public static void main(String[] args){
        try {
            DataGenerator.buildIntegerFile(DataGenerator.DIR + "IFILE", 100);
            DataGenerator.buildDecimalFile(DataGenerator.DIR + "DFILE", 100);
            DataGenerator.buildCharacterFile(DataGenerator.DIR + "CFILE", 100);
            DataGenerator.buildAlphaNumericFile(DataGenerator.DIR + "AFILE", 100);
        } catch (IOException e) {
            System.out.println("Ooops");
            e.printStackTrace();
        }
    }

}
