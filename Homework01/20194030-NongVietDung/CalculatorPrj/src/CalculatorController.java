import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel m, CalculatorView v) {
        model = m;
        view = v;
        initView();
        initController();
    }

    private void initView() {
        updateView();
    }

    private void updateView() {
        view.getResultField().setText(model.getResultDisplay());
        view.getOperationField().setText(model.getOperationDisplay());
    }

    private void initController() {
        bindButtons();

        view.addKeyListener(new CalculatorControllerKeyListener(this));
    }

    private void bindButtons() {
        view.getNum0Button().addActionListener(e -> pressNumberButton(0));
        view.getNum1Button().addActionListener(e -> pressNumberButton(1));
        view.getNum2Button().addActionListener(e -> pressNumberButton(2));
        view.getNum3Button().addActionListener(e -> pressNumberButton(3));
        view.getNum4Button().addActionListener(e -> pressNumberButton(4));
        view.getNum5Button().addActionListener(e -> pressNumberButton(5));
        view.getNum6Button().addActionListener(e -> pressNumberButton(6));
        view.getNum7Button().addActionListener(e -> pressNumberButton(7));
        view.getNum8Button().addActionListener(e -> pressNumberButton(8));
        view.getNum9Button().addActionListener(e -> pressNumberButton(9));
        view.getResetButton().addActionListener(e -> pressResetButton());
        view.getCleanButton().addActionListener(e -> pressCleanButton());
        view.getSignButton().addActionListener(e -> pressSignButton());
        view.getDivButton().addActionListener(e -> pressOperationButton('÷'));
        view.getMulButton().addActionListener(e -> pressOperationButton('×'));
        view.getSubButton().addActionListener(e -> pressOperationButton('-'));
        view.getAddButton().addActionListener(e -> pressOperationButton('+'));
        view.getEqualButton().addActionListener(e -> pressEqualButton());
        view.getDotButton().addActionListener(e -> pressDotButton());
    }

    private final class CalculatorControllerKeyListener implements KeyListener {

        private final CalculatorController controller;

        public CalculatorControllerKeyListener(CalculatorController c) {
            controller = c;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    controller.pressCleanButton();
                    break;
                case KeyEvent.VK_ENTER:
                    controller.pressEqualButton();
                    break;
            }
        }
    }

    private void pressNumberButton(int n) {
        model.insertNumber(n);
        updateView();
    }

    private void pressOperationButton(char op) {
        model.setOperation(op);
        updateView();
    }

    private void pressSignButton() {
        model.switchSign();
        updateView();
    }

    private void pressDotButton() {
        model.insertDot();
        updateView();
    }

    private void pressCleanButton() {
        model.clean();
        updateView();
    }

    private void pressResetButton() {
        model.reset();
        updateView();

    }

    private void pressEqualButton() {
        model.calculate();
        updateView();
    }
}
