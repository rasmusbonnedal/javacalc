import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainWindow is responsible for creating the Calculator UI, passing button
 * presses to the CalcEngine and displaying the result from CalcEngine.
 */

public class MainWindow {
	private JLabel _textField;
	private CalcEngine _calcEngine;

	public MainWindow(CalcEngine calcEngine) {
		_calcEngine = calcEngine;
	}

	private void createButton(String label, CalcEngine.Commands command, int x, int y, JPanel panel) {
		GridBagConstraints c = new GridBagConstraints();
		JButton button = new JButton(label);
		c.gridx = x;
		c.gridy = y;
		panel.add(button, c);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_calcEngine.sendCommand(command);
				_textField.setText(_calcEngine.getResult());
			}
		});
	}

	public void buildGUI() {
		JFrame frame = new JFrame("JavaCalc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainpanel = new JPanel(new BorderLayout());
		frame.add(mainpanel);

		// TODO: Text field should be right aligned.
		_textField = new JLabel(_calcEngine.getResult());
		mainpanel.add(_textField, BorderLayout.NORTH);
		JPanel buttonpanel = new JPanel(new GridBagLayout());
		mainpanel.add(buttonpanel, BorderLayout.SOUTH);

		createButton("1", CalcEngine.Commands.ONE, 0, 0, buttonpanel);
		createButton("2", CalcEngine.Commands.TWO, 1, 0, buttonpanel);
		createButton("3", CalcEngine.Commands.THREE, 2, 0, buttonpanel);
		createButton("+", CalcEngine.Commands.PLUS, 3, 0, buttonpanel);
		createButton("=", CalcEngine.Commands.EQUAL, 3, 1, buttonpanel);

		frame.pack();
		frame.setVisible(true);
	}
};
