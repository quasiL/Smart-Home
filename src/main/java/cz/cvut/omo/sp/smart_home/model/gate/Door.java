package cz.cvut.omo.sp.smart_home.model.gate;

public class Door
{
    private GateCondition condition;

    public Door()
    {
        this.condition = GateCondition.OPENED;
    }

    public GateCondition getCondition()
    {
        return condition;
    }

    public void setCondition(GateCondition condition)
    {
        this.condition = condition;
    }
}