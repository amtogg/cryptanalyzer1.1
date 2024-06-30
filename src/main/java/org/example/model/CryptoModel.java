package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CryptoModel {
    String fileSourcePath;
    String fileSavePath;
    Integer key;


}
