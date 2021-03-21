package calculator.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField firstNumber;
    private final JTextField operation;
    private final JTextField secondNumber;

    public ButtonListener(JTextField firstNumber , JTextField operation, JTextField secondNumber) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textInFieldNow = secondNumber.getText();
        String setString = textInFieldNow.concat(e.getActionCommand());
        if (chekJustOneDot(setString)) {
            secondNumber.setText(setString);
        } else {
            secondNumber.setText(textInFieldNow);
        }
    }

    private boolean chekJustOneDot(String stringForChek) {
        return stringForChek.matches("^[0-9]*\\.?[0-9]*$");
    }

}
