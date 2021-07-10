package fill.jma;

import fill.jma.FileUtile.FileReaderUtil;
import fill.jma.FileUtile.FileWriterUtil;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        FileWriterUtil.allThread();
        System.out.println(FileReaderUtil.readFile("/Users/user/Desktop/ReadFile/src/fill/jma/FileUtile/DemoText"));

    }
}
