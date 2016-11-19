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
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		ZERO,
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE,
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
			case FOUR :
				_currentValue = _currentValue * 10 + 4;
				_hasCurrentValue = true;
				break;
			case FIVE :
				_currentValue = _currentValue * 10 + 5;
				_hasCurrentValue = true;
				break;
			case SIX :
				_currentValue = _currentValue * 10 + 6;
				_hasCurrentValue = true;
				break;
			case SEVEN :
				_currentValue = _currentValue * 10 + 7;
				_hasCurrentValue = true;
				break;
			case EIGHT :
				_currentValue = _currentValue * 10 + 8;
				_hasCurrentValue = true;
				break;
			case NINE :
				_currentValue = _currentValue * 10 + 9;
				_hasCurrentValue = true;
				break;
			case ZERO :
				_currentValue = _currentValue * 10;
				_hasCurrentValue = true;
				break;
			case ADD :
				doOperation();
				_nextOperation = command;
				break;
			case SUBTRACT :
				doOperation();
				_nextOperation = command;
				break;
			case MULTIPLY :
				doOperation();
				_nextOperation = command;
				break;
			case DIVIDE :
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
