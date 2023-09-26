import javafx.event.EventHandler;
import javafx.event.ActionEvent;

class Controller implements EventHandler<ActionEvent> {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    @Override
    public void handle(ActionEvent event) {
        
    }
}
