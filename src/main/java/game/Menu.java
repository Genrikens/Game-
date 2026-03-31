import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame {


    private static final Image MenuBackground = SpriteLoader.load("menu/MenuBackground.png");
    private static final Image Bexit = SpriteLoader.load("menu/button_exit.png");
    private static final Image Bplay = SpriteLoader.load("menu/button_play.png");

    public Menu(){
        setTitle("menu for game");
        setSize(600,700+35);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(MenuBackground.getScaledInstance(75*8,87*8,Image.SCALE_SMOOTH)));
        background.setBounds(0, 0, 600, 700);

        // PANEL FOR BUTON
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));




        // BUTTON PLAY
        JButton play = new JButton();
        play.setMaximumSize(new Dimension(64*5,32*5));
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setIcon(new ImageIcon(Bplay.getScaledInstance(64*5,32*5,Image.SCALE_SMOOTH)));

        play.addActionListener(e -> {
            Game game = new Game();
            game.setVisible(true);
            setVisible(false);

        });

        buttons.add(play);
        buttons.add(Box.createVerticalStrut(200));


        // BUTTON EXIT
        JButton exit = new JButton();
        exit.setMaximumSize(new Dimension(64*5,32*5));
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setIcon(new ImageIcon(Bexit.getScaledInstance(64*5,32*5,Image.SCALE_SMOOTH)));

        exit.addActionListener(e -> {
            System.exit(0);
        });
        buttons.add(exit);



        // BACKGROUND
        add(background);
        add(buttons);

    }

    public void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);

        });
    }

}
