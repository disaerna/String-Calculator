package is.ru.stringCalculator;

public class Calculator {

    public static int add(String text){
        if(text == "")  return 0;
        if(text.contains(",")){
            String[] numbers;
            numbers = text.split(",");
            int ret = 0;
            for(int i=0; i<numbers.length; i++){
                ret += Integer.parseInt(numbers[i]);
            }
            return ret;
        }
        return Integer.parseInt(text);
    }
}