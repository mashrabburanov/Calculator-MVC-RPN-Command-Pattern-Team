package calculator.model;

public class Model {
    private String infixExpression;
    private double rpnResult;
    private RPN rpn = new RPN();

    public Model() {}

    public String getInfixExpression() {
        return this.infixExpression;
    }

    public void setInfixExpression(String newInfixExpression) {
        this.infixExpression = newInfixExpression;
    }

    public double getRPNResult() {
        return this.rpnResult;
    }

    public void setRPNResult(double newResult) {
        this.rpnResult = newResult;
    }
}
