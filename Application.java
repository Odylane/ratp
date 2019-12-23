package fr.formation.ratp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Line line = buildLine("M14"); // stocker dans la variable line la méthode buildLine
		System.out.println(line);

		List<Station> stations = buildStations(line, "Saint Lazare", "Madeleine", "Pyramides", "Châtelet",
				"Gare de Lyon", "Bercy", "Cour Saint-Emilion", "Bibliothèque François Mittérand", "Olympiades");
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

		// déclare une list
		List<Station> stations = new ArrayList<>();
		
		// itération sur les names
		// récupérer un name (grâce à la boucle foreach)
		for (String name : names) {

			// construire une station avec son name et line
			Station station = new Station(name, line);

			// ajoute dans la liste
			stations.add(station);

		}

		// return list
		return stations;

	}

	// Objectif : Créer liste des journeys
	private static List<Journey> buildJourneys(List<Station> template, int duration) {
		// déclarer liste Journeys
		List<Journey> journeys = new ArrayList<>();

		for (int i = 0; i < template.size() - 1; i++) {

			// construire une journey avec sa duration, departure et arrival
			// fait référence à la création d'une nouvelle journée via le constructeur
			Journey journey = new Journey(duration, template.get(i), template.get(i + 1));

			// ajoute dans la liste
			journeys.add(journey);
		}

		return journeys;
	}

	// Objectif : Calcul d'un trajet entre deux stations
	private static int buildTravelTime(Station departureUser, Station arrivalUser, List<Journey> journeys) {

		int sumDuration = 0; // Déclarer une variable pour la somme des duration
		boolean checkStation = false;

		for (Journey journey : journeys) {

			// Récupérer la Station de départ de journey courant
			// Comparer les 2
			if (journey.getDeparture().equals(departureUser)) {
				// Si pareil alors parcourir la suite des journeys
				checkStation = true;
			}

			if (checkStation == true) {
				// Additionner les duration
				sumDuration = sumDuration + journey.getDuration();
			}
			// S'arrêter quand la station d'arrivée de journey courant est égale à station d'arrivée recherchée
			if (journey.getArrival().equals(arrivalUser)) {
				checkStation = false;
			}

		}
		// Retourner la somme
		return sumDuration;
	}
}
