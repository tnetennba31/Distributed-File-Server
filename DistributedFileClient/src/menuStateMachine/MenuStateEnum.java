package menuStateMachine;

public enum MenuStateEnum
{
	START_MENU(new StartState()),
	OPEN_READ_MENU(new OpenReadMenuState()),
	OPEN_WRITE_MENU(new OpenWriteMenuState()),
	END_STATE(new EndState());
	
	private State state;

	MenuStateEnum(State s)
	{
		this.state = s;
	}
	
	public State getState()
	{
		return state;
	}
}
