package model.device;

import service.visitor.Visitor;

public interface BasicActions
{
    void countElectricity();

    void createReports(String fileName);

    String[] accept(Visitor visitor);

    void restart();

    void synchronizeTime();
}