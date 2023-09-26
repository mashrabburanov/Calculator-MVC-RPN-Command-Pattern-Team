import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

class Viewer {
    private final double BUTTON_DEFAULT_WIDTH = 60;
    private final double BUTTON_DEFAULT_HEIGHT = 20;
    private final double OFFSET_TOP = 5;
    private final double OFFSET_RIGHT = 10;
    private final double OFFSET_BOTTOM = 5;
    private final double OFFSET_LEFT = 10;
    private final double GRID_GAP = 5;

    private VBox        root;
    private TextField   textField;

    private Controller  controller;

    public Viewer() {
        controller = new Controller(this);
        root = (VBox) initializeRootPane();
    }

    public Parent getRoot() {
        return root;
    }

    public void updateTextField(String text) {
        textField.setText(text);
    }

    private Pane initializeRootPane() {
        VBox root = new VBox();
        textField = new TextField("0");
        GridPane grid = createButtonsGrid();
        Insets offsets = new Insets(OFFSET_TOP,
                                    OFFSET_RIGHT,
                                    OFFSET_BOTTOM,
                                    OFFSET_LEFT);

        textField.setEditable(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textField, grid);
        root.setMargin(textField, offsets);
        root.setMargin(grid, offsets);

        return root;
    }

    private GridPane createButtonsGrid() {
        GridPane grid = new GridPane();

        int row = 0;
        int column = 0;

        Button buttonPlus = new Button("+");
        Button buttonMinus = new Button("-");
        Button buttonStar = new Button("*");
        Button buttonSlash = new Button("/");

        buttonPlus.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonPlus.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonPlus.setOnAction(controller);

        buttonMinus.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonMinus.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonMinus.setOnAction(controller);

        buttonStar.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonStar.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonStar.setOnAction(controller);

        buttonSlash.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonSlash.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonSlash.setOnAction(controller);

        grid.add(buttonPlus, column++, row);
        grid.add(buttonMinus, column++, row);
        grid.add(buttonStar, column++, row);
        grid.add(buttonSlash, column, row);

        row = 1;
        column = 0;

        Button buttonDigit7 = new Button("7");
        Button buttonDigit8 = new Button("8");
        Button buttonDigit9 = new Button("9");
        Button buttonClearEntry = new Button("\u2190");

        buttonDigit7.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit7.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit7.setOnAction(controller);

        buttonDigit8.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit8.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit8.setOnAction(controller);

        buttonDigit9.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit9.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit9.setOnAction(controller);

        buttonClearEntry.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonClearEntry.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonClearEntry.setOnAction(controller);

        grid.add(buttonDigit7, column++, row);
        grid.add(buttonDigit8, column++, row);
        grid.add(buttonDigit9, column++, row);
        grid.add(buttonClearEntry, column, row);

        row = 2;
        column = 0;

        Button buttonDigit4 = new Button("4");
        Button buttonDigit5 = new Button("5");
        Button buttonDigit6 = new Button("6");
        Button buttonEqual = new Button("=");

        buttonDigit4.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit4.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit4.setOnAction(controller);

        buttonDigit5.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit5.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit5.setOnAction(controller);

        buttonDigit6.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit6.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit6.setOnAction(controller);

        buttonEqual.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonEqual.setMaxHeight(Double.MAX_VALUE);
        // buttonEqual.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonEqual.setOnAction(controller);

        grid.add(buttonDigit4, column++, row);
        grid.add(buttonDigit5, column++, row);
        grid.add(buttonDigit6, column++, row);
        grid.add(buttonEqual, column, row, 1, 3);

        row = 3;
        column = 0;

        Button buttonDigit1 = new Button("1");
        Button buttonDigit2 = new Button("2");
        Button buttonDigit3 = new Button("3");
        
        buttonDigit1.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit1.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit1.setOnAction(controller);

        buttonDigit2.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit2.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit2.setOnAction(controller);

        buttonDigit3.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit3.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit3.setOnAction(controller);

        grid.add(buttonDigit1, column++, row);
        grid.add(buttonDigit2, column++, row);
        grid.add(buttonDigit3, column++, row);

        row = 4;
        column = 1;

        Button buttonDigit0 = new Button("0");
        Button buttonDot = new Button(".");

        buttonDigit0.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDigit0.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDigit0.setOnAction(controller);

        buttonDot.setPrefWidth(BUTTON_DEFAULT_WIDTH);
        buttonDot.setPrefHeight(BUTTON_DEFAULT_HEIGHT);
        buttonDot.setOnAction(controller);

        grid.add(buttonDigit0, column++, row);
        grid.add(buttonDot, column++, row);

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
}
