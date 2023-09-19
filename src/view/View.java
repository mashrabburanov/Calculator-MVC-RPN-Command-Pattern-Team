class View {
    private static View instance = null;

    private final int WIDTH = 400;
    private final int HEIGHT = 500;

    private View() {}

    public static View instantiate() {
        if (instance == null) {
            instance = new View();
        }
        return instance;
    }

    public void initialize() {
        
    }
}
