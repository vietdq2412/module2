package file_data_IO;

import sun.tools.jconsole.JConsole;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileIO<T> {
    private String name;
    @SuppressWarnings("unchecked")
    private static FileIO<?> instance = new FileIO<>();

    private FileIO() {
    }

    @SuppressWarnings("unchecked")
    public static FileIO<?> getInstance(){
        return instance;
    }

    public void handleEvent(Object event) {
        System.out.println("I am a singleton. An event happened: " + event);
    }

    private static final String PATH = "C:\\Users\\vietd\\Desktop\\S\\CG\\Module 2\\demo1\\src\\main\\java\\data\\";

    public boolean checkFile(String path){
        if (new File(PATH + path).length() > 0){
            return true;
        }
        return  false;
    }
    public void writeFile(String path, Map<String, T> map) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH + path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public Map<String, T> readFile(String path) {
        Map<String, T> map = new HashMap<>();

        if (checkFile(path)){
            try {
                FileInputStream fileInputStream = new FileInputStream(PATH + path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                map = (HashMap<String, T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    };

    public void clearFile(String path){
        File file = new File(PATH + path);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.print("");
        writer.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
