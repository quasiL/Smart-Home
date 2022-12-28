package model.resident;

public class Person extends Resident
{
    private TypeOfAction action;

    public Person(String name, int age)
    {
        super(name, age);
    }

    public TypeOfAction getAction()
    {
        return action;
    }

    public void setAction(TypeOfAction action)
    {
        this.action = action;
    }
}