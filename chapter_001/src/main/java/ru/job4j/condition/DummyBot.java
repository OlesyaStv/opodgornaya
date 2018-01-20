package ru.job4j.condition;
/**
 * @author Olesya Podgornaya
 * @version $Id$
 * @since 20.01.2018
 */
public class DummyBot {
		/**
		* @param question ������ �� �������.
		* @return �����.
		*/
		public String answer(String question) {
			if ("Привет, Бот.".equals(question)) {
				return "Привет, Умник.";
			} else if ("Пока".equals(question)) {
				return "До скорой встречи.";
			} else {
				return "Это ставит меня в тупик. Спросите другой вопрос.";
			}
		}
}