package feature.Files.Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import feature.Files.Files;

public class FileManager implements Files {
    public File file;
    public FileWriter fileWriter;
    public Scanner fileReader;
    public String fileName;

    public FileManager(File file, FileWriter fileWriter, Scanner fileReader, String fileName) {
        this.setFile(file);
        this.setFileWriter(fileWriter);
        this.setFileReader(fileReader);
        this.setFileName(fileName);
    }

    public FileManager(File file2, Scanner fileReader2, FileWriter fileWriter2) {
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Scanner getFileReader() {
        return fileReader;
    }

    public void setFileReader(Scanner fileReader) {
        this.fileReader = fileReader;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Scanner readFile(String fileName) {
        fileReader = null;
        file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    @Override
    public void writeFile(String fileName, String result) {
        fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(result);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
