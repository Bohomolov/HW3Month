package calculator.view;

import calculator.listeners.ButtonListener;
import calculator.listeners.OperationListener;
import calculator.listeners.TextFieldListener;

import javax.swing.*;
import java.awt.*;

public class Gui{

    public Gui() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,44,123,114));

        JTextField firstNumber = new JTextField();
        firstNumber.setBounds(0, 0, 500, 80);
        firstNumber.setEditable(false);
        firstNumber.setBorder(null);
        firstNumber.setHorizontalAlignment(SwingConstants.RIGHT);


        JTextField operation = new JTextField();
        operation.setBounds(0, 80, 500, 80);
        operation.setEditable(false);
        operation.setBorder(null);
        operation.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField secondNumber = new JTextField();
        secondNumber.setBounds(0, 160, 500, 80);
        secondNumber.setEditable(false);
        secondNumber.setBorder(null);
        secondNumber.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton cleanBtn = new JButton("C");
        cleanBtn.setBounds(55, 260, 80, 80);

        JButton backspaceBtn = new JButton("Backspace");
        backspaceBtn.setBounds(155, 260, 180, 80);

        JButton divisionBtn = new JButton("/");
        divisionBtn.setBounds(355, 260, 80, 80);

        JButton oneBtn = new JButton("1");
        oneBtn.setBounds(55, 360, 80, 80);

        JButton twoBtn = new JButton("2");
        twoBtn.setBounds(155, 360, 80, 80);

        JButton threeBtn = new JButton("3");
        threeBtn.setBounds(255, 360, 80, 80);

        JButton plusBtn = new JButton("+");
        plusBtn.setBounds(355, 360, 80, 80);

        JButton fourBtn = new JButton("4");
        fourBtn.setBounds(55, 460, 80, 80);

        JButton fiveBtn = new JButton("5");
        fiveBtn.setBounds(155, 460, 80, 80);

        JButton sixBtn = new JButton("6");
        sixBtn.setBounds(255, 460, 80, 80);

        JButton minusBtn = new JButton("-");

        minusBtn.setBounds(355, 460, 80, 80);

        JButton sevenBtn = new JButton("7");
        sevenBtn.setBounds(55, 560, 80, 80);

        JButton eightBtn = new JButton("8");
        eightBtn.setBounds(155, 560, 80, 80);

        JButton nineBtn = new JButton("9");
        nineBtn.setBounds(255, 560, 80, 80);

        JButton multiplyBtn = new JButton("*");
        multiplyBtn.setBounds(355, 560, 80, 80);

        JButton enter = new JButton("=");
        enter.setBounds(55, 660, 180, 80);

        JButton zeroBtn = new JButton("0");
        zeroBtn.setBounds(255, 660, 80, 80);

        JButton dotBtn = new JButton(".");

        dotBtn.setBounds(355, 660, 80, 80);

        frame.add(firstNumber);
        frame.add(operation);
        frame.add(secondNumber);
        frame.add(cleanBtn);
        frame.add(backspaceBtn);
        frame.add(divisionBtn);
        frame.add(oneBtn);
        frame.add(twoBtn);
        frame.add(threeBtn);
        frame.add(plusBtn);
        frame.add(fourBtn);
        frame.add(fiveBtn);
        frame.add(sixBtn);
        frame.add(minusBtn);
        frame.add(sevenBtn);
        frame.add(eightBtn);
        frame.add(nineBtn);
        frame.add(multiplyBtn);
        frame.add(enter);
        frame.add(zeroBtn);
        frame.add(dotBtn);


        ButtonListener numsListener = new ButtonListener(firstNumber, operation, secondNumber);
        oneBtn.addActionListener(numsListener);
        twoBtn.addActionListener(numsListener);
        threeBtn.addActionListener(numsListener);
        fourBtn.addActionListener(numsListener);
        fiveBtn.addActionListener(numsListener);
        sixBtn.addActionListener(numsListener);
        sevenBtn.addActionListener(numsListener);
        eightBtn.addActionListener(numsListener);
        nineBtn.addActionListener(numsListener);
        zeroBtn.addActionListener(numsListener);
        dotBtn.addActionListener(numsListener);

        OperationListener operationListener = new OperationListener(firstNumber, operation, secondNumber);
        divisionBtn.addActionListener(operationListener);
        plusBtn.addActionListener(operationListener);
        minusBtn.addActionListener(operationListener);
        multiplyBtn.addActionListener(operationListener);
        enter.addActionListener(operationListener);

        TextFieldListener textFieldListener = new TextFieldListener(firstNumber, operation, secondNumber);
        cleanBtn.addActionListener(textFieldListener);
        backspaceBtn.addActionListener(textFieldListener);

        frame.setSize(507, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
