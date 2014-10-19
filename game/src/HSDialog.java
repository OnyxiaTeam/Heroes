import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class HSDialog extends JDialog {

	ImageIcon background = new ImageIcon("images/hs-bg.png");
	
	public HSDialog(final JFrame parent, boolean modal) {
		super(parent, modal);
		JButton startButton = new JButton("START GAME");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
                setVisible(false);
			}
		});
		startButton.setBounds(20,20,150,40);
		add(startButton);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1206, 629));
		
		pack();
		setLocation(100,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawImage(background.getImage(), 0, 0, null);
	}
}
