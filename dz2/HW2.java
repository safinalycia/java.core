package dz2;

public class HW2 {

    static String [][] arrayDataException = {{"17", "17", "17", "утя"}, {"18", "18", "18", "18"}, {"19", "19", "19", "кися"}, {"20", "20", "20", "волк"}};
    static String [][] arraySizeException = {{"17", "17"}, {"18", "18"}, {"19", "19"}, {"20", "20"}};
    static String[][] arrayWithNoError = {{"17", "17", "17", "17"}, {"18", "18", "18", "18"}, {"19", "19", "19", "19"}, {"20", "20", "20", "20"}};

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {
        try {
            System.out.println("сумма массива: " + getSumm(arrayWithNoError));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("сумма массива: " + getSumm(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("сумма массива: " + getSumm(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void checkValue(String[][] array) throws MyArraySizeException{
        if(array.length!=sizeA || array[0].length!=sizeB) throw new MyArraySizeException();

    }
    static Integer getSumm(String[][] array) throws MyArrayDataException,MyArraySizeException{
        checkValue(array);
        Integer result = 0;
        int i =0;
        int j =0;
        try {
            for (; i < array.length; i++) {
                j =0;
                for (; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex){
            throw new  MyArrayDataException("ошибка в позиции: " + i+","+j);
        }

        return result;
    }
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(){
            super("ошибка размера массива");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message){
            super(message);
        }
    }


}
