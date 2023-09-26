class Model {
    private Viewer viewer;
    private RPN rpn;
    private String infixExpression;
    private double rpnResult;
    private String stringForUser;
    private String tmp;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        rpn = new RPN();
        infixExpression = "";
        stringForUser = "";
        tmp = "";
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

    public void validationAndGetInfixExpr(String buttonText) {
        if (buttonText.equals("0")) {
            if (stringForUser.equals("0")) {
                return;
            } else {
                stringForUser = stringForUser + buttonText;
                tmp = stringForUser;
            }
        } else if (buttonText.matches("[1-9]") && !(stringForUser.startsWith("0") && !stringForUser.contains("."))) {
            stringForUser += buttonText;
            tmp = stringForUser;
        } else if (buttonText.equals("\u2190")) {
            stringForUser = "";
            infixExpression = "";
        } else if (buttonText.equals(".")) {
            if (!stringForUser.equals("") && !stringForUser.contains(".") && !stringForUser.endsWith("+") &&
                    !stringForUser.endsWith("-") && !stringForUser.endsWith("*") && !stringForUser.endsWith("/")) {
                stringForUser = stringForUser + buttonText;
                tmp = stringForUser;
            }
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            if (!(stringForUser.endsWith("+") || stringForUser.endsWith("-") || stringForUser.endsWith("*") || stringForUser.endsWith("/"))) {
                if (!stringForUser.equals("") && !stringForUser.endsWith(".")) {
                    infixExpression = infixExpression + stringForUser + buttonText;
                    stringForUser = "";
                    return;
                }
            }
        } else if (buttonText.equals("=")) {
            infixExpression = infixExpression + stringForUser;
            System.out.println("Infix Expression: " + infixExpression);
            //String resultFromRPN =  rpn.convertInfixToPostfixExpr(infixExpression);
            viewer.updateTextField("resultFromRPN");
            stringForUser = "";
            infixExpression = "";
            return;
        }
        viewer.updateTextField(stringForUser);
    }
}
