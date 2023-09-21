package calculator.viewer;

/**
 * Доступные кнопки.
 * 
 * При помощи этого enum пользователь может получать
 * ссылки на объекты кнопок из вьювера
 */
public enum Buttons {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    DOT("."),
    CLEAR_ALL("CA"),
    CLEAR_ENTRY("CE"),
    PLUS("+"),
    MINUS("-"),
    STAR("*"),
    SLASH("/"),
    EQUAL("="),
    OPENING_BRACKET("("),
    CLOSING_BRACKET(")"),
    MODULO("mod"),
    PERCENT("%"),
    POWER_OF_TWO("^2");

    String label;

    Buttons(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}