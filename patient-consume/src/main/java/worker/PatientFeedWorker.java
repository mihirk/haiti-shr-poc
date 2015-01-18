package worker;

import org.ict4h.atomfeed.client.domain.Event;
import org.ict4h.atomfeed.client.service.EventWorker;

public class PatientFeedWorker implements EventWorker {
    @Override
    public void process(Event event) {
        String patient = event.getContent();
    }

    @Override
    public void cleanUp(Event event) {

    }
}
