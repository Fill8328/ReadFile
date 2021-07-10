package fill.jma.FileUtile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtil {
    private FileReaderUtil(){

    }
    public static List<String> readFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read lines from file: " + file, e);
        }
    }

    public static int readIntFromFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read lines from file: " + file, e);
        }catch (NumberFormatException e1) {
            throw new RuntimeException("Failed to cast string to int!");
        }
    }
}
