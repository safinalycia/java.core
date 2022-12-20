package dz5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {

    private String [] header;
    private Integer[][] data;


    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public AppData(){

    }

    public void save (String fileName){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowToString(header));

            for (Integer[] row : data) {
                writer.write(Arrays.toString(row));
            }
        } catch (IOException e){
            e.printStackTrace();

        }
    }

    private <T> String rowToString(T[] row){
        String result = ";";
        for (int i = 0; i < row.length; i++) {
            result = result + row[i].toString();
            if (i != row.length - 1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }

    public void load(String fileName){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataRow(tempString));
            }
            data = dataList.toArray(new Integer[][]{{}});
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Integer[] stringToDataRow(String tempString) {
        String[] strings = tempString.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
