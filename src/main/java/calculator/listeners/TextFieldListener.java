package calculator.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener implements ActionListener {
    private final JTextField firstNumber;
    private final JTextField operation;
    private final JTextField secondNumber;
    private final String clear = "C";

    public TextFieldListener(JTextField firstNumber, JTextField operation, JTextField secondNumber) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(clear)) {
            firstNumber.setText("");
            operation.setText("");
            secondNumber.setText("");
        } else {
            secondNumber.setText(secondNumber.getText().substring(0, secondNumber.getText().length() - 1));
        }
    }
}
