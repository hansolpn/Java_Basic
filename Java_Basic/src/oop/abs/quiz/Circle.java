package oop.abs.quiz;

public class Circle extends Shape {

	private int r;

	public Circle(int r) {
		super("원");
		this.r = r;
	}

	@Override
	public double getArea() {
		return 2 * Math.PI * r;
	}

}
