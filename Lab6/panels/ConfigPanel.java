package panels;

import other.ComboItem;

import javax.swing.*;
import java.awt.*;


public class ConfigPanel extends JPanel {
    private JSpinner sidesField;
    private JSpinner strokeField;
    private JSpinner radiusField;
    private JComboBox<ComboItem> colorCombo;

    public ConfigPanel() {
        init();
    }

    public JSpinner getRadiusField() {
        return radiusField;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JSpinner getStrokeField() {
        return strokeField;
    }

    public JComboBox<ComboItem> getColorCombo() {
        return colorCombo;
    }

    private void init() {

        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesLabel.setForeground(Color.BLACK);
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        JLabel radiusLabel = new JLabel("Radius:");
        radiusLabel.setForeground(Color.BLACK);
        radiusField = new JSpinner(new SpinnerNumberModel(50, 1, 500, 1));
        JLabel strokeLabel = new JLabel("Stroke:");
        strokeLabel.setForeground(Color.BLACK);
        strokeField = new JSpinner(new SpinnerNumberModel(1, 0, 30, 1));

        colorCombo = new JComboBox<>();
        colorCombo.addItem(new ComboItem("Red", Color.RED));
        colorCombo.addItem(new ComboItem("Yellow", Color.YELLOW));
        colorCombo.addItem(new ComboItem("Orange", Color.ORANGE));
        colorCombo.addItem(new ComboItem("Green", Color.GREEN));
        colorCombo.addItem(new ComboItem("Blue", Color.BLUE));
        colorCombo.addItem(new ComboItem("Black", Color.BLACK));
        colorCombo.addItem(new ComboItem("Grey", Color.DARK_GRAY));
        colorCombo.addItem(new ComboItem("Pink", Color.PINK));
        colorCombo.addItem(new ComboItem("Cyan", Color.CYAN));
        colorCombo.addItem(new ComboItem("White", Color.WHITE));


        add(sidesLabel);
        add(sidesField);
        add(radiusLabel);
        add(radiusField);
        add(strokeLabel);
        add(strokeField);
        add(colorCombo);

    }

}
