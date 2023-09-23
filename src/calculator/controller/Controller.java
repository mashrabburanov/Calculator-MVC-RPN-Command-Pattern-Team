package calculator.controller;

import calculator.viewer.Viewer;
import calculator.model.Model;


public class Controller {
    private Viewer viewer;
    private Model model;

    public Controller() {}

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }
   
    public Viewer getViewer() {
        return viewer;
    }
}
