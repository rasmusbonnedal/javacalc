import javax.swing.*;

public class JavaCalc {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create a CalcEngine and a MainWindow and start the program.
				CalcEngine calcEngine = new CalcEngine();
				MainWindow mainWindow = new MainWindow(calcEngine);
				mainWindow.buildGUI();
			}
		});
	}
};
