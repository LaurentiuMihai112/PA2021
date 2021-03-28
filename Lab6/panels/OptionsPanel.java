package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OptionsPanel extends JPanel {
    protected final MainFrame frame;
    private JButton squareButton = new JButton(" Square ");
    private JButton circleButton = new JButton("  Circle  ");
    private JButton triangleButton = new JButton("Triangle");

    private JButton redButton = new JButton(" ");
    private JButton yellowButton = new JButton(" ");
    private JButton greenButton = new JButton(" ");
    private JButton blueButton = new JButton(" ");
    private JButton orangeButton = new JButton(" ");
    private JButton cyanButton = new JButton(" ");
    private JButton blackButton = new JButton(" ");
    private JButton grayButton = new JButton(" ");
    private JButton whiteButton = new JButton(" ");
    private JButton pinkButton = new JButton(" ");

    public OptionsPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //shapes buttons
        squareButton.addActionListener(this::square);
        triangleButton.addActionListener(this::triangle);
        circleButton.addActionListener(this::circle);
        //color buttons
        redButton.addActionListener(this::colorRed);
        yellowButton.addActionListener(this::colorYellow);
        greenButton.addActionListener(this::colorGreen);
        blueButton.addActionListener(this::colorBlue);
        orangeButton.addActionListener(this::colorOrange);
        cyanButton.addActionListener(this::colorCyan);
        blackButton.addActionListener(this::colorBlack);
        grayButton.addActionListener(this::colorDarkGrey);
        whiteButton.addActionListener(this::colorWhite);
        pinkButton.addActionListener(this::colorPink);

        add(Box.createRigidArea(new Dimension(0, 6)));
        add(squareButton);
        add(Box.createRigidArea(new Dimension(0, 6)));
        add(triangleButton);
        add(Box.createRigidArea(new Dimension(0, 6)));
        add(circleButton);
        add(Box.createRigidArea(new Dimension(0, 6)));

        redButton.setBackground(Color.red);
        yellowButton.setBackground(Color.yellow);
        orangeButton.setBackground(Color.orange);
        greenButton.setBackground(Color.green);
        blueButton.setBackground(Color.blue);
        cyanButton.setBackground(Color.cyan);
        blackButton.setBackground(Color.black);
        grayButton.setBackground(Color.darkGray);
        whiteButton.setBackground(Color.white);
        pinkButton.setBackground(Color.pink);

        add(redButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(yellowButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(orangeButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(greenButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(blueButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(cyanButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(pinkButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(whiteButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(grayButton);
        add(Box.createRigidArea(new Dimension(0, 1)));
        add(blackButton);

    }

    private void triangle(ActionEvent e) {
        frame.configPanel.getSidesField().setValue(3);
    }

    private void circle(ActionEvent e) {
        frame.configPanel.getSidesField().setValue(500);
    }

    private void square(ActionEvent e) {
        frame.configPanel.getSidesField().setValue(4);
    }

    private void colorRed(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(0));
    }

    private void colorYellow(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(1));

    }

    private void colorOrange(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(2));

    }

    private void colorGreen(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(3));

    }

    private void colorBlue(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(4));

    }

    private void colorBlack(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(5));

    }

    private void colorDarkGrey(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(6));

    }

    private void colorPink(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(7));

    }

    private void colorCyan(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(8));

    }

    private void colorWhite(ActionEvent e) {
        frame.configPanel.getColorCombo().setSelectedItem(frame.configPanel.getColorCombo().getItemAt(9));

    }


}
