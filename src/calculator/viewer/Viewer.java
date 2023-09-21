package calculator.viewer;

import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Viewer {
    private static Viewer INSTANCE = null;

    private final double BUTTON_DEFAULT_WIDTH = 60;
    private final double BUTTON_DEFAULT_HEIGHT = 20;
    private final double OFFSET_TOP = 5;
    private final double OFFSET_RIGHT = 10;
    private final double OFFSET_BOTTOM = 5;
    private final double OFFSET_LEFT = 10;
    private final double GRID_GAP = 5;
    
    // public static enum Buttons {
    //     ONE("1"),
    //     TWO("2"),
    //     THREE("3"),
    //     FOUR("4"),
    // }

    private VBox        root;
    private GridPane    grid;
    private Label       label;
    private TextField   textField;
    private Button      buttonNum0;
    private Button      buttonNum1;
    private Button      buttonNum2;
    private Button      buttonNum3;
    private Button      buttonNum4;
    private Button      buttonNum5;
    private Button      buttonNum6;
    private Button      buttonNum7;
    private Button      buttonNum8;
    private Button      buttonNum9;
    private Button      buttonDot;
    private Button      buttonClearAll;
    private Button      buttonClearEntry;
    private Button      buttonPlus;
    private Button      buttonMinus;
    private Button      buttonStar;
    private Button      buttonSlash;
    private Button      buttonEqual;
    private Button      buttonLeftBracket;
    private Button      buttonRightBracket;
    private Button      buttonModulo;
    private Button      buttonPercent;
    private Button      buttonPowerOfTwo;

    private Viewer() {
        root = (VBox) initializeRootPane();
    }

    public static Viewer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Viewer();
        }

        return INSTANCE;
    }

    public Parent getRoot() {
        return root;
    }

    // public Button getButton(String buttonLabel) {
    //     switch buttonLabel {
    //     case :
    //         return 
    //         breack;
    //     }
    // }

    private Pane initializeRootPane() {
        VBox root = new VBox();        
        label = new Label("temp val");
        textField = new TextField("0");
        grid = initializeButtonsGrid();
        Insets offsets = new Insets(OFFSET_TOP,
                             OFFSET_RIGHT,
                             OFFSET_BOTTOM,
                             OFFSET_LEFT);

        textField.setEditable(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, textField, grid);
        root.setMargin(label, offsets);
        root.setMargin(textField, offsets);
        root.setMargin(grid, offsets);

        return root;
    }

    private GridPane initializeButtonsGrid() {
        GridPane grid = new GridPane();
        createButtons();
        addButtonsToGrid(grid);
        Insets offsets = new Insets(OFFSET_TOP,
                                   OFFSET_RIGHT,
                                   OFFSET_BOTTOM,
                                   OFFSET_LEFT);

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(offsets);
        grid.setVgap(GRID_GAP);
        grid.setHgap(GRID_GAP);

        return grid;
    }

    private void createButtons() {
        double equalButtonHeight;

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
        buttonLeftBracket = createButton("(");
        buttonRightBracket = createButton(")");
        buttonModulo = createButton("mod");
        buttonPercent = createButton("%");
        buttonPowerOfTwo = createButton("^2");

        equalButtonHeight = (BUTTON_DEFAULT_HEIGHT * 3) + (GRID_GAP * 3) + 20;

        buttonEqual = createButton("=", BUTTON_DEFAULT_WIDTH, equalButtonHeight);
    }

    private Button createButton(String label) {
        return createButton(label, BUTTON_DEFAULT_WIDTH, BUTTON_DEFAULT_HEIGHT);
    }

    private Button createButton(String label,
                                double preferableWidth,
                                double preferableHeight) {
        Button b = new Button(label);

        b.setPrefWidth(preferableWidth);
        b.setPrefHeight(preferableHeight);

        return b;
    }

    private void addButtonsToGrid(GridPane grid) {
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
