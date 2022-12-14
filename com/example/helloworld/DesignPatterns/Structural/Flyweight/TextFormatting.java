package com.example.helloworld.DesignPatterns.Structural.Flyweight;

import java.util.Arrays;

class FormattedText{
    private String plainText;
    private boolean[] capitalize;

    public FormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start,int end){
        for(int i=start; i<= end; i++)
            capitalize[i] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<plainText.length(); i++){
            char c = plainText.charAt(i);
            sb.append(
                    capitalize[i]?Character.toUpperCase(c):c
            );
        }
        return sb.toString();
    }
}



public class TextFormatting {
    public static void main(String[] args) {
        FormattedText formattedText = new FormattedText("Hello everyone how are you?");
        formattedText.capitalize(4,10);
        System.out.println(formattedText);
    }
}
