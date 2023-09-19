package calculator.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class View {
    private final double WINDOW_MIN_WIDTH = 400;
    private final double WINDOW_MIN_HEIGHT = 500;

    private final double BUTTON_MAX_WIDTH = 200;
    private final double BUTTON_MAX_HEIGHT = 80;    
    private final double BUTTON_MIN_WIDTH = 50;
    private final double BUTTON_MIN_HEIGHT = 20;
    private final double BUTTON_PREF_WIDTH = 100;
    private final double BUTTON_PREF_HEIGHT = 40;

    private javafx.scene.layout.GridPane grid;
    private javafx.scene.layout.VBox root;
    private javafx.scene.Scene scene;
    private javafx.scene.control.Label label;
    private javafx.scene.control.TextField textField;
    private javafx.scene.control.Button buttonNum0;
    private javafx.scene.control.Button buttonNum1;
    private javafx.scene.control.Button buttonNum2;
    private javafx.scene.control.Button buttonNum3;
    private javafx.scene.control.Button buttonNum4;
    private javafx.scene.control.Button buttonNum5;
    private javafx.scene.control.Button buttonNum6;
    private javafx.scene.control.Button buttonNum7;
    private javafx.scene.control.Button buttonNum8;
    private javafx.scene.control.Button buttonNum9;
    private javafx.scene.control.Button buttonDot;
    private javafx.scene.control.Button buttonClearAll;
    private javafx.scene.control.Button buttonClearEntry;
    private javafx.scene.control.Button buttonPlus;
    private javafx.scene.control.Button buttonMinus;
    private javafx.scene.control.Button buttonStar;
    private javafx.scene.control.Button buttonSlash;
    private javafx.scene.control.Button buttonEqual;
    private javafx.scene.control.Button buttonLeftBracket;
    private javafx.scene.control.Button buttonRightBracket;
    private javafx.scene.control.Button buttonModulo;
    private javafx.scene.control.Button buttonPercent;
    private javafx.scene.control.Button buttonPowerOfTwo;

    public View() {}

    public void initialize(javafx.stage.Stage stage) {
        root = new javafx.scene.layout.VBox();
        grid = new javafx.scene.layout.GridPane();
        initializeComponents();
        addComponentsToGrid();
        root.getChildren().addAll(label, textField, grid);
        scene = new javafx.scene.Scene(root);
        stage.setTitle("Calculator");
        stage.setMinWidth(WINDOW_MIN_WIDTH);
        stage.setMinHeight(WINDOW_MIN_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    private void initializeComponents() {
        buttonNum0 = createButton("0");
        buttonNum1 = createButton("1");
        buttonNum2 = createButton("2");
        buttonNum3 = createButton("3");
        buttonNum4 = createButton("4");
        buttonNum5 = createButton("5");
        buttonNum6 = createButton("6");
        buttonNum7 = createButton("7");
        buttonNum8 = createButton("8");
        buttonNum9 = createButton("9");
        buttonDot = createButton(".");
        buttonClearAll = createButton("CA");
        buttonClearEntry = createButton("CE");
        buttonPlus = createButton("+");
        buttonMinus = createButton("-");
        buttonStar = createButton("*");
        buttonSlash = createButton("/");
        buttonEqual = createButton("=");
        buttonLeftBracket = createButton("(");
        buttonRightBracket = createButton(")");
        buttonModulo = createButton("mod");
        buttonPercent = createButton("%");
        buttonPowerOfTwo = createButton("^2");
        label = new javafx.scene.control.Label("temp");
        textField = new javafx.scene.control.TextField("0");
    }

    private javafx.scene.control.Button createButton(String buttonText) {
        return createButton(buttonText, 
                            BUTTON_MAX_WIDTH, 
                            BUTTON_MAX_HEIGHT,
                            BUTTON_MIN_WIDTH,
                            BUTTON_MIN_HEIGHT,
                            BUTTON_PREF_WIDTH,
                            BUTTON_PREF_HEIGHT);
    }
    
    private javafx.scene.control.Button createButton(String buttonText,
                                                     double buttonMaxWidth,
                                                     double buttonMaxHeight) {
        return createButton(buttonText, 
                            buttonMaxWidth, 
                            buttonMaxHeight,
                            BUTTON_MIN_WIDTH,
                            BUTTON_MIN_HEIGHT,
                            BUTTON_PREF_WIDTH,
                            BUTTON_PREF_HEIGHT);
    }
    
    private javafx.scene.control.Button createButton(String buttonText,
                                                     double buttonMaxWidth,
                                                     double buttonMaxHeight,
                                                     double buttonMinWidth,
                                                     double buttonMinHeight) {
        return createButton(buttonText, 
                            buttonMaxWidth, 
                            buttonMaxHeight,
                            buttonMinWidth,
                            buttonMinHeight,
                            BUTTON_PREF_WIDTH,
                            BUTTON_PREF_HEIGHT);
    }

    private javafx.scene.control.Button createButton(String buttonText,
                                                     double buttonMaxWidth,
                                                     double buttonMaxHeight,
                                                     double buttonMinWidth,
                                                     double buttonMinHeight,
                                                     double buttonPrefWidth,
                                                     double buttonPrefHeight) {
        javafx.scene.control.Button button = new javafx.scene.control.Button(buttonText);

        button.setMaxSize(buttonMaxWidth, buttonMaxHeight);
        button.setMinSize(buttonMinWidth, buttonMaxHeight);
        button.setPrefSize(buttonPrefWidth, buttonPrefHeight);

        return button;
    }

    private void addComponentsToGrid() {
        grid.add(buttonClearEntry, 0, 0);
        grid.add(buttonClearAll, 1, 0);
        grid.add(buttonLeftBracket, 2, 0);
        grid.add(buttonRightBracket, 3, 0);
        grid.add(buttonModulo, 4, 0);

        grid.add(buttonNum7, 0, 1);
        grid.add(buttonNum8, 1, 1);
        grid.add(buttonNum9, 2, 1);
        grid.add(buttonPlus, 3, 1);
        grid.add(buttonPowerOfTwo, 4, 1);

        grid.add(buttonNum4, 0, 2);
        grid.add(buttonNum5, 1, 2);
        grid.add(buttonNum6, 2, 2);
        grid.add(buttonMinus, 3, 2);
        grid.add(buttonEqual, 4, 2, 1, 3);

        grid.add(buttonNum1, 0, 3);
        grid.add(buttonNum2, 1, 3);
        grid.add(buttonNum3, 2, 3);
        grid.add(buttonStar, 3, 3);

        grid.add(buttonNum0, 0, 4);
        grid.add(buttonDot, 1, 4);
        grid.add(buttonPercent, 2, 4);
        grid.add(buttonSlash, 3, 4);
    }
}
