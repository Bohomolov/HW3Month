package calculator.listeners;

import calculator.blogic.Blogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationListener implements ActionListener {
    private final JTextField firstInputField;
    private final JTextField operationField;
    private final JTextField secondInputField;
    private final Blogic blogic;
    private final String error = "Error";

    public OperationListener(JTextField firstInputField, JTextField operationField, JTextField secondInputField) {
        this.firstInputField = firstInputField;
        this.operationField = operationField;
        this.secondInputField = secondInputField;
        this.blogic = new Blogic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "+":
                operationField.setText("+");
                swapFields();
                break;
            case "-":
                operationField.setText("-");
                swapFields();
                break;
            case "*":
                operationField.setText("*");
                swapFields();
                break;
            case "/":
                operationField.setText("/");
                swapFields();
                break;
            case "=":
                executeOperation();
                break;
        }
    }

    private void executeOperation() {
        if (firstInputField.getText().equals(".")) {
            firstInputField.setText("");
            operationField.setText("");
            secondInputField.setText("");
            return;
        }
        switch (operationField.getText()) {
            case "+":
                showResult(blogic.plus(Double.parseDouble(firstInputField.getText()), Double.parseDouble(secondInputField.getText())));
                break;
            case "-":
                showResult(blogic.minus(Double.parseDouble(firstInputField.getText()), Double.parseDouble(secondInputField.getText())));
                break;
            case "*":
                showResult(blogic.multiply(Double.parseDouble(firstInputField.getText()), Double.parseDouble(secondInputField.getText())));
                break;
            case "/":
                try {
                    showResult(blogic.division(Double.parseDouble(firstInputField.getText()), Double.parseDouble(secondInputField.getText())));
                } catch (IllegalArgumentException e) {
                    firstInputField.setText("");
                    operationField.setText("");
                    secondInputField.setText("");
                    showErrorMessage(e.getMessage());
                }
                break;
        }
    }

    private void swapFields() {
        firstInputField.setText(secondInputField.getText());
        secondInputField.setText("");
    }

    private void showResult(double answer) {
        firstInputField.setText("");
        operationField.setText("");
        String answerStr = String.valueOf(answer);
        String afterDot = answerStr.substring(answerStr.lastIndexOf(".") + 1);
        if (afterDot.length() == 1 && afterDot.equals("0")) {
            secondInputField.setText(String.valueOf((int) answer));
        } else {
            secondInputField.setText(String.valueOf(answer));
        }
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, error, JOptionPane.ERROR_MESSAGE);
    }
}
