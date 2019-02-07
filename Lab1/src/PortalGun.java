import java.util.Scanner;

public class PortalGun extends Tool {
	
	private Scanner reader = new Scanner(System.in);

	public PortalGun(String name) {
		super(name);
		setWeight(10);
		setPrice(75);
	}

	public void use(Player player, int val) {	
		player.moveTo(player.getWorld().get(val));
		System.out.println("Du har anlänt till " + player.currentPos().getName() + ". Alla dina föremål försvann någonstans på vägen.");
		player.getItems().clear();
	}

	@Override
	public void doCommand(String s, Item i, Player p) {
		int index = 1;
		System.out.println("Du trycker på en stor grön knapp på portalpickadollen och hela\n"
				+ "manicken börjar blinka frenetiskt, efter cirkagurka 5 sekunder\n"
				+ "så slocknar den och skärmen visar några alternativ:");
		
		System.out.println("\n--- VÄLJ DESTINATION ---");
		
		for(Location loc : p.getWorld()) {
			System.out.print(index + ". ");
			System.out.println(loc.getName());
			index ++;
		}
		
		String val = reader.nextLine();
		int input = Integer.parseInt(val) - 1;
		
		use(p, input);
    }
}
