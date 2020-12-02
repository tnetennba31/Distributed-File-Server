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
		{ new MenuOptionForAction("Let's Write!", new WriteAction(), OpenWriteMenuState.class),
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
