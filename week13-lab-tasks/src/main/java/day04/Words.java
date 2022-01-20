package day04;

import java.util.Map;
import java.util.TreeMap;

public class Words {
    private Map<Character, Integer> vowelCounterList = new TreeMap<>();
    private static final String vowels = "aeiou";

    public void selectAllVowels(String sentence){
        sentence = sentence.toLowerCase();
        for(Character actual : sentence.toCharArray()){
            if(vowels.indexOf(actual) != -1) {
                putDatasToW(actual);
            }
        }
    }

    private void putDatasToW(Character actual){
        if(vowelCounterList.keySet().contains(actual)){
            vowelCounterList.replace(actual, (vowelCounterList.get(actual) + 1));
        }
        else{
            vowelCounterList.put(actual, 1);
        }
    }

//    public Map<Character, Integer> getVowelCounter() {
//        return vowelCounterList;
//    }
//
//    switch (character) {
//        case 'a', 'e', 'i', 'o', 'u' -> true;
//        default -> false;
//    }
//
//    Integer count = vowels.get(ch);
//    vowels.put(ch, count != null ? count + 1 : 1);
}
