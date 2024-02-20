import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea textArea;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fortunes = new ArrayList<>();
        fortunes.add("You will find a pot of gold.");
        fortunes.add("A squirrel will bring you a surprise tomorrow.");
        fortunes.add("You will discover a hidden talent.");
        fortunes.add("An unexpected visitor will bring you horrible news.");
        fortunes.add("Minecraft will disappear.");
        fortunes.add("You will see the world.");
        fortunes.add("Today will be a day full of the future.");
        fortunes.add("You will meet someone who will change your life.");
        fortunes.add("Good luck will come your way.");
        fortunes.add("You will embark on a thrilling journey.");
        fortunes.add("A long-lost friend will reconnect with you, then disconnect with you.");
        fortunes.add("A crazy surprise is in store for you.");

        JPanel topPanel = createTopPanel();
        JPanel middlePanel = createMiddlePanel();
        JPanel bottomPanel = createBottomPanel();

        Container contentPane = getContentPane();
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(middlePanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height;
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        ImageIcon fortuneTellerIcon = new ImageIcon("fortune_teller.png");

        Image scaledImage = fortuneTellerIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon, JLabel.CENTER);
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        panel.add(imageLabel);
        panel.add(titleLabel);
        return panel;
    }


    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        // Set font for text area
        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));

        panel.add(readFortuneButton);
        panel.add(quitButton);
        return panel;
    }

    private void displayFortune() {
        int index;
        do {
            index = new Random().nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        textArea.append(fortunes.get(index) + "\n");
    }
}

