package cz.cvut.omo.sp.sh.model.device;

import cz.cvut.omo.sp.sh.service.visitor.Visitor;

public interface VisitorActions {
    /**
     * A method that allows the visitor to bypass devices
     *
     * @param visitor report's creator
     * @return array of device parameters
     */
    String[] accept(Visitor visitor);
}