package org.example;

public interface TwitterService {
    String getTimeline(String screenName);

    String postToTimeline(String screenName, String message);

}
