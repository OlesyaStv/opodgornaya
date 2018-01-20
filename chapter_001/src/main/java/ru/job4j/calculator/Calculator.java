package ru.job4j.calculator;

/**
 * Class �����������
 * @author opodgornaya
 * @since 20.01.2018
 * @version 1
 */

public class Calculator {
	private double result;
 
	/**
	 * Method add.
	 * @param first, second.
	 */
	public void add(double first, double second) {
        	this.result = first + second;
    	}

	/**
	 * Method subtract.
	 * @param first, second.
	 */
	public void subtract(double first, double second) {
        	this.result = first - second;
    	}

	/**
	 * Method div.
	 * @param first, second.
	 */
	public void div(double first, double second) {
        	this.result = first / second;
    	}

	/**
	 * Method multiple.
	 * @param first, second.
	 */
	public void multiple(double first, double second) {
        	this.result = first * second;
    	}
    
	/**
	 * Method getResult.
	 * @return result.
	 */
    	public double getResult() {
        	return this.result;
   	}

}
