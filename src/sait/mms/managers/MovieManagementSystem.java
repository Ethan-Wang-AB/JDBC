package sait.mms.managers;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.mms.drivers.*;

public class MovieManagementSystem {
	private MariaDBDriver drivers = new MariaDBDriver();

	public MovieManagementSystem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * displayMenu users need to choose from
	 * @exception catch exception when users have no access to the database(fail to connect)
		 */
	public void displayMenu() {
		System.out.println("1.Add Movie to Database");
		System.out.println("2.Show Certain year's Movies");
		System.out.println("3.Show Movies in Random Order");
		System.out.println("4.Delete a movie from Database");
		System.out.println("5.Exit");
		System.out.println();
		try {
			drivers.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("You do not have authorization to read this database.");
		}
		System.out.print("Enter your choice:");

	}

	/**
	 * addMovie add record to the database, a movie record
	
	 * @param duration the duration of the movie
	 * @param title the title of the movie
	 * @param year the year of the movie
	 * @exception catch exception when the input breach the constraints of the database
	 */
	public void addMovie(int duration, String title, String year) {

		String addMovie = String.format("INSERT INTO `movies` (`duration`, `title`, `year`) VALUES (%d,'%s','%s');",
				duration, title, year);
		try {
			drivers.update(addMovie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("It is an invalid Movie input");

		}
	}

	/**
	 * printMoviesInYear, display specific year of movie and calculate total minutes
		Assignment_4
	 * @param year the year of movie want to search
	 * @exception catch exception when the input is out of the constraint of the database
	 */
	public void printMoviesInYear(String year) {

		String printMoviesInYear = String.format("select * from movies where year='%s';", year);
		try {
			ResultSet results = drivers.get(printMoviesInYear);
			System.out.println();

			System.out.printf("%8s%50s %12s%n", "Duration", "Title", "Year");
			int minutes = 0;
			while (results.next()) {
				System.out.printf("%8s%50s %12s%n", results.getString(2), results.getString(3), results.getString(4));
				minutes = minutes + Integer.parseInt(results.getString(2));
			}
			System.out.println();
			System.out.println("Total minutes are " + minutes + " mins");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("It is an invalid Year input");

		}
	}

	/**
	 * printRandomMovies
	MovieManagementSystem
	
	MovieManagementSystem.java
	Assignment_4
	 * @param number
	 */
	public void printRandomMovies(int number) {
		String printRandomMovies = String.format("select * from movies order by rand() limit %d;", number);

		try {
			ResultSet results = drivers.get(printRandomMovies);

			System.out.println();

			System.out.printf("%8s%50s %12s%n", "Duration", "Title", "Year");
			int minutes = 0;
			while (results.next()) {
				System.out.printf("%8s%50s %12s%n", results.getString(2), results.getString(3), results.getString(4));
				minutes = minutes + Integer.parseInt(results.getString(2));
			}
			System.out.println();
			System.out.println("Total minutes are " + minutes + " mins");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("It is invalid random movies request");
		}

	}

	public void deleteMovie(int id) {
		String deleteMovie = String.format("DELETE FROM movies WHERE id=%d", id);
		try {
			drivers.update(deleteMovie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("It is an invalid id input");
		}

	}

}
