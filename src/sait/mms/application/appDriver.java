package sait.mms.application;



import java.sql.SQLException;
import java.util.*;

import sait.mms.managers.*;

public class appDriver {
	public static MovieManagementSystem manager = new MovieManagementSystem();

	/**
	 * main appDriver
	 * 
	 * appDriver.java MariaDBJDBCDemo
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		manager.displayMenu();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();

		while (!choice.equals("5")) {
			boolean check = checkDigits(choice);
			if (check) {
				int selection = Integer.parseInt(choice);
				if (selection <= 4 && selection >= 1) {
					if (selection == 1) {
						try {

							System.out.print("please provide the movie title: ");

							String title = input.nextLine();
							System.out.println(title);
							System.out.print("please provide the movie year: ");
							String year = input.nextLine();
							System.out.print("please provide the duration of the movie: ");
							int duration = Integer.parseInt(input.nextLine());
							manager.addMovie(duration, title, year);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("You have to type valid information");
							manager.displayMenu();

						}
					} else if (selection == 2) {
						try {
							System.out.print("please provide the year you want to see: ");
							String years = input.nextLine();
							manager.printMoviesInYear(years);
						} catch (Exception e1) {
							System.out.print("You have to type valid information ");
							manager.displayMenu();

						}
					} else if (selection == 3) {
						System.out.println("Enter the number of movies you want to see: ");

						int number = Integer.parseInt(input.nextLine());
						manager.printRandomMovies(number);
					} else {
						try {
							System.out.print("please provide the movie id: ");
							int ids = Integer.parseInt(input.nextLine());

							manager.deleteMovie(ids);
						} catch (Exception e3) {
							System.out.print("You have to type valid information");
							System.out.println();
							manager.displayMenu();

						}
					}
				} else {
					System.out.println("You have to type integer within 1-5");

				}
			} else {
				System.out.println("You have to type integer within 1-5");
				System.out.println();

			}
			System.out.println();
			manager.displayMenu();
			choice = input.nextLine();
		}
	}

	public static boolean checkDigits(String checkDigits) {
		for (int i = 0; i < checkDigits.length(); i++) {
			if (!Character.isDigit(checkDigits.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
