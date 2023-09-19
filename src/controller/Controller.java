package calculator.controller;

import javafx.application.Application;
import javafx.stage.Stage;

import calculator.view.View;
import calculator.model.Model;

public class Controller extends javafx.application.Application {
    private View view;
    private Model model;

    public Controller() {
        super();
	this.view = new calculator.view.View();
	this.model = new calculator.model.Model();
    }

    public void run(String args[]) {
	this.launch(args);
    }

    @Override
    public void start(javafx.stage.Stage stage) {
	view.initialize(stage);	
    }
}
