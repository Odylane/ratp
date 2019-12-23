package fr.formation.ratp.entities;

public class Station {

	private String name;
	private Line line;

	
	@Override
	public String toString() {
		return name + " (" + line + ")";
	}

	public Station(String name, Line line) {
		super();
		this.name = name;
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

}
