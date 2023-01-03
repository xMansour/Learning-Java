package org.example;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
        System.out.println("twitterService.getTimeline(\"EncAlgorithm\") = " + twitterService.getTimeline("EncAlgorithm"));

        //This throws exception from the SecurityProxy
        twitterService.postToTimeline("bla bla bla", "EncAlgorithm");
    }
}