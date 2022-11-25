package Sudoku;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimerTask;

public class SudokuGUI {

    private int difficulty = 1;
    private JPanel board;
    private JPanel header;
    private JLabel title;
    private JPanel bottomField;
    private JButton scoreButton;
    private JPanel gamePanel;
    private JButton numPad1;
    private JLabel difficultyLabel;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JLabel mistakeCounter;

    public SudokuGUI() {
        $$$setupUI$$$();
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = 1;
                createUIComponents();
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = 2;
                createUIComponents();

            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = 3;
                //not working
                gamePanel.removeAll();
                gamePanel.updateUI();
                gamePanel.revalidate();
                gamePanel.repaint();
                gamePanel = new JPanel();
                gamePanel.setVisible(true);
                gamePanel.setSize(400, 400);
                createUIComponents();

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku");
        SudokuGUI gui = new SudokuGUI();
        gui.getBoard().setBackground(Color.ORANGE);
        frame.add(gui.getBoard());

        frame.setSize(600, 600);
        frame.setVisible(true);

    }


    public JPanel getBoard() {
        return board;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        board = new JPanel();
        board.setLayout(new BorderLayout(0, 0));
        board.setBackground(new Color(-1));
        header = new JPanel();
        header.setLayout(new GridBagLayout());
        board.add(header, BorderLayout.NORTH);
        title = new JLabel();
        Font titleFont = this.$$$getFont$$$("Microsoft Sans Serif", -1, 16, title.getFont());
        if (titleFont != null) title.setFont(titleFont);
        title.setText("Sudoku");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 0, 20, 0);
        header.add(title, gbc);
        bottomField = new JPanel();
        bottomField.setLayout(new GridBagLayout());
        board.add(bottomField, BorderLayout.SOUTH);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomField.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        bottomField.add(spacer2, gbc);
        difficultyLabel = new JLabel();
        difficultyLabel.setText("Difficulty");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        bottomField.add(difficultyLabel, gbc);
        hardButton = new JButton();
        hardButton.setText("Hard");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomField.add(hardButton, gbc);
        easyButton = new JButton();
        easyButton.setText("Easy");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomField.add(easyButton, gbc);
        mediumButton = new JButton();
        mediumButton.setText("Medium");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomField.add(mediumButton, gbc);
        scoreButton = new JButton();
        scoreButton.setText("Save Score");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 30, 0);
        bottomField.add(scoreButton, gbc);
        board.add(gamePanel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return board;
    }

    ArrayList<JTextField> textFields = new ArrayList<>();

    private void createUIComponents() {
        // TODO: place custom component creation code here

        //numPad1.addActionListener(gamePanel.getActionForKeyStroke());
        int[] solution = {4, 8, 9, 6, 7, 2, 3, 5, 1, 3, 1, 6, 5, 4, 9, 2, 8, 7, 7, 5, 2, 8, 3, 1, 4, 6, 9, 2, 3, 8, 1, 5, 7, 9, 4, 6, 5, 4, 7, 3, 9, 6, 1, 2, 8, 6, 9, 1, 2, 8, 4, 5, 7, 3, 1, 6, 5, 9, 2, 8, 7, 3, 4, 9, 2, 4, 7, 6, 3, 8, 1, 5, 8, 7, 3, 4, 1, 5, 6, 9, 2};
        //https://stackoverflow.com/questions/54174625/i-want-to-have-two-arrays-to-have-the-same-values#:~:text=If%20you%20want%20two%20different,arrayCopy()%20for%20better%20performance!
        int[] problem = Arrays.copyOf(solution, solution.length);

        int tilesRemoved = 0;
        if (difficulty == 1) {
            tilesRemoved = 5;
        } else if (difficulty == 2) {
            tilesRemoved = 10;
        } else if (difficulty == 3) {
            tilesRemoved = 20;
        }
        int missingNumbers[] = new int[tilesRemoved];
        int orderRemoved[] = new int[tilesRemoved];
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(9, 9));

        for (int i = 0; i < tilesRemoved; i++) {
            int replaceRandom = (int) (Math.random() * 81);
            problem[replaceRandom] = 0;
            orderRemoved[i] = replaceRandom;
            missingNumbers[i] = solution[replaceRandom];
            System.out.println(Arrays.toString(missingNumbers));
            System.out.println(Arrays.toString(orderRemoved));
            System.out.println("Blank position " + (replaceRandom + 1));
            System.out.println("Number solution " + solution[replaceRandom]);

        }

        for (int i = 0; i <= 80; i++) {
            if (Integer.parseInt(String.valueOf(problem[i])) == 0) {
                JTextField blankTile = new JTextField();

                textFields.add(blankTile);
                Arrays.sort(orderRemoved);
                int number = i;
                //https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
                blankTile.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        check(number);
                    }

                    public void removeUpdate(DocumentEvent e) {
                        //check(number);
                    }

                    public void insertUpdate(DocumentEvent e) {
                        check(number);
                    }

                    public void check(int number) {
                        if (Integer.parseInt(blankTile.getText()) == solution[number]) {
                            blankTile.setBackground(Color.WHITE);
                        } else {

                            blankTile.setBackground(Color.RED);
                        }
                    }
                });

                gamePanel.add(blankTile);
            } else {
                gamePanel.add(new JLabel(String.valueOf(problem[i])));
            }
            //JTextField blankTile = new JTextField();
        }


    }
}
