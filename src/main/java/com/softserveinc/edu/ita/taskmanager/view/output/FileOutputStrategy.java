package com.softserveinc.edu.ita.taskmanager.view.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy implements ViewStrategy {

    private static final String DEFAULT_OUTPUT = "../TaskManager/outputs/data_output.txt";
    private File file;


    public FileOutputStrategy() {
        // default constructor
    }

    public FileOutputStrategy(String fileName) throws IOException {

        file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }


    }

    @Override
    public void show(Object objectToShow) {
        saveToFile(objectToShow);

    }

    private void saveToFile(Object objectToShow) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(
                             file == null ?
                                     new File(DEFAULT_OUTPUT)
                                     : file))) {

            writer.write(objectToShow.toString());

            System.out.println("saved to file: \n");
            System.out.println(file == null ? DEFAULT_OUTPUT : file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
