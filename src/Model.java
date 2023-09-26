class Model {
    private Viewer viewer;
    private RPN rpn;
    private String infixExpression;
    private double rpnResult;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        rpn = new RPN();
        infixExpression = "";
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
