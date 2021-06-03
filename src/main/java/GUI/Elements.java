package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Elements {
    public List<Font> fonts = new ArrayList();
    public List<Color> colours = new ArrayList<>();

    public Elements(){
        fonts.add(new Font("Courier new", Font.PLAIN, 14)); // 0 text field, button
        fonts.add(new Font("Courier new", Font.BOLD, 20));  // 1 title
        fonts.add(new Font("Courier new", Font.PLAIN, 12)); // 2 subtitle
        fonts.add(new Font("Courier new", Font.PLAIN, 10));  // 3 table

        colours.add(Color.decode("#1B264F"));   // 0 main title
        colours.add(Color.decode("#274690"));   // 1 subtitle
        colours.add(Color.decode("#277A8F"));   // 2 buttons background
        colours.add(Color.decode("#302B27"));   // 3 button/text field foreground
        colours.add(Color.decode("#F5F3F5"));   // 4 background
    }
}
