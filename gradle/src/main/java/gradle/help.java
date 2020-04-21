package gradle;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class help {
    public static void show_help() throws IOException {
        try {
            UIManager.setLookAndFeel( //set calculator style
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            // handle exception
        }

        File file = new File("./src/main/java/gradle/resources/help.txt"); //set textfile containing help information
        BufferedReader help_text = new BufferedReader(new FileReader(file)); //load help file

        JFrame f_help = new JFrame("Le Calculator - HELP"); //create instance of JFrame, calculator window
        f_help.pack(); //pack
        Image logo = Toolkit.getDefaultToolkit().getImage("./src/main/java/gradle/resources/logo.png"); //import logo
        f_help.setIconImage(logo); //set logo

        JTextArea ta = new JTextArea(); //create display for calculator help
        ta.setBounds(0,0,570,430); // (x, y, width, height)
        String line;
        while ((line = help_text.readLine()) != null) //write content of help file to display
            ta.setText(ta.getText() + line + System.lineSeparator());
        help_text.close();
        f_help.add(ta); //add display

        f_help.setSize((570 + f_help.getInsets().left + f_help.getInsets().right), (430 + f_help.getInsets().top + f_help.getInsets().bottom)); // (width, height)
        f_help.setLayout(null); //set default layout
        f_help.setVisible(true); //make frame visible

        ta.setEditable(false);// textare not editable

        f_help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //when closing help dont kill calculator
    }
}

