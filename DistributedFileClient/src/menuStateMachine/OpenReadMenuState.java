package menuStateMachine;

/**
 * Just one more example of a menu state
 * 
 * @author merlin
 *
 */
public class OpenReadMenuState extends State
{
	 private MenuOption[] myMenuOptions =
		{ new MenuOptionForAction("Let's Read!", new ReadAction(), OpenReadMenuState.class),
				new MenuOptionForMenu("Go Back", StartState.class), 
				new MenuOptionForMenu("Exit", EndState.class) };

	/**
	 * 
	 */
	public OpenReadMenuState()
	{
		super.loadMenu(myMenuOptions);
	}
}