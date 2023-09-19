class Model {
    private static Model instance = null;

    private String infixExpression;
    private double rpnResult;
    private RPN rpn = new RPN();

    private Model() {}

    public static Model instantiate() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

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
