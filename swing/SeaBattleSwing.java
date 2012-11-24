package sea_battle_java_courses.swing;

import sea_battle_java_courses.game_model.Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class SeaBattleSwing extends JFrame {

    private SeaBattleBoard board;

    public SeaBattleSwing() {
        board = new SeaBattleBoard(this);
        add(board);
        setTitle("SeaBattleSwing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(850, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void drawGameField() {
        Field userFieldMap = new Field();
        userFieldMap.regenerateForGame();
        Field computerFieldMap = new Field();
        computerFieldMap.regenerateForGame();
        board.printBattleField(userFieldMap, computerFieldMap);
        board.drawCoordinateSymbols();
    }

    public void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Файл");
        JMenu menuHelp = new JMenu("Справка");
        JMenuItem menuItem = new JMenuItem("");
        menuFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuFileItemExit = new JMenuItem("Выход");
        eMenuFileItemExit.setMnemonic(KeyEvent.VK_C);
        eMenuFileItemExit.setToolTipText("Выход из приложения");
        eMenuFileItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
      
        JMenuItem eMenuFileItemRestartGame = new JMenuItem("Новая игра");
        eMenuFileItemRestartGame.setMnemonic(KeyEvent.VK_C);
        eMenuFileItemRestartGame.setToolTipText("Перезапуск игры");
        eMenuFileItemRestartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                drawGameField();
            }

        });
        
        JMenuItem eMenuHelpItemAbout = new JMenuItem("О программе");
        eMenuHelpItemAbout.setMnemonic(KeyEvent.VK_C);
        eMenuHelpItemAbout.setToolTipText("О программе");
        eMenuHelpItemAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                final AboutProgramWindow about = new AboutProgramWindow();
                about.createAndShowGUI();
            }
        });
        
        menuFile.add(eMenuFileItemRestartGame);
        menuFile.add(eMenuFileItemExit);
        menuHelp.add(eMenuHelpItemAbout);
        
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        
        setContentPane(board);
        setJMenuBar(menuBar);
    }

}