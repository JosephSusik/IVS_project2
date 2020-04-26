/*******************************************************************
 * Project name: Calculator
 * File: calculator.java
 * Date: 23.4.2020
 * Authors: xsusik00, xsucha17, xdudaj02
 *
 *******************************************************************/
/**
 * @file calculator.java
 *
 * @brief calculator class
 * @author xsusik00
 * @author xsucha17
 * @author xdudaj02
 *
 */

package gradle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static gradle.help.*;
import static gradle.libs.math.*;

/**
 * Class calculator
 *
 * @brief calculator app layout, functionality
 */


class calculator {
    int[] calculator_size = {500, 300}; //!< calculator parameters
    int[] normal_button_size = {100, 40}; //!< normal calculator button parameters
    int[] big_button_size = {100, 160}; //!< big calculator button parameters

    //define fonts
    Font font_big = new Font("SansSerif", Font.BOLD, 40); //!< font for main display
    Font font_small = new Font("SansSerif", Font.PLAIN, 15); //!< font for second smaller display

    Image logo = Toolkit.getDefaultToolkit().getImage("./src/main/java/gradle/resources/logo.png"); //!< program logo


    //mOp enum, indicates which operation is to be performed
    private enum op {
        NONE(0),
        ADD(1),
        SUB(2),
        MUL(3),
        DIV(4),
        POW(5),
        ROOT(6),
        LOG(7);

        private int value;
        private static Map<Object, Object> map = new HashMap<>();

        op(int value) {
            this.value = value;
        }

        static { //assignment of values
            for (op mOp : values()) {
                map.put(mOp.value, mOp);
            }
        }

        //equality check func
        public boolean is(op num) {
            int val_2 = num.value;
            return value == val_2;
        }
    }

    //booleans used to determine behaviour
    op mOp = op.NONE; //!< operation indicator, default value is NONE
    boolean mTF=false; //!< indicates whether textfield is waiting for input
    boolean mDot=false; //!< indicates if dot has been used
    boolean mEq=false; //!< indicates if 'equal' button can be used

    double ValueOne; //!< first value for calculation
    double ValueTwo; //!< second value for calculation

    /**
     * Action to be performed for a numeric button
     *
     * @param value value to be written to display
     * @param tf_big JTextField to write to
     */
    protected void numericAction(String value, JTextField tf_big){
        if (!mTF) {
            tf_big.setText("");
        }
        tf_big.setText(tf_big.getText() + value);
        mTF = true;
        mEq = true;
    } //end of numericAction method

    /**
     * Action to be performed for a (mathematical) operation button
     *
     * @param value value to be written
     * @param tf_big main JTextField to write to
     * @param tf_small small JTextField to write to
     */
    protected void operationAction(String value, JTextField tf_big, JTextField tf_small){
        if (mOp.is(op.NONE) && mEq) {
            ValueOne = Double.parseDouble(tf_big.getText() + "");
            switch (value) { //set corresponding flag
                case "+":
                    mOp = op.ADD;
                    break;
                case "-":
                    mOp = op.SUB;
                    break;
                case "*":
                    mOp = op.MUL;
                    break;
                case "/":
                    mOp = op.DIV;
                    break;
                case "pow":
                    mOp = op.POW;
                    break;
                case "root":
                    mOp = op.ROOT;
                    break;
                case "log":
                    mOp = op.LOG;
                    break;
            }
            tf_small.setText(tf_big.getText() + " " + value + " ");
            tf_big.setText(null);
            mDot = false;
            mEq = false;
        } else if (!mEq && value.equals("-")) { // minus can be also used as sign operator
            tf_big.setText(value);
            mTF = true;
        }
    } //end of operationAction method

    /**
     * Action to be performed for 'factorial' button
     *
     * @param tf_big main JTextField to write to
     * @param tf_small second JTextField to write to
     */
    protected void factorialAction(JTextField tf_big, JTextField tf_small){
        if (mOp.is(op.NONE)) {
            ValueOne = Double.parseDouble(tf_big.getText() + "");
            tf_small.setText(tf_big.getText() + "!");
            tf_big.setText(null);
            try {
                tf_big.setText(factorial(ValueOne) + "");
            } catch (IllegalOptionException ex) {
                tf_big.setText("Error.");
                tf_small.setText(null);
            }
            mDot = false;
            mTF = false;
            mEq = true;
        }
    } //end of factorialAction method

    /**
     * Action to be performed for 'dot' button
     *
     * @param tf_big JTextField to write to
     */
    protected void dotAction(JTextField tf_big){
        if(!mDot) {
            if (!mTF) {
                tf_big.setText("");
            }
            tf_big.setText(tf_big.getText()+".");
            mDot = true;
            mTF = true;
            mEq = false;
        }
    } //end of dotAction method

    /**
     * Action to be performed for 'equals' button
     *
     * @param tf_big main JTextField to write to
     * @param tf_small second JTextField to write to
     */
    protected void equalsAction(JTextField tf_big, JTextField tf_small){
        if (mEq) {
            ValueTwo = Double.parseDouble(tf_big.getText() + "");
            tf_small.setText(tf_small.getText() + tf_big.getText() + " =");
            String print_string; //string to be printed
            if (mOp.is(op.ADD)) {
                print_string = (adding(ValueOne, ValueTwo) + "\0");
            }
            else if (mOp.is(op.SUB)) {
                print_string = (subtraction(ValueOne, ValueTwo) + "\0");
            }
            else if (mOp.is(op.MUL)) {
                print_string = (multiplication(ValueOne, ValueTwo) + "\0");
            }
            else if (mOp.is(op.DIV)) {
                try {
                    print_string = (division(ValueOne, ValueTwo) + "\0");
                } catch (IllegalOptionException ex) {
                    print_string = ("Error.");
                    tf_small.setText(null);
                }
            }
            else if (mOp.is(op.POW)) {
                try {
                    print_string = (power(ValueOne, ValueTwo) + "\0");
                } catch (IllegalOptionException ex) {
                    print_string = ("Error.");
                    tf_small.setText(null);
                }
            }
            else if (mOp.is(op.ROOT)) {
                try {
                    print_string = (root(ValueOne,(int) ValueTwo) + "\0");
                } catch (IllegalOptionException ex) {
                    print_string = ("Error.");
                    tf_small.setText(null);
                }
            }
            // 1st number is base, 2nd number is log. number
            else if (mOp.is(op.LOG)) {
                try {
                    print_string = (logarithm(ValueOne, ValueTwo) + "\0");
                } catch (IllegalOptionException ex) {
                    print_string = ("Error.");
                    tf_small.setText(null);
                }
            } else {
                print_string = (ValueTwo + "\0");
                tf_small.setText("");
            }

            if (print_string.contains(".0\0"))
                print_string = print_string.substring(0, print_string.length() - 3); //if contains '.0' - write as int
            else
                print_string = print_string.substring(0, print_string.length() - 1);
            tf_big.setText(print_string);

            mOp = op.NONE;
            mTF = false;
            mDot = false;
            mEq = true;
        } //end of if mEq
    } //end of equalsAction method

    /**
     * Method creates button with given parameters
     *
     * @param name button name
     * @param x first button coordinate
     * @param y second button coordinate
     * @param tf_big main JTextField to write to
     * @param tf_small second JTextField to write to
     * @return created JButton object
     */
    protected JButton createButton(String name, int x, int y, JTextField tf_big, JTextField tf_small){
        String[] digits = {"1", "2" ,"3" ,"4" ,"5" ,"6" ,"7" ,"8" ,"9" ,"0"};
        String[] operations = {"+", "-", "*", "/", "pow", "root", "log"};

        JButton button = new JButton(name); // create new JButton
        if (name.equals("=")) { //'equals' button
            button.setBounds(x, y, big_button_size[0], big_button_size[1]); //set coordinates and big button size
            button.addActionListener(e -> equalsAction(tf_big, tf_small)); //add action listener for 'equals' button
        } else {
            button.setBounds(x, y, normal_button_size[0], normal_button_size[1]); //set coordinates and normal button size
            if (Arrays.asList(digits).contains(name)) {
                button.addActionListener(e -> numericAction(name, tf_big)); //add action listener for numeric button
            } else if (Arrays.asList(operations).contains(name)) {
                button.addActionListener(e -> operationAction(name, tf_big, tf_small)); //add action listener for mat. operation button
            } else if (name.equals("!")) {
                button.addActionListener(e -> factorialAction(tf_big, tf_small)); //add action listener for 'factorial' button
            } else if (name.equals(".")) {
                button.addActionListener(e -> dotAction(tf_big)); //add action listener for 'dot' button
            } else if (name.equals("CE")) {
                button.addActionListener(e -> { //add action listener for 'CE' button
                    tf_big.setText("");
                    tf_small.setText("");
                    mDot = false;
                    mEq = false;
                });
            } else if (name.equals("HELP")) {
                button.addActionListener(e -> { //add action listener for 'HELP' button
                    try {
                        show_help(); //call show_help method imported from help.java
                    } catch (IOException ignored) {}
                });
            }
        } //else
        return button;
    } //end of createButton method

    /**
     * Calculator layout and functionality
     */
    public calculator() {

        //try to set calculator style to system default
	//bug: ivs ubuntu signals it cant load an essential module, but for some reason the program doesnt catch any exception
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ignored) {}
	}

        //Create instance of JFrame, calculator window
        JFrame f = new JFrame("Le Calculator");
        f.pack(); //pack
        f.setIconImage(logo); //set logo

	// Set calculator Jframe size
	calculator_size[0] += f.getInsets().left + f.getInsets().right; // calculator app width
        calculator_size[1] += f.getInsets().top + f.getInsets().bottom; // calculator app height
	f.setSize(calculator_size[0], calculator_size[1]); // (width, height)

        //Create textfields, calculator display
        JTextField tf_big = new JTextField(); //Creating calculator display
	tf_big.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //without borders, doesnt seem to work on ivs ubuntu machine
        tf_big.setBounds(0,40,500,60); // (x, y, width, height)
        tf_big.setFont(font_big); //set font
        f.add(tf_big); //Adding display

        JTextField tf_small = new JTextField(); //Creating second (small) calculator display
        tf_small.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //without borders
        tf_small.setBounds(0,0,500,40); // (x, y, width, height)
        tf_small.setFont(font_small); //set font
        f.add(tf_small); //Adding display


        //Creating and adding buttons to JFrame
        f.add(createButton("0", 200,260, tf_big, tf_small));
        f.add(createButton("1", 100,220, tf_big, tf_small));
        f.add(createButton("2", 200,220, tf_big, tf_small));
        f.add(createButton("3", 300,220, tf_big, tf_small));
        f.add(createButton("4", 100,180, tf_big, tf_small));
        f.add(createButton("5", 200,180, tf_big, tf_small));
        f.add(createButton("6", 300,180, tf_big, tf_small));
        f.add(createButton("7", 100,140, tf_big, tf_small));
        f.add(createButton("8", 200,140, tf_big, tf_small));
        f.add(createButton("9", 300,140, tf_big, tf_small));
        f.add(createButton(".", 300,260, tf_big, tf_small));
        f.add(createButton("+", 0,260, tf_big, tf_small));
        f.add(createButton("-", 100,260, tf_big, tf_small));
        f.add(createButton("*", 0,220, tf_big, tf_small));
        f.add(createButton("/", 0,180, tf_big, tf_small));
        f.add(createButton("!", 0,140, tf_big, tf_small));
        f.add(createButton("pow", 0,100, tf_big, tf_small));
        f.add(createButton("root", 100,100, tf_big, tf_small));
        f.add(createButton("log", 200,100, tf_big, tf_small));
        f.add(createButton("=", 400,140, tf_big, tf_small));
        f.add(createButton("CE", 300,100, tf_big, tf_small));
        f.add(createButton("HELP", 400,100, tf_big, tf_small));

        // Making JFrame visible
        f.setLayout(null);
	f.setVisible(true); // Making the frame visible

        // Textfields not editable
        tf_big.setEditable(false);
        tf_small.setEditable(false);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { //set event for closing window
                System.exit(0); //exit 0
            }
        });

    } //End of method calculator

    /**
     * Method main
     *
     * @brief creates instance of calculator
     * @param args the command line arguments - unused
     */
    public static void main(String[] args) {
        new calculator();
    }

} //End of class calculator

/*** End of file calculator.java ***/
