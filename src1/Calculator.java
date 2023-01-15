import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel buttons;
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public Calculator() {
        // create the display
        display = new JTextField("0");
        display.setEnabled(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // create the buttons
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(4, 4));
        String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttons.add(button);
        }
        add(buttons, BorderLayout.CENTER);

        // set up the frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9.]")) {
            if (calculating) {
                display.setText(command);
                calculating = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else {
            if (calculating) {
                if (command.equals("-")) {
                    display.setText(command);
                    calculating = false;
                } else {
                    operator = command;
                }
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = command;
                calculating = true;
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+")) {
            result += n;
        } else if (operator.equals("-")) {
            result -= n;
        } else if (operator.equals("*")) {
            result *= n;
        } else if (operator.equals("/")) {
            result /= n;
        } else if (operator.equals("=")) {
            result = n;
        }
        display.setText("" + result);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
