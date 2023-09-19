package calculator.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {
    private final int WIDTH = 400;
    private final int HEIGHT = 500;

    private javafx.scene.Group root;
    private javafx.scene.Scene scene;

    public View() {}

    public void initialize(javafx.stage.Stage stage) {
        root = new javafx.scene.Group();
	scene = new javafx.scene.Scene(root, WIDTH, HEIGHT);
	stage.setScene(scene);
	stage.show();
    }
}
