package calculator.model;

import calculator.viewer.Viewer;


public class Model {
    private Viewer viewer;
    private RPN rpn = new RPN();
    private String infixExpression;
    private double rpnResult;

    public Model() {}

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public String getInfixExpression() {
        return infixExpression;
    }

    public void setInfixExpression(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    public double getRPNResult() {
        return rpnResult;
    }

    public void setRPNResult(double rpnResult) {
        this.rpnResult = rpnResult;
    }
}
