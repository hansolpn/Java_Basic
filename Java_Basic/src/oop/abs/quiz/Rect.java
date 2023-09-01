package oop.abs.quiz;

public class Rect extends Shape {

	private int width;
	private int height;

	public Rect(String name, int width, int height) {
		super(name);
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

}
