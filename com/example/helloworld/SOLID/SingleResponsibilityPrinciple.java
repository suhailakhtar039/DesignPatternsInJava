package com.example.helloworld.SOLID;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add((++count) + " : " + text);
    }

    public void removeEntry(int idx) {
        entries.remove(idx);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

class Persistence {
    public void saveToFile(Journal journal, String fileName, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream(fileName)) {
                out.println(journal.toString());
            }
        }
    }
//    public Journal load(String fileName){}
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I fixed a bug today");
        System.out.println(j);

        Persistence p = new Persistence();
        String fileName = "C:\\Users\\Suhail Akhtar\\Downloads\\created.txt";
        p.saveToFile(j,fileName,true);

        Runtime.getRuntime().exec("notepad.exe "+fileName);
    }
}
