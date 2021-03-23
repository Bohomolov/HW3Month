package calculator.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField firstInputField;
    private final JTextField operationField;
    private final JTextField secondInputField;
    private final String regEx = "^[0-9]*\\.?[0-9]*$";

    public ButtonListener(JTextField firstInputField, JTextField operationField, JTextField secondInputField) {
        this.firstInputField = firstInputField;
        this.operationField = operationField;
        this.secondInputField = secondInputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentInputValue = secondInputField.getText();
        String newString = currentInputValue.concat(e.getActionCommand());
        if (isOneDot(newString)) {
            secondInputField.setText(newString);
        } else {
            secondInputField.setText(currentInputValue);
        }
    }

    private boolean isOneDot(String stringForChek) {
        return stringForChek.matches(regEx);
    }

}
