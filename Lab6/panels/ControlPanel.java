package panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private final JButton saveButton = new JButton("Save");
    private final JButton loadButton = new JButton("Load");
    private final JButton resetButton = new JButton("Reset");
    private final JButton exitButton = new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
        exitButton.setBackground(Color.RED);
        saveButton.setBackground(Color.GREEN);
        resetButton.setBackground(Color.YELLOW);
        loadButton.setBackground(Color.CYAN);

        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
    }

    private void load(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load from:");
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File loadFile = fileChooser.getSelectedFile();
            System.out.println("Loading file: " + loadFile.getAbsolutePath());
            try {
                BufferedImage image = ImageIO.read(loadFile);
                frame.canvas.loadImage(image);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save:");
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            try {
                ImageIO.write(frame.canvas.image, "png", new FileOutputStream(fileToSave.getAbsolutePath()));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void reset(ActionEvent e) {
        frame.canvas.removeAll();
        frame.canvas.repaint();
        frame.canvas.createOffscreenImage();
        frame.canvas.init();
    }

    private void exit(ActionEvent e) {
        JFrame saveFrame = new JFrame();
        saveFrame.setVisible(true);
        saveFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        saveFrame.setPreferredSize(new Dimension(400, 80));
        saveFrame.setLocation(530, 350);
        saveFrame.pack();
        JLabel saveLabel = new JLabel("Do you want to save?");

        JPanel savePanel = new JPanel();
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No ");
        yesButton.addActionListener(this::saveAndExit);
        noButton.addActionListener(this::exitNoSave);
        savePanel.add(saveLabel);
        savePanel.add(yesButton);
        savePanel.add(noButton);
        saveFrame.add(savePanel);
        try {
            wait(10);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.exit(0);
    }

    private void saveAndExit(ActionEvent e) {
        this.save(e);
        System.exit(0);
    }

    private void exitNoSave(ActionEvent e) {
        System.exit(0);
    }


}
