package is.ru.stringCalculator;

public class Calculator {

    public static int add(String text){
        if(text == "")  return 0;
        if(text.contains(",")){
            String[] numbers;
            numbers = text.split(",");
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
        return Integer.parseInt(text);
    }
}