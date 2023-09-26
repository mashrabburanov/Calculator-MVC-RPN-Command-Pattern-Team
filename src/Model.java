import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

enum Token {
    NUMBER,
    PLUS_OPERATOR,
    MINUS_OPERATOR,
    STAR_OPERATOR,
    SLASH_OPERATOR,
    OPENING_PARENTHESES,
    CLOSING_PARENTHESES,
    END;
}

class Model {
    private Viewer viewer;
    private RPN rpn;
    private String infixExpression;
    private CharacterIterator it;
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

    private boolean isValidInfixExpression(String inifxExpression) {
        ArrayList<Token> tokensList = tokenizeExpression(infixExpression);
        Iterator<Token> it = tokensList.iterator();
        boolean result = false;

        Token currentToken = it.current();
        while (it.current() != END) {
            // TODO: validation here
        }

        return result;
    }

    private List<Token> tokenizeExpression(String infixExpression) {
        List<Token> tokensList = new ArrayList<>();
        CharacterIterator it = new StringCharacterIterator(infixExpression);

        char ch = it.current();
        while (ch != CharacterIterator.DONE) {            
            if (Character.isDigit(ch)) {
                tokensList.add(tokenizeNumber(it));
            } else if (isOperator(ch)) {
                tokensList.add(tokenizeOperator(ch));
                ch = it.next();
            } else if (ch == '(') {
                tokensList.add(Token.OPENING_PARENTHESES);
                ch = it.next();
            } else if (ch == ')') {
                tokensList.add(Token.CLOSING_PARENTHESES);
                ch = it.next();
            }

            ch = it.current();
        }

        tokensList.add(Token.END);

        return tokensList;
    }

    private Token tokenizeNumber(CharacterIterator it) {
        char ch = it.current();
        while (ch != CharacterIterator.DONE) {
            if (Character.isDigit(ch) || ch == '.') {
                ch = it.next();
                continue;
            } else {
                break;
            }
        }

        return Token.NUMBER;
    }

    private Token tokenizeOperator(char ch) {
        Token token = Token.PLUS_OPERATOR;
        
        if (ch == '+') {
            token = Token.PLUS_OPERATOR;
        } else if (ch == '-') {
            token = Token.MINUS_OPERATOR;
        } else if (ch == '*') {
            token = Token.STAR_OPERATOR;
        } else if (ch == '/') {
            token = Token.SLASH_OPERATOR;
        }
        
        return token;
    }

    private boolean isOperator(char ch) {
        String opeartors = "+-*/";

        if (opeartors.indexOf(ch) != -1) {
            return true;
        }

        return false;
    }
}
