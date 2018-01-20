package ru.job4j.condition;
/**
 * @author Olesya Podgornaya
 * @version $Id$
 * @since 21.01.2018
 */
public class DummyBot {
    /**
     * @param question вопрос
     * @return answer ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, Умник.";
        } else if ("Пока".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
