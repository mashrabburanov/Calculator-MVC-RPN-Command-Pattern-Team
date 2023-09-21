import calculator.Calculator;

/**
 * Класс Main является точкой входа в приложение.
 * Здесь происходит запуск статического метода run()
 * класса Calculator. Данный метода (run()) является 
 * оберткой для метода launch(String args[]) 
 * абстрактного класса Application.
 */
public class Main {
    public static void main(String args[]) {
        Calculator.run(args);
    }
}