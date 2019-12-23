package fr.formation.ratp.entities;

public class Line extends Object {

	private String name;

	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Line " + name;
	}

}
