package com.example.helloworld.DesignPatterns;

public class Builder {
    public static void main(String[] args) {
//        Simple example
        String hello = "hello";
        System.out.println("<p>"+hello+"</p>");

//        Complex examples
        String[] words = {"hello","world","how"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for(String word:words){
            sb.append(String.format("    <li>%s</li>\n",word));
        }
        sb.append("</ul>");
        System.out.println(sb);
    }
}
