package com.mitrais.cdc.java;

import javax.swing.JFrame;

public class ColorFrame7 extends JFrame{

	 public ColorFrame7() {
	    super("Number 7");
	    setContentPane(new ColorPanel7());
	    setSize(600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new ColorFrame7();
	}

}
