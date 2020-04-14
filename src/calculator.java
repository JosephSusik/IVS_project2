package gradle;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import gradle.libs.Math;

class calculator {
	
	double myValueOne, myValueTwo;
	boolean mAdd, mSub, mMul, mDiv, mFac, mPow, mSqroot, mTF, mDot, mLog, mEq;
	
 	public calculator() {
		JFrame f;
		f = new JFrame("Calculator"); //Creating instance of JFrame, calculator window
		
		JTextField tf;
		tf = new JTextField(); //Creating calculator display
		tf.setBounds(0,0,500,100); // (x, y, width, height)
		f.add(tf); //Adding display
		
		mDot = false; //Must be default set to false
		mEq = false;
		
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
		JButton multi = new JButton("*");
		JButton div = new JButton("/");
		JButton factorial = new JButton("!");
		JButton power = new JButton("^");
		JButton sqroot = new JButton("√");
		JButton log = new JButton("Log");
		JButton ce = new JButton("CE");
		
		//Creating button size, layout
		zero.setBounds(100,260,100,40);
		one.setBounds(0,220,100,40);
		two.setBounds(100,220,100,40);
		three.setBounds(200,220,100,40);
		four.setBounds(0,180,100,40);
		five.setBounds(100,180,100,40);
		six.setBounds(200,180,100,40);
		seven.setBounds(0,140,100,40);
		eight.setBounds(100,140,100,40);
		nine.setBounds(200,140,100,40);
		dot.setBounds(0,260,100,40);
		add.setBounds(200,260,100,40);
		multi.setBounds(300,220,100,40);
		sub.setBounds(300,260,100,40);
		factorial.setBounds(300,140,100,40);
		div.setBounds(300,180,100,40);
		log.setBounds(300,100,100,40);
		power.setBounds(200,100,100,40);
		sqroot.setBounds(100,100,100,40);
		ce.setBounds(0,100,100,40);
		equal.setBounds(400,100,65,200);
		
		//Adding button to JFrame
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
		f.add(equal);
		f.add(add);
		f.add(sub);
		f.add(multi);
		f.add(div);
		f.add(factorial);
		f.add(power);
		f.add(sqroot);
		f.add(log);
		f.add(ce);

		
		// Has to be down here, otherwise loading is too slow
		f.setSize(465,320); // (width, height)
		f.setLayout(null); //Using no layout managers
		f.setVisible(true); //Making the frame visible
		
		// Textfield not editable 
		tf.setEditable(false);
		
		
		//Adding functions for buttons
		zero.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			if (mTF == false) {
				tf.setText("");
				tf.setText(tf.getText()+0);
				mTF = true;
				mEq = true;
			} else {
				tf.setText(tf.getText()+0);
				mTF = true;
				 mEq = true;
			}
		   }
		});
		
		one.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+1);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+1);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		two.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+2);
   				mTF = true;
			 	mEq = true;
   			} else {
   				tf.setText(tf.getText()+2);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		three.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+3);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+3);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		four.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+4);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+4);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		five.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+5);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+5);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		six.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+6);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+6);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		seven.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+7);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+7);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		eight.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+8);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+8);
   				mTF = true;
				mEq = true;
   			}
		   }
		});
		
		nine.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
   			if (mTF == false) {
   				tf.setText("");
   				tf.setText(tf.getText()+9);
   				mTF = true;
				mEq = true;
   			} else {
   				tf.setText(tf.getText()+9);
   			        mTF = true;
				mEq = true;
   			}
		   }
		});
		
		dot.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		      if (mTF == false) { 
				if(mDot == false) {
					tf.setText("");
					tf.setText(tf.getText()+".");
					mDot = true;
					mTF = true;
					mEq = true;
				} else {
					System.out.println("Double dot");
				}
			} else {
				if(mDot == false) {
					tf.setText(tf.getText()+".");
					mDot = true;
					mTF = true;
					mEq = true;
				} else {
					System.out.println("Double dot");
				}
			}
			
		   }
		});
		
		
		//	EQUAL
		equal.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		      if (mEq == false) {
			      System.out.println("'=' can't be first");
		      } else {
		       myValueTwo = Double.parseDouble(tf.getText() + "");
		       if (mAdd == true) {
			       tf.setText(Math.adding(myValueOne,myValueTwo) + "");
			       mAdd = false;
		       }
		       if (mSub == true) {
			       tf.setText(Math.subtraction(myValueOne,myValueTwo) + "");
			       mSub = false;
		       }
		       if (mMul == true) {
			       tf.setText(Math.multiplication(myValueOne,myValueTwo) + "");
			       mMul = false;
		       }
		       if (mDiv == true) {
			       tf.setText(Math.division(myValueOne,myValueTwo) + "");
			       mDiv = false;
		       }
		      if (mPow == true) {
			       tf.setText(Math.power(myValueOne,myValueTwo) + "");
			       mPow = false;
		       }
       		      if (mSqroot == true) {
       			       tf.setText(Math.root(myValueOne,(int)myValueTwo) + "");
   			       mSqroot = false;
       		       }
		       // 1st number is base, 2nd number is log. number
		       if (mLog == true) { 
        		       tf.setText(Math.logarithm(myValueOne,myValueTwo) + "");
    			       mLog = false;
        	       }
		       mTF = false;
		       mDot = false;
		       mEq = true;
	       	       }
		   }
		});	
		
		
		//	ADDITION	
		add.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mAdd = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
	
		//	SUBTRACTION
		sub.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mSub = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		//	MULTIPLICATION	
		multi.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mMul = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		//	DIVISION
		div.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (tf == null) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mDiv = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		//	FACTORIAL
		factorial.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			tf.setText(null);
			tf.setText(Math.factorial(myValueOne) + "");
			mDot = false;
			mTF = false;
			mEq = true;
			}
			
		   }
		});
		
		//	POWER
		power.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mPow = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		//	SQUARE ROOT
		sqroot.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mSqroot = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		//	LOGARITHM
		log.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		       if (mEq == false) {
			tf.setText("");
			} else {
			myValueOne = Double.parseDouble(tf.getText() + "");
			mLog = true;
			tf.setText(null);
			mDot = false;
			mEq = false;
			}
			
		   }
		});
		
		ce.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
		        tf.setText("");
			mDot = false;
			mEq = false;
		   }
		});
		
		
	} //End of Gui()

public static void main(String[] args) {
	new calculator();	
	}
} //End of program
