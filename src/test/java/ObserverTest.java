import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.model.EventType;
import cz.cvut.omo.sp.smart_home.model.device.ClimateController;
import cz.cvut.omo.sp.smart_home.service.observer.EventManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObserverTest
{
    private EventManager eventManager;
    private ClimateController climateController;
    private Event firstTestEvent;

    @BeforeEach
    void createEventManagerManuallyWithSomeEvents()
    {
        eventManager = new EventManager(EventType.values());
        firstTestEvent = new Event(EventType.HOUR_HAS_PASSED);
    }

    @Test
    @Order(0)
    void checkIfMethodUpdateWasCalledInListener_isMethodCalled_returnsUpdate()
    {
        climateController = Mockito.mock(ClimateController.class);
        eventManager.subscribe(firstTestEvent.getEventType(), climateController);
        eventManager.notify(firstTestEvent);
        Mockito.verify(climateController).update(firstTestEvent);
    }

    @Test
    @Order(1)
    void checkIfSubscribingWorks_isUnsubscribeGetNotify_returnsUpdate()
    {
        climateController = Mockito.mock(ClimateController.class);
        eventManager.subscribe(firstTestEvent.getEventType(), climateController);
        eventManager.unsubscribe(firstTestEvent.getEventType(), climateController);
        eventManager.notify(firstTestEvent);
        Mockito.verify(climateController, Mockito.times(0)).update(firstTestEvent);
    }
}
