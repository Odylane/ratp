package fr.formation.ratp.entities;

public class Journey {

	private int duration;
	private Station departure;
	private Station arrival;

	public Journey(int duration, Station departure, Station arrival) {
		this.duration = duration;
		this.departure = departure;
		this.arrival = arrival;
	}

	public Journey() {

	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArrival() {
		return arrival;
	}

	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}
	
	@Override
	public String toString() {
		return "Journey= [duration=" + duration + " min, departure=" + departure + ", arrival=" + arrival+"]";
	}

}
