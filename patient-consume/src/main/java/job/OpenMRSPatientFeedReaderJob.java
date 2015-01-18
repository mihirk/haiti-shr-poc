package job;

import org.ict4h.atomfeed.client.service.FeedClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class OpenMRSPatientFeedReaderJob implements Job {
    private FeedClient patientFeedClient;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            processEvents();
        } catch (Exception e) {
            try {
                initializeAtomFeedClient();
            } catch (Exception ignored) {

            }
        }
    }

    private void initializeAtomFeedClient() {

    }

    private void processEvents() {
        if(patientFeedClient == null){
            initializeAtomFeedClient();
        }
    }
}
