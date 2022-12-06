package com.example.helloworld.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
A. High level modules should not depend on low level modules.
 both should depend on abstractions
B. Abstraction should not depend on details.
Details should depend on abstractions.
 */
enum Relationship{
    PARENT,
    CHILD,
    SIBLING
}
class Person{
    public String name;
    public Person(String name){
        this.name = name;
    }
}
class Triplet<T, U, V> {

    private final T first;
    private final U second;
    private final V third;

    public Triplet(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
    public V getThird() { return third; }
}

interface RelationshipBrowser{
    List<Person> findAllChildrenOf(String name);
}
class Relationships implements RelationshipBrowser{// low-level
    private List<Triplet<Person,Relationship,Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent,Person child){
        relations.add(new Triplet<>(parent,Relationship.PARENT,child));
        relations.add(new Triplet<>(child,Relationship.CHILD,parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getFirst().name,name) && x.getSecond() == Relationship.PARENT)
                .map(Triplet::getThird)
                .collect(Collectors.toList());
    }
}

class Research{// High level
// violate ISP
//    public Research(Relationships relationships){
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(p->p.getFirst().name.equals("John") && p.getSecond() == Relationship.PARENT)
//                .forEach(ch-> System.out.println("John has a child called "+ch.getThird().name));
//    }
//    Doesn't violate ISP
    public Research(RelationshipBrowser browser){
        List<Person> children = browser.findAllChildrenOf("John");
        for(Person child: children)
            System.out.println("John has a child called "+child.name);
    }
}

public class DependecnyInversionPrinciple {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent,child1);
        relationships.addParentAndChild(parent,child2);

        Research research = new Research(relationships);
    }
}
