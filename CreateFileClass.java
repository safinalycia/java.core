package dz5;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateFileClass {

    public static ArrayList<FileObject> fileObjectArrayList = new ArrayList<>();
    public static final String pathToFile = "src/main/java/lesson5/dz/demo.csv";
    public static final String title = "value1" + ";" + "value2" + ";" + "value3" + ";" + System.getProperty("line.separator");


    public static void main(String[] args) throws IOException {
        createFileObjects();
        //write();
        writeStream();

        AppData appData = readToObject();

    }


    private static void createFileObjects() {
        Random random = new Random();
        for (int i = 1; i < 50; i++) {
            fileObjectArrayList.add(new FileObject(i, random.nextInt(100), random.nextInt(1000)));


        }

    }

    private static void writeStream() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToFile)) {
            for (byte b : title.getBytes(StandardCharsets.UTF_8)) {
                fileOutputStream.write(b);
            }
            for (FileObject fileObject: fileObjectArrayList){
                String raw = fileObject.getValue() + ";" + fileObject.getValueFrom() +";" + fileObject.getValueTo()+ ";"+ System.getProperty("line.seperator");
                for (byte b: raw.getBytes(StandardCharsets.UTF_8)){
                    fileOutputStream.write(b);
                }
            }

        }

    }

    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) ;
            {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));

            }

        }

        int[][] resultData = new int[records.size()][3];

        for (int i = 0; i < records.size(); i++) {
            for (int j = 0; j < records.get(i).size(); j++) {
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }

        appData.setData(resultData);
        return appData;


    }
}
