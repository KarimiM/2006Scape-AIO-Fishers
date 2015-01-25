package com.scape06.fishing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207874311091582181L;
	private JPanel contentPane;
	JCheckBox powerfish = new JCheckBox();
	String[] comboTypes = { "Shrimp", "Lobsters", "Tuna/Swordfish", "Sharks" };
	JComboBox comboTypesList = new JComboBox(comboTypes);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setTitle("2006Scape Pro Fisher");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Create the combo box
		comboTypesList.setBounds(100, 97, 100, 20);
		contentPane.add(comboTypesList);

		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex(e);
			}
		});
		start.setBounds(105, 227, 89, 23);
		contentPane.add(start);

		powerfish.setText("Powerfish");
		powerfish.setBounds(113, 164, 100, 20);
		contentPane.add(powerfish);

		JLabel label = new JLabel("Choose Fish (Catherby)", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.ITALIC, 16));
		label.setBounds(78, 66, 154, 20);
		contentPane.add(label);

	}

	private void selectedIndex(ActionEvent e) {
		if (powerfish.isSelected()) {
			MainData.powerFish = true;
			MainData.strMode = "Powerfishing";
		}
		else {
			MainData.strMode = "Banking";
		}
		switch (comboTypesList.getSelectedIndex()) {
		case 0:// shrimps
			MainData.strType = "Shrimps";
			MainData.spotId = FishingData.SHRIMP.getSpotId();
			MainData.interact = FishingData.SHRIMP.getInteract();
			MainData.fishIds = FishingData.SHRIMP.getFishIds();
			MainData.toolId = FishingData.SHRIMP.getToolId();
			MainData.start = true;
			this.dispose();
			break;
		case 1:// lobsters
			MainData.strType = "Lobsters";
			MainData.spotId = FishingData.LOBSTER.getSpotId();
			MainData.interact = FishingData.LOBSTER.getInteract();
			MainData.fishIds = FishingData.LOBSTER.getFishIds();
			MainData.toolId = FishingData.LOBSTER.getToolId();
			MainData.start = true;
			this.dispose();
			break;
		case 2:// swordfishes
			MainData.strType = "Swordfishes";
			MainData.spotId = FishingData.SWORDFISH.getSpotId();
			MainData.interact = FishingData.SWORDFISH.getInteract();
			MainData.fishIds = FishingData.SWORDFISH.getFishIds();
			MainData.toolId = FishingData.SWORDFISH.getToolId();
			MainData.start = true;
			this.dispose();
			break;
		case 3:// sharks
			MainData.strType = "Sharks";
			MainData.spotId = FishingData.SHARK.getSpotId();
			MainData.interact = FishingData.SHARK.getInteract();
			MainData.fishIds = FishingData.SHARK.getFishIds();
			MainData.toolId = FishingData.SHARK.getToolId();
			MainData.start = true;
			this.dispose();
			break;

		}
	}
}
