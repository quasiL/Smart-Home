package cz.cvut.omo.sp.smart_home.model.gate;

public class Window
{
    private GateCondition condition;
    private boolean automatic;
    private int position;

    public Window()
    {
        this.condition = GateCondition.OPENED;
        this.automatic = false;
        this.position = 0;
    }

    public GateCondition getCondition()
    {
        return condition;
    }

    public void setCondition(GateCondition condition)
    {
        this.condition = condition;
    }

    public boolean isAutomatic()
    {
        return automatic;
    }

    public void setAutomatic(boolean automatic)
    {
        this.automatic = automatic;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
}