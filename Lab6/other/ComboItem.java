package other;

import java.awt.*;

public class ComboItem {
    String label;
    public Color color;

    public ComboItem(String label, Color color) {
        this.label = label;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return label;
    }

}
