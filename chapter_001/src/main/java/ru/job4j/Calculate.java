package ru.job4j;

/**
* Class Класс для вывода строки в консоль
* @author opodgornaya
* @since 14.01.2018
* @version 1
*/

public class Calculate {

	
	/***
	* Конструктор, вывод строки в консоль.
	* @param args - args.
	* @return cтрока "Hello, World!"
	*/
	public static void main(String[] args) {
		System.out.println("Hello, World!");
	}
	
		 
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
 
	
}