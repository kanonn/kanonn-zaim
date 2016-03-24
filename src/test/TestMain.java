package test;

import inst.input.panel.InputFinance;

import javax.swing.JFrame;

public class TestMain extends JFrame {

	public static void main(String[] args) {
		TestMain tester = new TestMain();
		
		InputFinance panel = new InputFinance();
		tester.add(panel.getPagePanel());
		
		tester.setVisible(true);
		tester.setSize(500, 300);
		tester.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
