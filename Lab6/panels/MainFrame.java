package panels;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    OptionsPanel optionsPanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel();
        controlPanel = new ControlPanel(this);
        optionsPanel = new OptionsPanel(this);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        controlPanel.setBackground(Color.darkGray);
        configPanel.setBackground(Color.darkGray);
        optionsPanel.setBackground(Color.darkGray);
        add(optionsPanel, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
