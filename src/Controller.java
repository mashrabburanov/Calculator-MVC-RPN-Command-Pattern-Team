import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

class Controller implements EventHandler<ActionEvent> {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        model.validationAndGetInfixExpr(buttonText);
    }
}
