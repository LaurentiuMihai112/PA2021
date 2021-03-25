package other;

import java.awt.*;

public class RegularPolygon extends Polygon {
    public RegularPolygon(int x0, int y0, int radius, int sides) {
        if (sides == 4) {
            this.addPoint(x0 - radius, y0 - radius);
            this.addPoint(x0 - radius, y0 + radius);
            this.addPoint(x0 + radius, y0 + radius);
            this.addPoint(x0 + radius, y0 - radius);
        } else {
            double alpha = 2 * Math.PI / sides;
            for (int i = 0; i < sides; i++) {
                double x = x0 + radius * Math.cos(alpha * i);
                double y = y0 + radius * Math.sin(alpha * i);
                this.addPoint((int) x, (int) y);
            }
        }
    }
}
