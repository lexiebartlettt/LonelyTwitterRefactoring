package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.data.LonelyTweet;

public class TweetsDataBaseManager extends TweetManager{

	@SuppressWarnings("unchecked")
	public List<LonelyTweet> loadTweets(){
	 List<LonelyTweet> tweets = new ArrayList<LonelyTweet>();
	 return tweets;
	}

	public void saveTweets(List<LonelyTweet> tweets){
	
	}

}