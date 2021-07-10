package fill.jma.FileUtile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileWriterUtil implements Runnable {

    Thread t;
    String name;

    FileWriterUtil(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread" + " " + t);
        t.start();
    }

    @Override
    public synchronized void run() {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int average = 0;
        for (int j = 0; j < 10; j++) {
            list.add(j, random.nextInt(100));
            average += list.get(j) / 10;
        }
        appendInt(list, "/Users/user/Desktop/ReadFile/src/fill/jma/FileUtile/DemoText");
        System.out.println(list + "   average this thread is: " + average);
    }

    public static void allThread() throws InterruptedException {
        new FileWriterUtil("tOne");
        new FileWriterUtil("tTwo");
        new FileWriterUtil("tThree");
        new FileWriterUtil("tFour");
        new FileWriterUtil("tFive");
        new FileWriterUtil("tSix");
        new FileWriterUtil("tSeven");
        new FileWriterUtil("tEight");
        new FileWriterUtil("tNine");
        new FileWriterUtil("tTen");
    }

    public static void appendInt(List<Integer> list, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(String.valueOf(list));
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Ups, failed to write into file: " + path, e);
        }
    }
}
