package org.example.ceasar;

public class CaesarChipher {
    private final CaesarAlphabet alphabet;
    public CaesarChipher(CaesarAlphabet alphabet) {
        this.alphabet = alphabet;
    }
    public String encrypt(String originalText, Integer key){
        return process(originalText, key);
    }
    public String decrypt(String encryptedText, Integer key){
        return process(encryptedText, -key);
    }
    private String process(String originalText, Integer key){
        StringBuilder result = new StringBuilder();

        for (Integer i = 0; i < originalText.length(); i++){
           Character originalCharacter = toLowerCase(originalText.charAt(i));
           Integer originalCharacterIndex = alphabet.getCharacterIndex(originalCharacter);
           Integer newCharacterIndex = (alphabet.getSize() + (originalCharacterIndex + key)) % alphabet.getSize();

           result.append(alphabet.getCharacterByIndex(newCharacterIndex));
        }
        return result.toString();
    }
    private Character toLowerCase(Character character) {
        return (character + "").toLowerCase().charAt(0);//для перевода в строку ""
    }

}
