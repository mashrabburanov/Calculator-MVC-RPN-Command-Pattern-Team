class Controler {
    private static Controler instance = null;
    private View view;
    private Model model;

    private Controler(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public static Controler instantiate(View view, Model model) {
        if (instance == null) {
            instance = new Controler(view, model);
        }
        return instance;
    }

    public void run() {}
}
