package com.bootcamp.solid;

public class Substraction implements OperationI {

    public double a;
    public double b;
    public double result = 0.0;

    public Substraction(double a, double b) {
        this.a = a;
        this.b = b;
    }

	@Override
	public double Operation() {
		this.result=this.a-this.b;
		return result;
	}

}