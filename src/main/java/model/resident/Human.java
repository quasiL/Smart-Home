package model.resident;

public class Human extends Resident
{
    private TypeOfAction action;

    public Human(String name, int age)
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