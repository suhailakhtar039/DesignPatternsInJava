package com.example.helloworld.DesignPatterns.builder;

import java.util.ArrayList;
import java.util.Collections;
class HtmlElement{
    public String name,text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String toStringImpl(int indent){
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty())
        {
            sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements)
            sb.append(e.toStringImpl(indent + 1));

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder{
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName){
        this.rootName = rootName;
        root.name = rootName;
    }

    public HtmlBuilder addChild(String childName,String childText){
        HtmlElement e = new HtmlElement(childName,childText);
        root.elements.add(e);
        return this;
    }

    public void clear(){
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

class PersonTest {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends  PersonBuilder<SELF>> {
    protected PersonTest personTest = new PersonTest();
    public SELF withName(String name){
        personTest.name = name;
        return self();
    }
    public PersonTest build(){
        return personTest;
    }
    protected SELF self(){
        return (SELF)this;
    }
}
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAt(String position){
        personTest.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}
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

//      Using Custom examples
//      Fluent Builders
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li","hello")
                .addChild("li","world")
                .addChild("li","what");
        System.out.println(builder);

    // Person Builder
        PersonBuilder pb = new PersonBuilder();
        PersonTest suhail = pb.withName("Suhail").build();

        // Using Generics
        EmployeeBuilder pb1 = new EmployeeBuilder();
        PersonTest akhtar = pb1.withName("Suhail")
                .worksAt("Deutsche Bank")
                .build();
        System.out.println(akhtar);
    }
}
