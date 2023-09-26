import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    private Viewer viewer;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        viewer = new Viewer();
        Parent root = viewer.getRoot();
        Scene scene = new Scene(root);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}