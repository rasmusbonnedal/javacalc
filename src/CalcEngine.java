/**
 * CalcEngine is responsible for the logic of the calculator. It takes commands
 * corresponding to calculator buttons and returns the string do be displayed 
 * in the calculator window.
 */

public class CalcEngine
{
	public enum Commands {
		ONE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		ZERO(0),
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE,
		EQUAL,
		NONE;

		// Value is the digit of the command, -1 for operations.
		private int _value;

		private Commands() {
			_value = -1;
		}

		private Commands(int value) {
			_value = value;
		}

		public boolean isValue() {
			return _value != -1;
		}

		public int getValue() {
			return _value;
		}
	}

	private int _currentValue;
	private int _storedValue;
	private Commands _nextOperation;
	private boolean _hasCurrentValue;

	public CalcEngine() {
		_currentValue = 0;
		_storedValue = 0;
		_nextOperation = Commands.NONE;
		_hasCurrentValue = false;
	}

	public void sendCommand(Commands command) {
		if (command.isValue()) {
			_currentValue = _currentValue * 10 + command.getValue();
			_hasCurrentValue = true;
		} else {
			doOperation();
			_nextOperation = command;
		}
	}

	private void doOperation() {
		if (_hasCurrentValue) {
			switch(_nextOperation) {
				case ADD :
					_currentValue += _storedValue;
					break;
				case SUBTRACT :
					_currentValue = _storedValue - _currentValue;
					break;
				case MULTIPLY :
					_currentValue = _storedValue * _currentValue;
					break;
				case DIVIDE :
					_currentValue = _storedValue / _currentValue;
					break;
			}
			_storedValue = _currentValue;
			_currentValue = 0;
			_hasCurrentValue = false;
		}
	}

	public String getResult() {
		return Integer.toString(_hasCurrentValue ? _currentValue : _storedValue);
	}
};
