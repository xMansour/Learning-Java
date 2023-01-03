package org.example;

public class TwitterServiceStub implements TwitterService
{
    @Override
    public String getTimeline(String screenName) {
        return "Getting Timeline...";
    }

    @Override
    public String postToTimeline(String screenName, String message) {
        return null;
    }
}
