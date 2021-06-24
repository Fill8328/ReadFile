package fill.jma;

import fill.jma.FileUtile.FileReaderUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(FileReaderUtil.readFile("data/input.txt"));
    }
}
