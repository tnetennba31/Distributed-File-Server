package menuStateMachine;

/**
 * This is just another example of what a menu state can look like.
 * 
 * @author merlin
 *
 */
public class OpenWriteMenuState extends State
{

	private MenuOption[] myMenuOptions =
		{ new MenuOptionForAction("Append to File", new WriteAppendAction(), OpenWriteMenuState.class),
				new MenuOptionForAction("Replace Line in File", new WriteLineAction(), OpenWriteMenuState.class),
				new MenuOptionForMenu("Go Back", StartState.class),
				new MenuOptionForMenu("Exit", EndState.class) };
	
	/**
	 * 
	 */
	public OpenWriteMenuState()
	{
		super.loadMenu(myMenuOptions);
	}
}
