package com.example.helloworld.DesignPatterns.Creational.Builder;

class Person{
    // address
    public String streetAddress, postCode, city;
    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}
// builder facade
class PersonFacadeBuilder{
    protected Person person = new Person();

    public PersonJobBuilder works()
    {
        return new PersonJobBuilder(person);
    }

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public Person build(){
        return person;
    }
}
class PersonAddressBuilder extends PersonFacadeBuilder{
    public PersonAddressBuilder(Person person){
        this.person = person;
    }
    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }
    public PersonAddressBuilder withPostcode(String postcode){
        person.postCode = postcode;
        return this;
    }
    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonFacadeBuilder
{
    public PersonJobBuilder(Person person)
    {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName)
    {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position)
    {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome)
    {
        person.annualIncome = annualIncome;
        return this;
    }
}

public class FacetedBuilder {
    public static void main(String[] args) {
        PersonFacadeBuilder pb = new PersonFacadeBuilder();
        Person person = pb
                .lives()
                    .at("123 Nihal vihar")
                    .in("New Delhi")
                    .withPostcode("110041")
                .works()
                    .at("Deutsche bank")
                    .asA("Developer")
                    .earning(123000)
                .build();
        System.out.println(person);
    }
}
