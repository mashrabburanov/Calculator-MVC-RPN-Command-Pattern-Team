package calculator.viewer;

/**
 * Импор всех необходимых элементов
 */
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Синглтон вьювера
 */
public class Viewer {
    private static Viewer INSTANCE = null;

    /**
     * Константы для размера кнопок, для промежутков между
     * vBox и GridPane и для промежутков в гриде (сетке)
     */
    private final double BUTTON_DEFAULT_WIDTH = 60;
    private final double BUTTON_DEFAULT_HEIGHT = 20;
    private final double OFFSET_TOP = 5;
    private final double OFFSET_RIGHT = 10;
    private final double OFFSET_BOTTOM = 5;
    private final double OFFSET_LEFT = 10;
    private final double GRID_GAP = 5;

    /**
     * VBox - контейнер, который при добавлении элементов
     * располагает их в ряд сверху вниз, является корневым.
     * 
     * GridPane - контейнер для элементов, который распологает
     * элементы в сетку. Координаты для расположения объектов 
     * формируют данную сетку.
     * 
     * Также лэйбл - предполагается что внем будет отображаться
     * предыдущее выражение, текстовое поле - здесь будет 
     * отображаться текущее выражение и кнопки
     * 
     * Если найдется более красивый или удобный способ отображение 
     * текстовое поле и лэйбл можем поменять.
     */
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
    private Button      buttonOpeningBracket;
    private Button      buttonClosingBracket;
    private Button      buttonModulo;
    private Button      buttonPercent;
    private Button      buttonPowerOfTwo;

    /**
     * В данном классе происходит много инициализаций, поэтому
     * я разделил процесс инициализация всех элементов и контейнеров
     * в разные методы вызываемые из конструктора и не доступные
     * пользователю класса
     */
    private Viewer() {
        root = (VBox) initializeRootPane();
    }

    public static Viewer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Viewer();
        }

        return INSTANCE;
    }

    /**
     * Возвращает корневой узел в для помещения его
     * на stage в классе Calculator
     */
    public Parent getRoot() {
        return root;
    }

    /**
     * Пользователь может получить ссылки на объекты
     * кнопок класса вьювер. в качестве аргумента
     * используется  enum в котором определены все 
     * используемые кнопки.
     * 
     * Прим. вызова:
     * Button b = viewerObj.getButtons(Buttons.TWO);
     */
    public Button getButton(Buttons button) {
        switch (button) {
        case ZERO:
            return buttonNum0;
        case ONE:
            return buttonNum1;
        case TWO:
            return buttonNum2;
        case THREE:
            return buttonNum3;
        case FOUR:
            return buttonNum4;
        case FIVE:
            return buttonNum5;
        case SIX:
            return buttonNum6;
        case SEVEN:
            return buttonNum7;
        case EIGHT:
            return buttonNum8;
        case NINE:
            return buttonNum9;
        case DOT:
            return buttonDot;
        case CLEAR_ALL:
            return buttonClearAll;
        case CLEAR_ENTRY:
            return buttonClearEntry;
        case PLUS:
            return buttonPlus;
        case MINUS:
            return buttonMinus;
        case STAR:
            return buttonStar;
        case SLASH:
            return buttonSlash;
        case EQUAL:
            return buttonEqual;
        case OPENING_BRACKET:
            return buttonOpeningBracket;
        case CLOSING_BRACKET:
            return buttonClosingBracket;
        case MODULO:
            return buttonModulo;
        case PERCENT:
            return buttonPercent;
        case POWER_OF_TWO:
            return buttonPowerOfTwo;
        default:
            System.out.println("Log: error: No such button");
            return null;
        }
    }

    /**
     * Возвращает ссылку на текстовое поле калькулятора
     */
    public TextField getTextField() {
        return textField;
    }

    /**
     * Возвращает ссылку на лэйбл
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Инициализируется и возвращается корневой узел.
     * 
     * В качестве возвращаемого значения используется класс Pane
     * он является базовым для VBox, HBox, GridPane и других
     * лэйаутов (layouts)
     */
    private Pane initializeRootPane() {
        VBox root = new VBox();        // корневой VBox
        label = new Label("temp val"); // Инициализирован лэйбл
        textField = new TextField("0");//Инициализирован текстфилд
        grid = initializeButtonsGrid(); //Здесь происходит инициализация сетки (грида) и кнопок
        Insets offsets = new Insets(OFFSET_TOP,         // Здесь устанавливается растояние от
                                    OFFSET_RIGHT,       // которого смещаются лэйбл, текстфилд
                                    OFFSET_BOTTOM,      // и грид с кнопками (грид как одна сущьность)
                                    OFFSET_LEFT);

        textField.setEditable(false);
        root.setAlignment(Pos.CENTER);  // В центре
        root.getChildren().addAll(label, textField, grid); //добавляем к корню элементы и контейнер
        root.setMargin(label, offsets);     // и используем класс оффсет для установки растояний 
        root.setMargin(textField, offsets);
        root.setMargin(grid, offsets);

        return root;
    }

    /**
     * В этом методе происходит инициализация грида.
     * Кнопки инициализируются в createButtons а добавляются к
     * гриду при помощи addButtonsToGrid(Grid grid)
     */
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
        grid.setVgap(GRID_GAP); // пространство между кнопками по вертикали
        grid.setHgap(GRID_GAP); // по горизонтали

        return grid;
    }

    /**
     * Иниуиализируются кнопки при помощи внутреннего метода createButton
     * 
     * Для всех кнопок используются константы указанные в начале
     * а для кнопки "=" исполльзуется вычисляемое значение 
     */
    private void createButtons() {
        double equalButtonHeight = (BUTTON_DEFAULT_HEIGHT * 3) 
                                   + (GRID_GAP * 3) 
                                   + 20;

        buttonNum0 = createButton(Buttons.ZERO.getLabel());
        buttonNum1 = createButton(Buttons.ONE.getLabel());
        buttonNum2 = createButton(Buttons.TWO.getLabel());
        buttonNum3 = createButton(Buttons.THREE.getLabel());
        buttonNum4 = createButton(Buttons.FOUR.getLabel());
        buttonNum5 = createButton(Buttons.FIVE.getLabel());
        buttonNum6 = createButton(Buttons.SIX.getLabel());
        buttonNum7 = createButton(Buttons.SEVEN.getLabel());
        buttonNum8 = createButton(Buttons.EIGHT.getLabel());
        buttonNum9 = createButton(Buttons.NINE.getLabel());
        buttonDot = createButton(Buttons.DOT.getLabel());
        buttonClearAll = createButton(Buttons.CLEAR_ALL.getLabel());
        buttonClearEntry = createButton(Buttons.CLEAR_ENTRY.getLabel());
        buttonPlus = createButton(Buttons.PLUS.getLabel());
        buttonMinus = createButton(Buttons.MINUS.getLabel());
        buttonStar = createButton(Buttons.STAR.getLabel());
        buttonSlash = createButton(Buttons.SLASH.getLabel());
        buttonOpeningBracket = createButton(Buttons.OPENING_BRACKET.getLabel());
        buttonClosingBracket = createButton(Buttons.CLOSING_BRACKET.getLabel());
        buttonModulo = createButton(Buttons.MODULO.getLabel());
        buttonPercent = createButton(Buttons.PERCENT.getLabel());
        buttonPowerOfTwo = createButton(Buttons.POWER_OF_TWO.getLabel());
        buttonEqual = createButton(Buttons.EQUAL.getLabel(), 
                                   BUTTON_DEFAULT_WIDTH, 
                                   equalButtonHeight);
    }

    /**
     * Вызывает метод createButton и передает ему помимо названия из аргумента
     * дефолтные размеры.
     */
    private Button createButton(String label) {
        return createButton(label, BUTTON_DEFAULT_WIDTH, BUTTON_DEFAULT_HEIGHT);
    }

    /**
     * Создает кнопку из: названия и размеров.
     */
    private Button createButton(String label,
                                double preferableWidth,
                                double preferableHeight) {
        Button b = new Button(label);

        b.setPrefWidth(preferableWidth);
        b.setPrefHeight(preferableHeight);

        return b;
    }

    /**
     * кнопки добавляются к объекту-контейнеру грид
     * 
     * методы add объекта грид:
     * add(Button, x, y);
     * add(Button, x, y, xSpan, ySpan); - Span это то сколько элемент
     * (в данном случае кнопка будет занимать строк или столбцов на сетке)
     * 
     * Количество строк и столбцов получается динамически из указанных аргументов
     */
    private void addButtonsToGrid(GridPane grid) {
        grid.add(buttonClearEntry, 0, 0);
        grid.add(buttonClearAll, 1, 0);
        grid.add(buttonOpeningBracket, 2, 0);
        grid.add(buttonClosingBracket, 3, 0);
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
