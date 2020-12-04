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
		{ new MenuOptionForAction("Read an Entire File", new ReadAllAction(), OpenReadMenuState.class),
				new MenuOptionForAction("Read a Record From a File", new ReadRecordAction(), OpenReadMenuState.class),
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