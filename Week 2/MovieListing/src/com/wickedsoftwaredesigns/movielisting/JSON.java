package com.wickedsoftwaredesigns.movielisting;


import org.json.JSONException;
import org.json.JSONObject;

import com.wickedsoftwaredesigns.libs.Movies;

public class JSON {

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
				queryObject.put(movie.name().toString(), moviesObject);

			}
			// Add query to movies object
			moviesObject.put("query", queryObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return moviesObject;
	}

	public static String readJSON(String selected) {

		String result;
		String theater;
		String movieName;
		String showtimes;
		
		JSONObject object = buildJSON();
		
		try {
			theater = object.getJSONObject("query").getJSONObject(selected).getString("theater");
			showtimes = object.getJSONObject("query").getJSONObject(selected).getString("showtimes");
			movieName = object.getJSONObject("query").getJSONObject(selected).getString("movieName");
			result = "Theater: " + theater + "\r\n" +
					 "Show Times: " + showtimes + "\r\n" +
					 "Movie Title: " + movieName;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString() + "\r\n" + "What the Hell";
		}
		
		return result;
	}

}
