/**
 * CalcEngine is responsible for the logic of the calculator. It takes commands
 * corresponding to calculator buttons and returns the string do be displayed 
 * in the calculator window.
 */

public class CalcEngine
{
	public enum Commands {
		ONE,
		TWO,
		THREE,
		PLUS,
		EQUAL,
		NONE
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
		switch(command) {
			case ONE :
				_currentValue = _currentValue * 10 + 1;
				_hasCurrentValue = true;
				break;
			case TWO :
				_currentValue = _currentValue * 10 + 2;
				_hasCurrentValue = true;
				break;
			case THREE :
				_currentValue = _currentValue * 10 + 3;
				_hasCurrentValue = true;
				break;
			case PLUS :
				doOperation();
				_nextOperation = command;
				break;
			case EQUAL :
				doOperation();
				_nextOperation = command;
				break;
		}
	}

	private void doOperation() {
		if (_hasCurrentValue) {
			switch(_nextOperation) {
				case PLUS :
					_currentValue += _storedValue;
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
