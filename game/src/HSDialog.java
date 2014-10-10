import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class HSDialog extends JDialog {
	
	public HSDialog(final JFrame parent, boolean modal) {
		super(parent, modal);
		JButton asdf = new JButton("sadasdadssadsad");
		asdf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
                setVisible(false);
			}
		});
		asdf.setBounds(10, 10, 20, 20);
		add(asdf);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1206, 629));
		
		pack();
		setLocation(100,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
