import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame {
    private static final Image MenuBackground = SpriteLoader.load("/MenuBackground.png");
    public Menu(){
        setTitle("menu for game");
        setSize(600,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());





        // PANEL FOR BUTON
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

        // BUTTON PLAY
        JButton play = new JButton();
        play.setMaximumSize(new Dimension(220,120));
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.addActionListener(e -> {
            Game game = new Game();
            game.setVisible(true);
            setVisible(false);

        });
        buttons.add(play);
        buttons.add(Box.createRigidArea(new Dimension(0,100)));

        // BUTTON EXIT
        JButton exit = new JButton();
        exit.setMaximumSize(new Dimension(220,120));
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addActionListener(e -> {
            System.exit(0);
        });
        buttons.add(exit);

        add(buttons, BorderLayout.CENTER);
    }

    static class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(MenuBackground, 0, 0, 600, 700, null);
        }
    }
    public void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);

        });
    }

}
