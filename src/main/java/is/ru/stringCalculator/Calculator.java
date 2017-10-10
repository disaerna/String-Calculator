package is.ru.stringCalculator;

import java.util.*;

public class Calculator {

    public static int add(String text){
        if(text == "")  return 0;
        String[] numbers = new String[text.length()];      
        if(text.contains("//")){
            String sub = text.substring(0,2);
            int equal = sub.compareTo("//");
            if(equal == 0){
                String delimeter = Character.toString(text.charAt(2));
                text = text.substring(4,(text.length()));
                numbers = text.split(delimeter);
            }
        }
        else if(text.contains(",")){
            if(text.contains("\n")){
                numbers = text.split("\n|,");
            }
            else{
                numbers = text.split(",");
            }
        }
        else{
            if(Integer.parseInt(text) < 0){
                throw new IllegalArgumentException("Negatives not allowed: " + text);            
            }
            if(Integer.parseInt(text) > 1000){
                throw new IllegalArgumentException("Numbers bigger than 1000 are ignored");
            }
            return Integer.parseInt(text);
        }
        int ret = 0;
        List<Integer> negatives = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++){
            if(Integer.parseInt(numbers[i]) < 0){
                 negatives.add(Integer.parseInt(numbers[i]));
            }
            if(Integer.parseInt(numbers[i]) > 1000){
                continue;
            }
            ret += Integer.parseInt(numbers[i]);
        }
        if(negatives.size() > 0 ){
            String negativeText = "";
            for(int var : negatives){
                if(var == negatives.get(negatives.size()-1)){
                    negativeText += var;
                }
                else{
                    negativeText += var+",";
                }
            }
            throw new IllegalArgumentException("Negatives not allowed: " + negativeText);
        }
        
        return ret;
    }
}