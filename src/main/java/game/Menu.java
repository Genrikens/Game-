import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
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

    public void main(String[] args){
        SwingUtilities.invokeLater(() -> {
        new Menu().setVisible(true);
        });
    }


}
