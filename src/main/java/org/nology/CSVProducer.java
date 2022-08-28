package org.nology;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVProducer {

    public static void writeCSVFile(String filePath){
        File file = new File("D:\\Nology\\Projects\\Back-end-library");
        try{
            FileWriter outPutFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outPutFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
