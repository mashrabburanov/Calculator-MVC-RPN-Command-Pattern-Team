/**
 * Что нужно знать про Application - Этот класс нужен для работы
 * javafx приложение обязательно нужен публичный конструктор 
 * по-умолчанию и также у него имеются методы init(), 
 * start(Stage stage),stop() и launch(String args[]).
 * 
 * Метод init() запускается перед запуском приложения, но здесь
 * нельзя простраивать сцену, подмостки (stage).
 * Метод start() запускает приложение.
 * Метод stop() запускается перед закрытием приложения.
 * 
 * Калькулятор реализован след. образом:
 *                   Калькулятор
 *             /           |           \ 
 *       Контроллер      Вьювер      Модель
 *          /  \                        \
 *      Вьювер Модель                   Вьювер
 * 
 * При этом вьювер, модель и контроллер всего лишь один 
 * экземляр каждый. То есть все три вьювера указывают на 
 * один и тот же объект в памяти.
 * 
 * Струтктура пакетов реализована по директориям 
 * (впрочем так и надо)
 */
package calculator;

/**
 * Импорт всех необходимых элементов из библиотеки javafx 
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Импорт подпакетов для доступа к классам контроллера,
 * вьювера и модели.
 */
import calculator.controller.Controller;
import calculator.viewer.Viewer;
import calculator.model.Model;

/**
 * Класс калькулятор реализует абстрактный класс Application 
 * библиотеки javafx. Запускается из класса Main через метод
 * обертку run().
 */
public class Calculator extends Application {
    private Controller controller;
    private Viewer viewer;
    private Model model;

    /**
     * В конструкторе Calculator() происходит инициализация 
     * контроллера, модели и вьювера.
     */
    public Calculator() {
        super();
        
        viewer = new Viewer();
        controller = new Controller();
        model = new Model();

        viewer.setController(controller);
        model.setViewer(viewer);
        controller.setModel(model);
        controller.setViewer(viewer);
    }

    /**
     * Переопределяется метод start() класса Application
     * Здесь из уже инициализированного в конструкторе 
     * вьювера получаем корневой узел (root Node) в данном
     * узле находятся все отображаемые элементы: кнопки и 
     * текстовое поле с лэйблом.
     * 
     * В javafx для отображения элементов используется следующая
     * схема:
     * у нас есть stage (подмосток) на который помещаются scene
     * (сцены), в сцену кладется корневой узел с элементами в 
     * виде древа.
     * 
     * Метод show() запускает графический интерфейс
     */
    @Override
    public void start(Stage stage) {
        Parent root = viewer.getRoot();
        Scene scene = new Scene(root);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Запуск приложения javafx
     */
    public static void run(String args[]) {
        launch(args);
    }
}
