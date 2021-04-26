package panels;

import other.ComboItem;
import other.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private static Integer height, width;
    BufferedImage image;
    Graphics2D graphics;
    private List<Polygon> listOfShapes = new ArrayList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    protected void createOffscreenImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        height = (int) screenSize.getHeight();
        width = (int) screenSize.getWidth();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
    }


    protected void init() {
        setPreferredSize(new Dimension(width - 90, height - 150));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }


    private void drawShape(int x, int y) {

        int radius = (int) frame.configPanel.getRadiusField().getValue();
        int sides = (int) frame.configPanel.getSidesField().getValue();
        ComboItem item = (ComboItem) frame.configPanel.colorCombo.getSelectedItem();
        if (item == null) {
            throw new AssertionError();
        }
        Color color = item.getColor();
        graphics.setColor(color);
        var polygon = new RegularPolygon(x, y, radius, sides);
        listOfShapes.add(polygon);
        graphics.fill(polygon);
        int strokeThickness = (int) frame.configPanel.getStrokeField().getValue();
        if (strokeThickness > 0) {
            BasicStroke stroke = new BasicStroke(strokeThickness);
            graphics.setStroke(stroke);
            graphics.setColor(Color.BLACK);
            graphics.draw(polygon);
        }

    }

    public void loadImage(BufferedImage image) {
        graphics.drawImage(image, 0, 0, null);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
