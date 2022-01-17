package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringStatistics {
    public Map<Character, Integer> numberOfCharacters(String inputString){
        if(inputString==null){
            throw new NullPointerException("Input mustn't be null!");
        }
        Map<Character, Integer> numberOfCharactersMap=new HashMap<>();
        for (char c: inputString.toCharArray()) {
            process(c,numberOfCharactersMap);
        }
        return numberOfCharactersMap;
    }

    private void process(char c, Map<Character,Integer> numberOfCharactersMap) {
        if(numberOfCharactersMap.containsKey(c)){
            Integer newValue=numberOfCharactersMap.get(c)+1;
            numberOfCharactersMap.put(c,newValue);
        }
        else{
            numberOfCharactersMap.put(c,1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringStatistics stringStatistics=new StringStatistics();
        System.out.println("Type in a string!");
        String input = scanner.nextLine();
        System.out.println(stringStatistics.numberOfCharacters(input));

    }
}
