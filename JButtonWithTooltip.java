package proj4;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonWithTooltip extends JFrame {
  public JButtonWithTooltip(String type) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton b = new JButton(type);
    b.setToolTipText("Help text for the button");

    getContentPane().add(b, "Center");
    pack();
  }

  public static void main(String[] args) {
    new JButtonWithTooltip("sup").setVisible(true);
  }
}

