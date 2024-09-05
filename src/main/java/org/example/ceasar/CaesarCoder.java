package org.example.ceasar;

import org.example.file.FileNameValidator;
import org.example.file.FileProcessor;

import java.util.List;

public class CaesarCoder {
    private CaesarChipher caesarChipher;
    private FileNameValidator fileNameValidator;
    private FileProcessor fileProcessor;
      public CaesarCoder() {
          this.caesarChipher = new CaesarChipher(new CaesarAlphabet());
          this.fileNameValidator = new FileNameValidator();
          this.fileProcessor = new FileProcessor();
      }
      public void encrypt(String inputFileName, String outputFileName, Integer key){
          fileNameValidator.validateForReading(inputFileName);
          fileNameValidator.validateForWriting(outputFileName);

          List<String> sourceLines = fileProcessor.readFromFile(inputFileName); // попробовать переписать, чтобы подключиться и сразу все прочитать и записать, а не по строкам
          for (String sourceLine : sourceLines) {
              String encryptedLine = caesarChipher.encrypt(sourceLine, key);
              fileProcessor.writeToFile(outputFileName, encryptedLine);
          }
      }

      public void decrypt(String inputFileName, String outputFileName, Integer key){
          fileNameValidator.validateForReading(inputFileName);
          fileNameValidator.validateForWriting(outputFileName);

          List<String> sourceLines = fileProcessor.readFromFile(inputFileName);
          for (String sourceLine : sourceLines) {
              String decryptedLine = caesarChipher.decrypt(sourceLine, key);
              fileProcessor.writeToFile(outputFileName, decryptedLine);
          }
      }

}
