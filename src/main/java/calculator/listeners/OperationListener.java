package calculator.listeners;

import calculator.blogic.Blogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationListener implements ActionListener {
    private final JTextField firstNumber;
    private final JTextField operation;
    private final JTextField secondNumber;
    private final Blogic blogic;

    public OperationListener(JTextField firstNumber, JTextField operation, JTextField secondNumber) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
        this.blogic = new Blogic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "+":
                operation.setText("+");
                resetTextFields();
                break;
            case "-":
                operation.setText("-");
                resetTextFields();
                break;
            case "*":
                operation.setText("*");
                resetTextFields();
                break;
            case "/":
                operation.setText("/");
                resetTextFields();
                break;
            case "=":
                choseOperationAndCalculate();
                break;
        }
    }


    private void cleanFieldAndSetAnswer(double answer) {
        firstNumber.setText("");
        operation.setText("");
        String answerStr = String.valueOf(answer);
        String afterDot = answerStr.substring(answerStr.lastIndexOf(".") + 1);
        if (afterDot.length() == 1 && afterDot.equals("0")) {
            secondNumber.setText(String.valueOf((int) answer));
        } else {
            secondNumber.setText(String.valueOf(answer));
        }
    }

    private void resetTextFields() {
        firstNumber.setText(secondNumber.getText());
        secondNumber.setText("");
    }

    private void printErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void choseOperationAndCalculate() {
        if (firstNumber.getText().equals(".")) {
            firstNumber.setText("");
            operation.setText("");
            secondNumber.setText("");
            return;
        }
        switch (operation.getText()) {
            case "+":
                cleanFieldAndSetAnswer(blogic.plus(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText())));
                break;
            case "-":
                cleanFieldAndSetAnswer(blogic.minus(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText())));
                break;
            case "*":
                cleanFieldAndSetAnswer(blogic.multiply(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText())));
                break;
            case "/":
                try {
                    cleanFieldAndSetAnswer(blogic.division(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText())));
                } catch (IllegalArgumentException e) {
                    firstNumber.setText("");
                    operation.setText("");
                    secondNumber.setText("");
                    printErrorMessage(e.getMessage());
                }
                break;
        }
    }
}
