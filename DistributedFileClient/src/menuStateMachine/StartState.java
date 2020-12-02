package menuStateMachine;

/**
 * This is the state that the machine starts in.  In other words, it is the highest level menu
 * @author merlin
 *
 */
public class StartState extends State
{

	private static final MenuOption[] x =
		{ new MenuOptionForMenu("Open For Read", OpenReadMenuState.class),
				new MenuOptionForMenu("Open For Write", OpenWriteMenuState.class),
				new MenuOptionForMenu("Exit", EndState.class) };

	/**
	 * 
	 */
	public StartState()
	{

		super.loadMenu(x);
	}

}