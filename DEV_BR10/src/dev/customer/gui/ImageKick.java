package dev.customer.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageKick {
	public ImageIcon ImageKickButton(String address, int width, int height) {
		Image img = new ImageIcon(address).getImage().getScaledInstance(width, height, 4);
		ImageIcon icon = new ImageIcon();
		icon.setImage(img);
		return icon;
}
}
