package com.example.helloworld.DesignPatterns.SOLID;

class Document{

}

interface Machine{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements  Machine{

    @Override
    public void print(Document d) {
//        something can be done in new multi function printer
    }

    @Override
    public void fax(Document d) {
//        something can be done in new multi function printer
    }

    @Override
    public void scan(Document d) {
//        something can be done in new multi function printer
    }
}

class OldFunctionPrinter implements Machine{

//    Only Printing can be performed in Old function printer
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}
// Above violates the ISP because we are forced to implement all the methods of interface in old printer
// We'll segregate the interface as below
interface Printer{
    void Print(Document d);
}
interface Scanner{
    void scan(Document d);
}
// YAGNI = You ain't going to need it
class JustAPrinter implements Printer{

    @Override
    public void Print(Document d) {

    }
}
class PhotoCopier implements Printer,Scanner{

    @Override
    public void Print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {

    }
}
