package fr.formation.ratp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Line line = buildLine("M14"); // stocker dans la variable line la m�thode buildLine

		System.out.println(line);

		List<Station> stations = buildStations(line, "Saint Lazare", "Madeleine", "Pyramides");

		System.out.println(stations);

		List<Journey> journeys = buildJourneys(stations, 5);

		System.out.println(journeys);

//		Scanner scan = new Scanner(System.in); // Create a Scanner object
//		System.out.println("Please input your departure and arrival stations: (departure-arrival)");
//		String properties = scan.nextLine(); // Read input
//		String[] charProperties = properties.split("-");
//		scan.close();

		Station departureUser = journeys.get(0).getDeparture();
		Station arrivalUser = journeys.get(5).getArrival();
		
		
		int travelTime = buildTravelTime();
		System.out.println(travelTime);
	}

	private static Line buildLine(String name) {
		return new Line(name);

	}

	// Objectif : retourner des stations
	private static List<Station> buildStations(Line line, String... names) {

		// d�clare une list
		List<Station> stations = new ArrayList<>();
		// it�ration sur les names
		// r�cup�rer un name (gr�ce � la boucle foreach)
		for (String name : names) {

			// construire une station avec son name et line
			Station station = new Station(name, line);

			// ajoute dans la liste
			stations.add(station);

		}

		// return list
		return stations;

	}

	// Objectif : Cr�er liste des journeys
	private static List<Journey> buildJourneys(List<Station> template, int duration) {
		// d�clarer liste Journeys
		List<Journey> journeys = new ArrayList<>();

		for (int i = 0; i < template.size() - 1; i++) {

			// construire une journey avec sa duration, departure et arrival
			Journey journey = new Journey(duration, template.get(i), template.get(i + 1));

			// ajoute dans la liste
			journeys.add(journey);
		}

		return journeys;
	}

	private static int buildTravelTime(Station departureUser, Station arrivalUser, Journey... journeys) {

		int sumDuration = 0;

		// List<Journey> journeys = new ArrayList<>();

		for (Journey journey : journeys) {

			// R�cup�rer la Station de d�part de journey courant
			// Comparer les 2 stations de d�part

			if (departureUser.equals(journey.getDeparture())) {

				System.out.println(journey.getDeparture());

				// (journeys.arrival().equals(arrivalUser))
			}

			else {
				// continuer it�ration pour trouver la departureUser

				if (arrivalUser.equals(journey.getArrival())) {
					// ajouter 5 jusqu'� arrivalUser
					sumDuration += 5;

					System.out.println(journey.getArrival());

				} else {
					// continuer it�ration pour trouver arrivalUser
				}
			}

		}
		return sumDuration;
	}

}
