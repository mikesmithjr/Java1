/*
 * project     MovieListing
 * 
 * package		com.wickedsoftwaredesigns.movielisting
 * 
 * @author     Michael R. Smith Jr
 * 
 * date			Jul 17, 2013
 */
package com.wickedsoftwaredesigns.movielisting;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.wickedsoftwaredesigns.libs.Movies;

// TODO: Auto-generated Javadoc
/**
 * The Class JSON.
 */
public class JSON {

	/**
	 * Builds the json.
	 * 
	 * @return the jSON object
	 */
	public static JSONObject buildJSON() {

		// create Movies JSONObject
		JSONObject moviesObject = new JSONObject();

		try {
			// create query object
			JSONObject queryObject = new JSONObject();

			// create movie objects in query
			for (Movies movie : Movies.values()) {

				// create movies info object
				JSONObject infoObject = new JSONObject();

				// add movie info to object
				infoObject.put("theater", movie.setTheater());
				infoObject.put("showtimes", movie.setShowtimes());
				infoObject.put("movieName", movie.setMovieName());
				queryObject.put(movie.name().toString(), infoObject);

			}
			// Add query to movies object
			moviesObject.put("query", queryObject);
			// Log.i("JSOn", moviesObject.toString());
		} catch (JSONException e) {
			Log.e("JSoNError", "Error", e);
			e.printStackTrace();
		}

		return moviesObject;
	}

	/**
	 * Read json.
	 * 
	 * @param selected
	 *            the selected Here is the c
	 * @return the string
	 */
	public static String readJSON(String selected) {

		String result;
		String theater;
		String movieName;
		String showtimes;
		// Calls the JSON object built above
		JSONObject object = buildJSON();
		// Pulls and parses the data into a string
		try {
			theater = object.getJSONObject("query").getJSONObject(selected)
					.getString("theater");
			showtimes = object.getJSONObject("query").getJSONObject(selected)
					.getString("showtimes");
			movieName = object.getJSONObject("query").getJSONObject(selected)
					.getString("movieName");
			result = "Theater: " + theater + "\r\n" + "Show Times: "
					+ showtimes + "\r\n" + "Movie Title: " + movieName;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("error tag", "error", e);
			result = "";
		}

		return result;
	}

}
