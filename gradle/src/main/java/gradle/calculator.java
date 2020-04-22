package gradle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static gradle.help.*;
import static gradle.libs.Math.*;

class calculator {

    double ValueOne, ValueTwo; //values for calculation
    boolean mAdd=false, mSub=false, mMul=false, mDiv=false, mPow=false, mRoot=false, mTF=false, mDot=false, mLog=false, mEq=false;

    public calculator() {

        try {
            UIManager.setLookAndFeel( //set calculator style
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            // handle exception
        }

        JFrame f = new JFrame("Le Calculator"); //Creating instance of JFrame, calculator window
        f.pack(); //pack
        Image logo = Toolkit.getDefaultToolkit().getImage("./src/main/java/gradle/resources/logo.png"); //import logo
        f.setIconImage(logo); //set logo

        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        Font font2 = new Font("SansSerif", Font.PLAIN, 15);


        JTextField tf = new JTextField(); //Creating calculator display
        tf.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //without borders
        tf.setBounds(0,40,500,60); // (x, y, width, height)
        tf.setFont(font1); //set font
        f.add(tf); //Adding display

        JTextField tf_2;
        tf_2 = new JTextField(); //Creating calculator display
        tf_2.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //without borders
        tf_2.setBounds(0,0,500,40); // (x, y, width, height)
        tf_2.setFont(font2); //set font
        f.add(tf_2); //Adding display


        //Creating JButton instances
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton dot = new JButton(".");
        JButton equal = new JButton("=");
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        JButton factorial = new JButton("!");
        JButton power = new JButton("pow");
        JButton root = new JButton("root");
        JButton log = new JButton("log");
        JButton ce = new JButton("CE");
        JButton help = new JButton("HELP");

        //Creating button layout
        one.setBounds(100,220,100,40);
        two.setBounds(200,220,100,40);
        three.setBounds(300,220,100,40);
        four.setBounds(100,180,100,40);
        five.setBounds(200,180,100,40);
        six.setBounds(300,180,100,40);
        seven.setBounds(100,140,100,40);
        eight.setBounds(200,140,100,40);
        nine.setBounds(300,140,100,40);
        zero.setBounds(200,260,100,40);
        dot.setBounds(300,260,100,40);
        add.setBounds(0,260,100,40);
        sub.setBounds(100,260,100,40);
        mul.setBounds(0,220,100,40);
        div.setBounds(0,180,100,40);
        factorial.setBounds(0,140,100,40);
        power.setBounds(0,100,100,40);
        root.setBounds(100,100,100,40);
        log.setBounds(200,100,100,40);
        ce.setBounds(300,100,100,40);
        equal.setBounds(400,140,100,160);
        help.setBounds(400, 100, 100, 40);


        //Adding buttons to JFrame
        f.add(zero);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(dot);
        f.add(add);
        f.add(sub);
        f.add(mul);
        f.add(div);
        f.add(factorial);
        f.add(power);
        f.add(root);
        f.add(log);
        f.add(ce);
        f.add(equal);
        f.add(help);


        // Has to be down here, otherwise loading is too slow
        f.setSize((500 + f.getInsets().left + f.getInsets().right), (300 + f.getInsets().top + f.getInsets().bottom)); // (width, height)
        f.setLayout(null); //Using no layout managers
        f.setVisible(true); //Making the frame visible

        // Textfield not editable
        tf.setEditable(false);
        tf_2.setEditable(false);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { //set event for closing window
                System.exit(0); //exit 0
            }
        });

        //Adding functions for buttons
        zero.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+0);
            mTF = true;
            mEq = true;
        });

        one.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+1);
            mTF = true;
            mEq = true;
        });

        two.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+2);
            mTF = true;
            mEq = true;
        });

        three.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+3);
            mTF = true;
            mEq = true;
        });

        four.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+4);
            mTF = true;
            mEq = true;
        });

        five.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+5);
            mTF = true;
            mEq = true;
        });

        six.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+6);
            mTF = true;
            mEq = true;
        });

        seven.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+7);
            mTF = true;
            mEq = true;
        });

        eight.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+8);
            mTF = true;
            mEq = true;
        });

        nine.addActionListener(e -> {
            if (!mTF) {
                tf.setText("");
            }
            tf.setText(tf.getText()+9);
            mTF = true;
            mEq = true;
        });

        dot.addActionListener(e -> {
            if(!mDot) {
                if (!mTF) {
                    tf.setText("");
                }
                tf.setText(tf.getText()+".");
                mDot = true;
                mTF = true;
                mEq = false;
            }
        });


        //	EQUAL
        equal.addActionListener(e -> {
            if (mEq) {
                ValueTwo = Double.parseDouble(tf.getText() + "");
                tf_2.setText(tf_2.getText() + tf.getText() + " =");
                String print_string;
                if (mAdd) {
                    print_string = (adding(ValueOne, ValueTwo) + "\0");
                    mAdd = false;
                }
                else if (mSub) {
                    print_string = (subtraction(ValueOne, ValueTwo) + "\0");
                    mSub = false;
                }
                else if (mMul) {
                    print_string = (multiplication(ValueOne, ValueTwo) + "\0");
                    mMul = false;
                }
                else if (mDiv) {
                    try {
                        print_string = (division(ValueOne, ValueTwo) + "\0");
                    } catch (IllegalOptionException ex) {
                        print_string = ("Error.");
                        tf_2.setText(null);
                    }
                    mDiv = false;
                }
                else if (mPow) {
                    try {
                        print_string = (power(ValueOne, ValueTwo) + "\0");
                    } catch (IllegalOptionException ex) {
                        print_string = ("Error.");
                        tf_2.setText(null);
                    }
                    mPow = false;
                }
                else if (mRoot) {
                    try {
                        print_string = (root(ValueOne,(int) ValueTwo) + "\0");
                    } catch (IllegalOptionException ex) {
                        print_string = ("Error.");
                        tf_2.setText(null);
                    }
                    mRoot = false;
                }
                // 1st number is base, 2nd number is log. number
                else if (mLog) {
                    try {
                        print_string = (logarithm(ValueOne, ValueTwo) + "\0");
                    } catch (IllegalOptionException ex) {
                        print_string = ("Error.");
                        tf_2.setText(null);
                    }
                    mLog = false;
                } else {
                    print_string = (ValueTwo + "\0");
                    tf_2.setText("");
                }

                if (print_string.contains(".0\0"))
                    print_string = print_string.substring(0, print_string.length() - 3);
                else
                    print_string = print_string.substring(0, print_string.length() - 1);
                tf.setText(print_string);

                mTF = false;
                mDot = false;
                mEq = true;
            }
        });


        //	ADDITION
        add.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mAdd = true;
                tf_2.setText(tf.getText() + " + ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }

        });

        //	SUBTRACTION
        sub.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mSub = true;
                tf_2.setText(tf.getText() + " - ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            } else if (!mEq) {
                tf.setText("-");
                mTF = true;
            }

        });

        //	MULTIPLICATION
        mul.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mMul = true;
                tf_2.setText(tf.getText() + " * ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }

        });

        //	DIVISION
        div.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mDiv = true;
                tf_2.setText(tf.getText() + " / ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }
        });

        //	FACTORIAL
        factorial.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                tf_2.setText(tf.getText() + "!");
                tf.setText(null);
                try {
                    tf.setText(factorial(ValueOne) + "");
                } catch (IllegalOptionException ex) {
                    tf.setText("Error.");
                    tf_2.setText(null);
                }
                mDot = false;
                mTF = false;
                mEq = true;
            }

        });

        //	POWER
        power.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mPow = true;
                tf_2.setText(tf.getText() + " ^ ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }

        });

        // ROOT
        root.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mRoot = true;
                tf_2.setText(tf.getText() + " root ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }

        });

        //	LOGARITHM
        log.addActionListener(e -> {
            if (mEq && !mAdd && !mSub && !mMul && !mDiv && !mPow && !mRoot && !mLog) {
                ValueOne = Double.parseDouble(tf.getText() + "");
                mLog = true;
                tf_2.setText("log " + tf.getText() + " ");
                tf.setText(null);
                mDot = false;
                mEq = false;
            }

        });

        //  CLEAR
        ce.addActionListener(e -> {
            tf.setText("");
            tf_2.setText("");
            mDot = false;
            mEq = false;
        });

        //  HELP
        help.addActionListener(e -> {
            try {
                show_help();
            } catch (IOException ignored) {
                System.out.println("vole");
            }
        });


    } //End of Gui()

    public static void main(String[] args) {
        new calculator();
    }
} //End of program
