package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard & Christophe Chichmanian & Charlotte Bénard & François Mouton
 * @version 1.0
 */
public class Menu {
	
	/** The level choose. */
	public int level;
	
	/** The boolean choice. */
	public boolean choix = false;
	
	/**
     * Instantiates a new menu.
     * 
     */
	public Menu() {

		JFrame frame = new JFrame("Lorann Launcher");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\Menu.png"));
		JLabel label1 = new JLabel("Niveau :  ");
		label1.setForeground(Color.WHITE);
		
		JTextField niveau = new JTextField("");
		niveau.setPreferredSize(new Dimension(175, 30));
		niveau.setBackground(Color.WHITE);

		JButton button = new JButton();
		button.setText("Jouer");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(niveau.getText()) >0 && Integer.parseInt(niveau.getText()) < 6) {
					level = Integer.parseInt(niveau.getText());
					choix = true;
					frame.setVisible(false);
				}	
			}
		});
		
		panel.add(label);
		panel.add(label1);
		panel.add(niveau);
		panel.add(button);
		
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.BLACK);
		frame.setVisible(true);

	}
}