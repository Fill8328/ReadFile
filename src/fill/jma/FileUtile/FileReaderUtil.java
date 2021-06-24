package fill.jma.FileUtile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    private FileReaderUtil(){

    }
    public static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        try(BufferedReader br = new BufferedReader((new FileReader(file)))) {
        String line  = br.readLine();
        List<String> list = new ArrayList<>();
        while ((line = br.readLine())!=null) {
            list.add(line);
        }
        return  list;
        }
        catch (IOException e){
            e.printStackTrace();
        }
       throw new RemoteException("ABOBA");
    }
}
