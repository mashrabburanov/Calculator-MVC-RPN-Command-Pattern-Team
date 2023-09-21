package calculator.controller;

import calculator.viewer.Viewer;
import calculator.model.Model;

/**
 * Синглтон контроллера
 */
public class Controller {
    private static Controller INSTANCE = null;

    private Viewer viewer;
    private Model model;

    private Controller() {
        viewer = Viewer.getInstance();
        model = Model.getInstance();
    }

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }

        return INSTANCE;
    }
    
}
