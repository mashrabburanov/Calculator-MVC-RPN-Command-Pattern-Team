package calculator;

import calculator.controller.Controller;

public class Calculator {
    public static void main(String args[]) {
        Controller controller = new Controller();
	controller.run(args);
    }
}
