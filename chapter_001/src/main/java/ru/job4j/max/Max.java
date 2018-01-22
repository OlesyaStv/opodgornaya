package ru.job4j.max;
/**
* @author Olesya Podgornyaa
* version $Id$
* since 22.01.2018
*/

public class Max {

	public int max(int first, int second) {
		return first > second ? first : second;
	}

	public int max(int first, int second, int third) {
		return max(max(first, second),third);
	}
}
