package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OptionsPanel extends JPanel {
    protected final MainFrame frame;
    private final JButton squareButton = new JButton(" Square ");
    private final JButton circleButton = new JButton("  Circle  ");
    private final JButton triangleButton = new JButton("Triangle");

    JButton redButton = new JButton(" ");
    JButton yellowButton = new JButton(" ");
    JButton greenButton = new JButton(" ");
    JButton blueButton = new JButton(" ");
    JButton orangeButton = new JButton(" ");
    JButton cyanButton = new JButton(" ");
    JButton blackButton = new JButton(" ");
    JButton grayButton = new JButton(" ");
    JButton whiteButton = new JButton(" ");
    JButton pinkButton = new JButton(" ");

    public OptionsPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        squareButton.addActionListener(this::square);
        triangleButton.addActionListener(this::triangle);
        circleButton.addActionListener(this::circle);
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
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(0));
    }

    private void colorYellow(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(1));

    }

    private void colorOrange(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(2));

    }

    private void colorGreen(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(3));

    }

    private void colorBlue(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(4));

    }

    private void colorBlack(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(5));

    }

    private void colorDarkGrey(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(6));

    }

    private void colorPink(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(7));

    }

    private void colorCyan(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(8));

    }

    private void colorWhite(ActionEvent e) {
        frame.configPanel.colorCombo.setSelectedItem(frame.configPanel.colorCombo.getItemAt(9));

    }


}
