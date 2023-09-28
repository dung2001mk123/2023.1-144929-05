public final class CalculatorApp {
    public static void main(String[] args) {
        new CalculatorController(new CalculatorModel(), new CalculatorView());
    }
}
