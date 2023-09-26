import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label       label;
    private TextField   textField;

    private Controller  controller;

    public Viewer() {
        controller = new Controller(this);
        root = (VBox) initializeRootPane();
    }

    public Parent getRoot() {
        return root;
    }

    public TextField getTextField() {
        return textField;
    }

    public void updateTextField(String text) {
        textField.setText(text);
    }

    public Label getLabel() {
        return label;
    }

    public void updateLabel(String text) {
        label.setText(text);
    }

    private Pane initializeRootPane() {
        VBox root = new VBox();
        label = new Label("temp val");
        textField = new TextField("0");
        GridPane grid = createButtonsGrid();
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

    private GridPane createButtonsGrid() {
        GridPane grid = new GridPane();

        int row = 0;
        int column = 0;

        Button buttonClearEntry = createButton("\u2190");
        Button buttonOpeningParentheses = createButton("(");
        Button buttonClosingParentheses = createButton(")");
        Button buttonPlus = createButton("+");

        grid.add(buttonClearEntry, column++, row);
        grid.add(buttonOpeningParentheses, column++, row);
        grid.add(buttonClosingParentheses, column++, row);
        grid.add(buttonPlus, column, row);

        row = 1;
        column = 0;

        Button buttonDigit7 = createButton("7");
        Button buttonDigit8 = createButton("8");
        Button buttonDigit9 = createButton("9");
        Button buttonMinus = createButton("-");

        grid.add(buttonDigit7, column++, row);
        grid.add(buttonDigit8, column++, row);
        grid.add(buttonDigit9, column++, row);
        grid.add(buttonMinus, column, row);

        row = 2;
        column = 0;

        Button buttonDigit4 = createButton("4");
        Button buttonDigit5 = createButton("5");
        Button buttonDigit6 = createButton("6");
        Button buttonStar = createButton("*");

        grid.add(buttonDigit4, column++, row);
        grid.add(buttonDigit5, column++, row);
        grid.add(buttonDigit6, column++, row);
        grid.add(buttonStar, column, row);

        row = 3;
        column = 0;

        Button buttonDigit1 = createButton("1");
        Button buttonDigit2 = createButton("2");
        Button buttonDigit3 = createButton("3");
        Button buttonSlash = createButton("/");

        grid.add(buttonDigit1, column++, row);
        grid.add(buttonDigit2, column++, row);
        grid.add(buttonDigit3, column++, row);
        grid.add(buttonSlash, column, row);

        row = 4;
        column = 1;

        Button buttonDigit0 = createButton("0");
        Button buttonDot = createButton(".");
        Button buttonEqual = createButton("=");

        grid.add(buttonDigit0, column++, row);
        grid.add(buttonDot, column++, row);
        grid.add(buttonEqual, column, row);

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
}
