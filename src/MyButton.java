import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton {
	private String nextPanelName;
	private int size, sizeScaled;

	public MyButton(String name, String nextPanel, int size, int sizeScaled, ActionListener aL) {
		super(name);
		this.size = size;
		this.sizeScaled = sizeScaled;

		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, size));
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if ((e.getSource() instanceof MyButton) && ((MyButton) (e.getSource())).isEnabled())
					SoundManager.mouseOver();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (e.getSource() instanceof MyButton)
					((MyButton) (e.getSource())).setFont(new Font("Arial", Font.PLAIN, ((MyButton) e.getSource()).getDefaultSize()));
//		else if (e.getSource() instanceof JLabel)
//			((JLabel) (e.getSource())).setFont(new Font("Arial", Font.PLAIN, 40));
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				if (e.getSource() instanceof MyButton)
					if (((MyButton) (e.getSource())).isEnabled())
						((MyButton) (e.getSource())).setFont(new Font("Arial", Font.PLAIN, ((MyButton) e.getSource()).getSizeScaledize()));
//			else if (e.getSource() instanceof JLabel)
//				((JLabel) (e.getSource())).setFont(new Font("Arial", Font.PLAIN, 50));
			}
		});
		
		this.nextPanelName = nextPanel;
		addActionListener(aL);
	}

	public int getDefaultSize() {
		return size;
	}

	public int getSizeScaledize() {
		return sizeScaled;
	}

	public String getNextPanelName() {
		return nextPanelName;
	}
}
