package properties;

import java.io.InputStream;
import java.util.Properties;

public class AtomfeedProperties {

    private static final String FEED_CONNECT_TIMEOUT = "feed.connectionTimeoutInMilliseconds";
    private static final String FEED_REPLY_TIMEOUT = "feed.replyTimeoutInMilliseconds";
    private static final String FEED_MAX_FAILED_EVENTS = "feed.maxFailedEvents";

    public static final String DEFAULT_PROPERTY_FILENAME = "/atomfeed.properties";

    private Properties properties;

    private static AtomfeedProperties atomFeedProperties;

    private AtomfeedProperties() {
        InputStream propertyStream = null;
        try {
            propertyStream = this.getClass().getResourceAsStream(DEFAULT_PROPERTY_FILENAME);
            properties = new Properties();
            properties.load(propertyStream);

        } catch (Exception e) {
        } finally {
            if (null != propertyStream) {
                try {
                    propertyStream.close();
                    propertyStream = null;
                } catch (Exception e) {
                }
            }

        }
    }

    public static AtomfeedProperties getInstance() {
        if (atomFeedProperties == null) {
            synchronized (AtomfeedProperties.class) {
                if (atomFeedProperties == null) {
                    atomFeedProperties = new AtomfeedProperties();
                }
            }
        }
        return atomFeedProperties;
    }


    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public String getFeedConnectionTimeout() {
        return getProperty(FEED_CONNECT_TIMEOUT);
    }

    public String getFeedReplyTimeout() {
        return getProperty(FEED_REPLY_TIMEOUT);
    }

    public String getMaxFailedEvents() {
        return getProperty(FEED_MAX_FAILED_EVENTS);
    }
}
