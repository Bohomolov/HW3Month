package calculator.view;

import calculator.listeners.ButtonListener;
import calculator.listeners.OperationListener;
import calculator.listeners.TextFieldListener;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private final JFrame frame = new JFrame("Calculator");
    private final Color backgroundColor = new Color(2, 200, 150, 100);

    private final JTextField firstInputField = new JTextField();
    private final JTextField operationField = new JTextField();
    private final JTextField secondInputField = new JTextField();

    private final JButton oneNumber = new JButton("1");
    private final JButton twoNumber = new JButton("2");
    private final JButton threeNumber = new JButton("3");
    private final JButton fourNumber = new JButton("4");
    private final JButton fiveNumber = new JButton("5");
    private final JButton sixNumber = new JButton("6");
    private final JButton sevenNumber = new JButton("7");
    private final JButton eightNumber = new JButton("8");
    private final JButton nineNumber = new JButton("9");
    private final JButton zeroNumber = new JButton("0");

    private final JButton backspaceButton = new JButton("Backspace");
    private final JButton plusButton = new JButton("+");
    private final JButton cleanButton = new JButton("C");
    private final JButton divisionButton = new JButton("/");
    private final JButton minusButton = new JButton("-");
    private final JButton multiplyButton = new JButton("*");
    private final JButton enterButton = new JButton("=");
    private final JButton dotButton = new JButton(".");

    private final ButtonListener numbersListener = new ButtonListener(firstInputField, operationField, secondInputField);
    private final OperationListener operationListener = new OperationListener(firstInputField, operationField, secondInputField);
    private final TextFieldListener inputListener = new TextFieldListener(firstInputField, operationField, secondInputField);

    public Gui() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(backgroundColor);

        firstInputField.setBounds(0, 0, 500, 80);
        firstInputField.setEditable(false);
        firstInputField.setBorder(null);
        firstInputField.setHorizontalAlignment(SwingConstants.RIGHT);

        operationField.setBounds(0, 80, 500, 80);
        operationField.setEditable(false);
        operationField.setBorder(null);
        operationField.setHorizontalAlignment(SwingConstants.RIGHT);

        secondInputField.setBounds(0, 160, 500, 80);
        secondInputField.setEditable(false);
        secondInputField.setBorder(null);
        secondInputField.setHorizontalAlignment(SwingConstants.RIGHT);

        oneNumber.setBounds(55, 360, 80, 80);
        twoNumber.setBounds(155, 360, 80, 80);
        threeNumber.setBounds(255, 360, 80, 80);
        fourNumber.setBounds(55, 460, 80, 80);
        fiveNumber.setBounds(155, 460, 80, 80);
        sixNumber.setBounds(255, 460, 80, 80);
        minusButton.setBounds(355, 460, 80, 80);
        sevenNumber.setBounds(55, 560, 80, 80);
        eightNumber.setBounds(155, 560, 80, 80);
        nineNumber.setBounds(255, 560, 80, 80);
        zeroNumber.setBounds(255, 660, 80, 80);

        enterButton.setBounds(55, 660, 180, 80);
        cleanButton.setBounds(55, 260, 80, 80);
        backspaceButton.setBounds(155, 260, 180, 80);
        divisionButton.setBounds(355, 260, 80, 80);
        plusButton.setBounds(355, 360, 80, 80);
        multiplyButton.setBounds(355, 560, 80, 80);
        dotButton.setBounds(355, 660, 80, 80);

        frame.add(firstInputField);
        frame.add(operationField);
        frame.add(secondInputField);

        frame.add(oneNumber);
        frame.add(twoNumber);
        frame.add(threeNumber);
        frame.add(fourNumber);
        frame.add(fiveNumber);
        frame.add(sixNumber);
        frame.add(sevenNumber);
        frame.add(eightNumber);
        frame.add(nineNumber);
        frame.add(zeroNumber);

        frame.add(plusButton);
        frame.add(cleanButton);
        frame.add(minusButton);
        frame.add(backspaceButton);
        frame.add(divisionButton);
        frame.add(multiplyButton);
        frame.add(enterButton);
        frame.add(dotButton);

        oneNumber.addActionListener(numbersListener);
        twoNumber.addActionListener(numbersListener);
        threeNumber.addActionListener(numbersListener);
        fourNumber.addActionListener(numbersListener);
        fiveNumber.addActionListener(numbersListener);
        sixNumber.addActionListener(numbersListener);
        sevenNumber.addActionListener(numbersListener);
        eightNumber.addActionListener(numbersListener);
        nineNumber.addActionListener(numbersListener);
        zeroNumber.addActionListener(numbersListener);
        dotButton.addActionListener(numbersListener);

        divisionButton.addActionListener(operationListener);
        plusButton.addActionListener(operationListener);
        minusButton.addActionListener(operationListener);
        multiplyButton.addActionListener(operationListener);
        enterButton.addActionListener(operationListener);

        cleanButton.addActionListener(inputListener);
        backspaceButton.addActionListener(inputListener);

        frame.setSize(507, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
