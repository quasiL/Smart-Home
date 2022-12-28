package model.resident;

public class Animal extends Resident
{
    private final String kindOfAnimal;

    public Animal(String name, int age, String kindOfAnimal)
    {
        super(name, age);
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getKindOfAnimal()
    {
        return kindOfAnimal;
    }
}