package calculator.model;

import calculator.viewer.Viewer;

public class Model {
    private static Model INSTANCE = null;

    private Viewer viewer;
    private RPN rpn = new RPN();
    private String infixExpression;
    private double rpnResult;

    private Model() {
        viewer = Viewer.getInstance();
    }

    public static Model getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Model();
        }

        return INSTANCE;
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
