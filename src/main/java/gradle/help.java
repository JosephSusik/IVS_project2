/*******************************************************************
 * Project name: Calculator
 * File: help.java
 * Date: 23.4.2020
 * Authors: xdudaj02
 *
 *******************************************************************/
/**
 * @file help.java
 *
 * @brief help class
 * @author xdudaj02
 *
 */

package gradle;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *  Class help
 *
 * @brief implements option to display help in the calculator
 */
public class help {
    /**
     * Reads text from file and creates Jframe window for HELP to be displayed on
     *
     * @throws IOException if input file is not supplied...
     */
    public static void show_help() throws IOException {

	//try to set calculator style to system default
        //bug: ivs ubuntu signals it cant load an essential module, but for some reason the program doesnt catch any exception
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
                try {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ignored) {}
        }	

        File file = new File("./src/main/java/gradle/resources/help.txt"); //set textfile containing help information
        BufferedReader help_text = new BufferedReader(new FileReader(file)); //load help file

        JFrame f_help = new JFrame("Le Calculator - HELP"); //create instance of JFrame, help window
        f_help.pack(); //pack

        Image logo = Toolkit.getDefaultToolkit().getImage("./src/main/java/gradle/resources/logo.png"); //import logo
        f_help.setIconImage(logo); //set logo

	int[] size = {600, 450};

        JTextArea ta = new JTextArea(); //create display for calculator help
        ta.setBounds(0, 0, size[0], size[1]); // (x, y, width, height)
	ta.setFont(ta.getFont().deriveFont(10f));
	ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        String line;
        while ((line = help_text.readLine()) != null) //write content of help file to display
            ta.setText(ta.getText() + line + System.lineSeparator());
        help_text.close();
        f_help.add(ta); //add display

        f_help.setSize((size[0] + f_help.getInsets().left + f_help.getInsets().right), (size[1] + f_help.getInsets().top + f_help.getInsets().bottom)); // (width, height)
        f_help.setLayout(null); //set default layout
        f_help.setVisible(true); //make frame visible

        ta.setEditable(false);// textarea not editable

        f_help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //when closing help window dont kill calculator
    } //end of show_help method
} //end of help class


/*** End of file help.java ***/
