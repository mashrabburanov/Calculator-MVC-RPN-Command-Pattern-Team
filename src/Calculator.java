public class Calculator {
    public static void main(String args[]) {
        Controler controler = Controler.instantiate(View.instantiate(),
                                                    Model.instantiate());

        controler.run();
    }
}
