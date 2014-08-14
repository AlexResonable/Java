package blokus5100;

import gameDesigner.PreviewBoard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import blokusGame.BlokusGame;

public class GameWizard implements ActionListener 
{
    private JFrame window = new JFrame("Settings for Blokus"); 
    private JLabel header = new JLabel("Modify Settings");
    private JLabel p1 = new JLabel("Name of Player 1: ");
    private JLabel p2 = new JLabel("Name of Player 2: ");
    private JLabel p3 = new JLabel("Name of Player 3: ");
    private JLabel p4 = new JLabel("Name of Player 4: ");
    private JTextField player1 = new JTextField(15);
    private JTextField player2 = new JTextField(15);
    private JTextField player3 = new JTextField(15);
    private JTextField player4 = new JTextField(15);
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton medium = new JRadioButton("Medium");
    JRadioButton hard = new JRadioButton("Hard");
    String[] games = {"Normal Game"};
    private JComboBox gameNames = new JComboBox(games);
    DefaultComboBoxModel model = new DefaultComboBoxModel();  
    private JButton boardButton = new JButton("Preview Board");
    private JButton backButton = new JButton("Back");
    private JButton playButton = new JButton("Play");
    private JPanel innerPane = new JPanel();
    
    public void run()
    {
        this.createDesignerMain();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
        int width = window.getSize().width;
        int height = window.getSize().height;
        int x = (d.width-width)/2;
        int y = (d.height-height)/2;
    
        window.setLocation(x, y);
        window.setVisible(true);
    }
    
    private void createDesignerMain()
    {
        window.setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        // "Modify Settings" field
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10,40,0,0);
        header.setFont(new Font("Arial", Font.PLAIN, 24));
        header.setName("Modify Settings");
        window.add(header, c);
        
        // Field in the black square
        c.gridwidth = 1;
        Border borderBlack = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.lightGray, Color.blue);
        innerPane.setLayout(new GridBagLayout());
        innerPane.setBorder(borderBlack);
        
        // add play name field 1-4
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(15,20,5,20);
        innerPane.add(p1,c);
        p1.setName("Name of Player 1");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(15,0,5,0);
        innerPane.add(player1,c);
        player1.setName("Player1 Field");
        
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5,20,5,20);
        innerPane.add(p2,c);
        p2.setName("Name of Player 2");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,0,5,0);
        innerPane.add(player2,c);
        player2.setName("Player2 Field");
        
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5,20,5,20);
        innerPane.add(p3,c);
        p3.setName("Name of Player 3");
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,0,5,0);
        innerPane.add(player3,c);
        player3.setName("Player3 Field");
        
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5,20,5,20);
        innerPane.add(p4,c);
        p4.setName("Name of Player 4");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,0,5,0);
        innerPane.add(player4,c);
        player4.setName("Player4 Field");
        
        // "Game Model" field
        gameNames.setModel(model);
        gameNames.setName("game names");
        gameNames.addItem("Normal Game");
        JPanel gameMode = new JPanel(new GridBagLayout());
        TitledBorder title = BorderFactory.createTitledBorder("Game Mode");
        gameMode.setBorder(title);
        easy.setSelected(true);
        ButtonGroup mode = new ButtonGroup();
        easy.setName("easy");
        medium.setName("medium");
        hard.setName("hard");
        mode.add(easy);
        mode.add(medium);
        mode.add(hard);
        
        // "Easy" button
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,5);
        gameMode.add(easy,c);
        easy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //get easy games from database and show them
                gameNames.removeAllItems();
                gameNames.addItem("Normal Game");
                
            }
        });
        
        // "Medium" button
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,5);
        gameMode.add(medium,c);
        medium.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //get easy games from database and show them
                gameNames.removeAllItems();
                gameNames.addItem(" ");
                
            }
        });
        medium.addActionListener(this);
        
        //"Hard" button
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,5);
        gameMode.add(hard,c);
        hard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //get easy games from database and show them
                gameNames.removeAllItems();
                gameNames.addItem(" ");
                
            }
        });
        
        // Game combBox
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(5,10,5,10);
        gameMode.add(new JLabel("Game"),c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(5,0,5,10);
        gameMode.add(gameNames,c);
        
        // add "Game Mode" to inner panel
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        c.insets = new Insets(5,20,5,20);
        innerPane.add(gameMode,c);
        
        // add "Preview Board" to inner panel
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 3;
        c.insets = new Insets(20,10,15,20);
        innerPane.add(boardButton,c);
        boardButton.setName("Preview Board");
        boardButton.addActionListener(this);
      
        // add "inner panel,"back" button, "play" button to the window
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridwidth = 4;
        c.insets = new Insets(0,30,20,30);
        window.add(innerPane,c);
        
        c.gridx = 0;
        c.gridy = 3;
        c.ipady = 5;
        c.insets = new Insets(0,30,20,350);
        window.add(backButton, c);
        backButton.setName("Back");
        backButton.addActionListener(this);
        
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(0,30,20,30);
        window.add(playButton, c);
        playButton.setName("Play");
        playButton.addActionListener(this);
        window.pack();


    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == backButton)
        {
            //take back to main menu screen
            window.setVisible(false);
            MainMenu.createAndShowGUI();
        }
        else if(ae.getSource() == boardButton)
        {
            //take to board where you can edit which squares are blocked
            window.setVisible(false);
            PreviewBoard board = new PreviewBoard();
            board.run();
        }
        else if(ae.getSource() == playButton)
        {
            window.dispose();
            BlokusGame bg = new BlokusGame();
            //save board to database and then take back to menu with it added to the GUI 
        }
    }
    
    public JFrame getWindow()
    {
    	return window;
    }
    
}
