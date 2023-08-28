package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui implements ActionListener {
    JFrame frame;
    JTextField textField;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButton = new JButton[11];

    Font myFont = new Font("serif", Font.BOLD, 30);

    double num1, num2, result;
    char operator;

    public Gui() {
        frame = new JFrame("Calculator");
        frame.setSize(500, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(70, 25, 350, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        operatorButton[0] = new JButton("+");
        operatorButton[1] = new JButton("-");
        operatorButton[2] = new JButton("*");
        operatorButton[3] = new JButton("/");
        operatorButton[4] = new JButton(".");
        operatorButton[5] = new JButton("=");
        operatorButton[6] = new JButton("Del");
        operatorButton[7] = new JButton("Clr");
        operatorButton[8] = new JButton("( - )");
        operatorButton[9] = new JButton("x!");
        operatorButton[10] = new JButton("√");


        for (int i = 0; i < 11; i++) {
            operatorButton[i].addActionListener(this);
            operatorButton[i].setFont(myFont);
            operatorButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        operatorButton[6].setBounds(320, 100, 120, 60);
        operatorButton[7].setBounds(50, 100, 120, 60);
        operatorButton[8].setBounds(60, 180, 90, 50);
        operatorButton[9].setBounds(200, 180, 90, 50);
        operatorButton[10].setBounds(340, 180, 90, 50);

        panel = new JPanel();
        panel.setBounds(45, 250, 400, 400);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
//        panel.setBackground(Color.);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operatorButton[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operatorButton[1]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operatorButton[2]);
        panel.add(operatorButton[4]);
        panel.add(numberButtons[0]);
        panel.add(operatorButton[5]);
        panel.add(operatorButton[3]);

        frame.add(panel);
        frame.add(operatorButton[6]);
        frame.add(operatorButton[7]);
        frame.add(operatorButton[8]);
        frame.add(operatorButton[9]);
        frame.add(operatorButton[10]);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tempOp;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == operatorButton[4]) { // Botao ponto
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == operatorButton[0]) { // Botao +
            try {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                tempOp = String.valueOf(num1);
                textField.setText(tempOp + " + ");
            } catch (Exception a) {
                return;
            }
        }

        if (e.getSource() == operatorButton[1]) { // Botao -
            try {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                tempOp = String.valueOf(num1);
                textField.setText(tempOp + " - ");
            } catch (Exception a) {
                return;
            }
        }

        if (e.getSource() == operatorButton[2]) { // Botao *
            try {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                tempOp = String.valueOf(num1);
                textField.setText(tempOp + " * ");
            } catch (Exception a) {
                return;
            }
        }

        if (e.getSource() == operatorButton[3]) { // Botao /
            try {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                tempOp = String.valueOf(num1);
                textField.setText(tempOp + " / ");
            } catch (Exception a) {
                return;
            }
        }

        if (e.getSource() == operatorButton[5]) { // Botao =
            int temp = textField.getText().indexOf("+", 1);

            if (temp == -1) {
                temp = textField.getText().indexOf("-", 1);
            }
            if (temp == -1) {
                temp = textField.getText().indexOf("*", 1);
            }
            if (temp == -1) {
                temp = textField.getText().indexOf("/", 1);
            }
            if (temp == -1) {
                return;
            }

            num1 = Double.parseDouble(textField.getText().substring(0, temp));
            num2 = Double.parseDouble(textField.getText().substring(temp + 1));

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == operatorButton[7]) { // Botao Clear
            textField.setText("");
        }

        if (e.getSource() == operatorButton[6]) { // Botao Deletar
            String nums = textField.getText();
            textField.setText("");

            for (int i = 0; i < nums.length() - 1; i++) {
                textField.setText(textField.getText() + nums.charAt(i));
            }
        }

        if (e.getSource() == operatorButton[8]) { // Inverter sinal
            try {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            } catch (Exception a) {
//                System.out.println(e);
            }
        }

        if (e.getSource() == operatorButton[9]) { // Fatorial
            double fat;
            double clientDB;

            try {
                clientDB = Double.parseDouble(textField.getText());
                fat = clientDB;

                for (int i = 1; i < clientDB; i++) {
                    fat = fat * (clientDB - i);
                }

            } catch (Exception a) {
                return;
            }
            textField.setText(String.valueOf(fat));
        }

        if (e.getSource() == operatorButton[10]) { // Raiz quadrada
            double input;
            float sqrt = 1f;
            float rootprox = 0;

            try {
                input = Double.parseDouble(textField.getText());
                while (rootprox < input) {
                    sqrt += 0.00001;
                    rootprox = sqrt * sqrt;
                }
            } catch (Exception a) {
                return;
            }
            textField.setText(String.valueOf(sqrt));
        }
    }
}
