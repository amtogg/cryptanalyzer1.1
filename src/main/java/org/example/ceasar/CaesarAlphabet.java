package org.example.ceasar;

import org.example.ceasar.exeption.CaesarAlphabetException;

import java.util.*;

public class CaesarAlphabet {
    // сделать через наследование или интерфейсы, потом     36-38 52-53
    public static final Character[] RU_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я'};
    public static final Character[] EN_ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i','j', 'k', 'l','m', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
    public static final Character[] SIMBOLS_ALPHABET = {'1', '2', '3', '4', '5', '6', '7','8', '9', '0', '!', '@','#', '$','%', '^','&', '*', '?', '(', ')', '-', '+', '/', '.',',',';', ':','=','_' };

    private final List <Character> alphabet;

    private final Map<Character, Integer> charIndex;
    public CaesarAlphabet(){
        List<Character> temporaryAlphabet = new ArrayList<>();

        temporaryAlphabet.addAll(Arrays.asList(RU_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(EN_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(SIMBOLS_ALPHABET));

        alphabet = List.copyOf(temporaryAlphabet);

        charIndex = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            charIndex.put(alphabet.get(i), i);
        }
    }
    public Character getCharacterByIndex(int index) {
        if (index < 0 || index > alphabet.size()){
            try {
                throw new CaesarAlphabetException ("Неправильный индекс. Индекс " + index + " Правилный индекс с 0 до " + alphabet.size());
            } catch (CaesarAlphabetException e) {
                throw new RuntimeException(e);
            }
        }
        return alphabet.get(index);
    }

    public Integer getCharacterIndex(Character character) { // todo Integer?
        if (!charIndex.containsKey(character)){
            try {
                throw new CaesarAlphabetException("Неизвестный символ. Символ " + character + " не найден в алфавите");
            } catch (CaesarAlphabetException e) {
                throw new RuntimeException(e);
            }
        }

        return charIndex.get(character);
    }
    public Integer getSize(){
        return  alphabet.size();
    }

}
