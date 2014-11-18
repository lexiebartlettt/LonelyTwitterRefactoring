package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.data.LonelyTweet;

import android.content.Context;
import android.util.Log;

public class TweetsFileManager extends TweetManager {

	private static final String FILENAME = "file.sav";
	private Context ctx;

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<LonelyTweet> loadTweets()  {
				List<LonelyTweet> tweets = new ArrayList<LonelyTweet>();
			
				try {
					tweets = loadFromFile(tweets);
				} catch (StreamCorruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OptionalDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return tweets;
			}

	@Override
	public void saveTweets(List<LonelyTweet> tweets)  {
					try {
						saveInFile(tweets);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

	@SuppressWarnings("unchecked") 
	List<LonelyTweet> loadFromFile(List<LonelyTweet> tweets)
			throws FileNotFoundException, StreamCorruptedException,
			IOException, OptionalDataException, ClassNotFoundException {
		FileInputStream fis = ctx.openFileInput(FILENAME);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Object o = ois.readObject();

		if (o instanceof ArrayList) {
			tweets = (ArrayList<LonelyTweet>) o;
		} else {
			Log.i("LonelyTwitter", "Error casting");
		}
		return tweets;
	}

	void saveInFile(List<LonelyTweet> tweets) throws IOException{
		FileOutputStream fos = ctx.openFileOutput(FILENAME, 0);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(tweets);

		fos.close();
	}

}
