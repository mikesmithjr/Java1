/*
 * project     MovieListing
 * 
 * package		com.wickedsoftwaredesigns.libs
 * 
 * @author     Michael R. Smith Jr
 * 
 * date			Jul 17, 2013
 */
package com.wickedsoftwaredesigns.libs;

// TODO: Auto-generated Javadoc
/**
 * The Enum Movies.
 */
public enum Movies {
	//List of all the movies with their theater, showtimes, and title
	Oblivion("Cinemark Frisco", "5:00pm,6:30pm,11:00pm", "Oblivion"),
	TheCroods("Cinemark Frisco", "5:45pm,6:10pm,11:40pm", "The Croods"),
	ScaryMovie5("Cinemark Frisco", "5:05pm,6:35pm,11:20pm", "Scary Movie 5"),
	GIJoe("Cinemark Frisco", "5:55pm,6:40pm,11:50pm", "G.I Joe"),
	OlympusHasFallen("AMC Stonebriar", "6:00pm,6:10pm,12:00pm", "Olympus Has Fallen"),
	EvilDead("AMC Stonebriar", "7:00pm,6:45pm,10:55pm", "Evil Dead"),
	JurassicPark3D("AMC Stonebriar", "5:05pm,6:25pm,11:40pm", "Jurassic Park 3D"),
	OZ("AMC Stonebriar", "4:55pm,5:30pm,10:25pm", "OZ The Great and Powerfull"),
	Temptation("Cinemark Allen", "5:55pm,6:20pm,11:10pm", "Temptation"),
	HomeRun("Cinemark Allen", "4:00pm,5:30pm,10:40pm", "Home Run"),
	FillyBrown("Cinemark Allen", "7:00pm,8:30pm,12:15pm", "Filly Brown"),
	TheHost("Cinemark Allen", "5:45pm,6:15pm,11:15pm", "The Host");
	//creating strings to hold the data
	private final String theater;
	private final String showtimes;
	private final String movieName;
	
	/**
	 * Instantiates a new movies.
	 *
	 * @param theater the theater
	 * @param showtimes the showtimes
	 * @param movieName the movie name
	 */
	private Movies(String theater, String showtimes, String movieName){
		//saving the data passed into the strings
		this.theater = theater;
		this.showtimes = showtimes;
		this.movieName = movieName;
		
	}
	
	/**
	 * Sets the theater. Can you show me the JSOn Data that you created
	 *
	 * @return the string
	 */
	public String setTheater(){
		return theater;
	}
	
	/**
	 * Sets the showtimes.
	 *
	 * @return the string
	 */
	public String setShowtimes(){
		return showtimes;
	}
	
	/**
	 * Sets the movie name.
	 *
	 * @return the string
	 */
	public String setMovieName(){
		return movieName;
	}
}
