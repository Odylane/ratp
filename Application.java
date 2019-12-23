package fr.formation.ratp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Line line = buildLine("M14"); // stocker dans la variable line la m�thode buildLine
		System.out.println(line);

		List<Station> stations = buildStations(line, "Saint Lazare", "Madeleine", "Pyramides", "Ch�telet",
				"Gare de Lyon", "Bercy", "Cour Saint-Emilion", "Biblioth�que Fran�ois Mitt�rand", "Olympiades");
		System.out.println(stations);

		List<Journey> journeys = buildJourneys(stations, 5);
		System.out.println(journeys);

//		Scanner input = new Scanner(System.in); // Create a Scanner object
//		System.out.println("Please input your departure station:");
//		String departureUser = input.nextLine(); // Read input
//		System.out.println("Please input your arrival station:");
//		String arrivalUser = input.nextLine(); // Read input
//		System.out.println("Your journey is : " + departureUser + " - " + arrivalUser);
//		input.close();

		Station departureUser = journeys.get(2).getDeparture();
		Station arrivalUser = journeys.get(4).getArrival();
		System.out.println(departureUser + " -> " + arrivalUser + " = " + (buildTravelTime(departureUser, arrivalUser, journeys)) + " minutes");

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
			// fait r�f�rence � la cr�ation d'une nouvelle journ�e via le constructeur
			Journey journey = new Journey(duration, template.get(i), template.get(i + 1));

			// ajoute dans la liste
			journeys.add(journey);
		}

		return journeys;
	}

	// Objectif : Calcul d'un trajet entre deux stations
	private static int buildTravelTime(Station departureUser, Station arrivalUser, List<Journey> journeys) {

		int sumDuration = 0; // D�clarer une variable pour la somme des duration
		boolean checkStation = false;

		for (Journey journey : journeys) {

			// R�cup�rer la Station de d�part de journey courant
			// Comparer les 2
			if (journey.getDeparture().equals(departureUser)) {
				// Si pareil alors parcourir la suite des journeys
				checkStation = true;
			}

			if (checkStation == true) {
				// Additionner les duration
				sumDuration = sumDuration + journey.getDuration();
			}
			// S'arr�ter quand la station d'arriv�e de journey courant est �gale � station d'arriv�e recherch�e
			if (journey.getArrival().equals(arrivalUser)) {
				checkStation = false;
			}

		}
		// Retourner la somme
		return sumDuration;
	}
}
