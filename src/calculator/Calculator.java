package calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import calculator.controller.Controller;
import calculator.viewer.Viewer;
import calculator.model.Model;

public class Calculator extends Application {
    private Controller controller;
    private Viewer viewer;
    private Model model;

    public Calculator() {
        super();
        
        controller = Controller.getInstance();
        model = Model.getInstance();
        viewer = Viewer.getInstance();
    }

    @Override
    public void start(javafx.stage.Stage stage) {
        Parent root = viewer.getRoot();
        Scene scene = new Scene(root);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void run(String args[]) {
        launch(args);
    }
}
