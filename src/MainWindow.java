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
	private Boolean _interfaceEnabled;

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

	private static void enableButtons(Boolean b, JPanel panel) {
		Component [] component = panel.getComponents();
		for (int i=0; i<component.length; i++) {
			component[i].setEnabled(b);
		}
	}

	public void buildGUI() {
		JFrame frame = new JFrame("JavaCalc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainpanel = new JPanel(new BorderLayout());
		frame.add(mainpanel);

		_interfaceEnabled = false;
		JButton onOffButton = new JButton("OFF");
		mainpanel.add(onOffButton, BorderLayout.NORTH);

		// TODO: Text field should be right aligned.
		_textField = new JLabel(_calcEngine.getResult());
		mainpanel.add(_textField, BorderLayout.CENTER);
		JPanel buttonpanel = new JPanel(new GridBagLayout());
		mainpanel.add(buttonpanel, BorderLayout.SOUTH);

		createButton("1", CalcEngine.Commands.ONE, 0, 0, buttonpanel);
		createButton("2", CalcEngine.Commands.TWO, 1, 0, buttonpanel);
		createButton("3", CalcEngine.Commands.THREE, 2, 0, buttonpanel);
		createButton("4", CalcEngine.Commands.FOUR, 0, 1, buttonpanel);
		createButton("5", CalcEngine.Commands.FIVE, 1, 1, buttonpanel);
		createButton("6", CalcEngine.Commands.SIX, 2, 1, buttonpanel);
		createButton("7", CalcEngine.Commands.SEVEN, 0, 2, buttonpanel);
		createButton("8", CalcEngine.Commands.EIGHT, 1, 2, buttonpanel);
		createButton("9", CalcEngine.Commands.NINE, 2, 2, buttonpanel);
		createButton("0", CalcEngine.Commands.ZERO, 0, 3, buttonpanel);
		createButton("+", CalcEngine.Commands.ADD, 3, 0, buttonpanel);
		createButton("-", CalcEngine.Commands.SUBTRACT, 3, 1, buttonpanel);
		createButton("*", CalcEngine.Commands.MULTIPLY, 3, 2, buttonpanel);
		createButton("/", CalcEngine.Commands.DIVIDE, 3, 3, buttonpanel);
		createButton("=", CalcEngine.Commands.EQUAL, 3, 4, buttonpanel);

		enableButtons(false, buttonpanel);

		onOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_interfaceEnabled = !_interfaceEnabled;
				onOffButton.setText(_interfaceEnabled ? "ON" : "OFF");
				enableButtons(_interfaceEnabled, buttonpanel);
				buttonpanel.repaint();
			}
		});

		frame.pack();
		frame.setVisible(true);
	}
};
