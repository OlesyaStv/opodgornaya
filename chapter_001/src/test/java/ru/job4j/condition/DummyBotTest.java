package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*@author Olesya Podgornaya
*@version $Id$;
*@since 20.01.2018
*/

public class DummyBotTest {
	@Test
	public void whenGreetBot() {
		DummyBot bot = new DummyBot();
		assertThat(
					bot.answer("Привет, Бот."),
					is("Привет, Умник.")
		);
	}
	
	@Test
	public void whenByuBot() {
		DummyBot bot = new DummyBot();
		assertThat(
					bot.answer("Пока"),
					is("До скорой встречи.")
		);
	}
	
	@Test
	public void whenUnknownBot() {
		DummyBot bot = new DummyBot();
		assertThat(
					bot.answer("6+7 = ?"),
					is("Это ставит меня в тупик. Спросите другой вопрос.")
		);
	}
	
}
