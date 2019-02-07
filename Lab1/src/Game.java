import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {

    private static Player player;
    private static ArrayList<Location> world = new ArrayList<>();
    private Scanner reader = new Scanner(System.in);

    public Game() {
        createWorld();
    }

    public void run(){
        System.out.println("Välkommen Månfarare!\nVad heter du? ");
        String name = reader.nextLine();
        String command;
        player = new Player(name, world);

        player.currentPos().describeYourself();
        doWhat();

        while (true) {
            command = reader.nextLine();
            doCommand(command, player);
            doWhat();

            //player.printEquipment();

        }


    }

    public void createWorld(){
        Location one = new SpaceStation("rymdstation");
        Location two = new LandingZone("landningszon");
        Location three = new Crater("krater");
        Location four = new Tunnel("tunnel");
        Location five = new Shipwreck("vrak");

        Collections.addAll(world, one, two, three, four, five);

        one.addPaths(two, null, null, null);
        two.addPaths(four, null, one, three);
        three.addPaths(null, two, null, null);
        four.addPaths(five, null, two, null);
        five.addPaths(null, null, four, null);
    }


    public void doCommand(String command, Player player) {
        if (command.toUpperCase().equals("HELP")) {
            System.out.println("Här kommer några tips på olika kommandon!\n"
            		+ "För att välja en riktning att färdas i använder du vädeerstrecks som kommandon.\n"
            		+ "T. ex. 'norr' eller 'söder'. För att plocka upp föremål använder du kommandot 'ta'\n"
            		+ "följt av föremålet. T. ex. 'ta spaden'. När du har en spade kan du gräva med kommandot\n"
            		+ "'gräv'. Andra redskap kan brukas med 'använd' och utrustning tas på med 'bär'.\n"
            		+ "T. ex. 'använd facklan' eller 'bär byxor'. För att se vilka föremål du äger skriv in 'föremål'.\n"
            		+ "Skriv in 'utrustning' för att se vad du har på dig. Se dig omkring där du är med 'titta'.\n"
            		+ "Denna hjälpmeny tas alltid fram med kommandot 'help'. Stäng programmet med 'exit'.");
        } else if (command.toUpperCase().equals("EXIT")){
            System.out.println("Exiting program.");
            System.exit(0);
        }
        else {
            player.currentPos().doCommand(command, player);
        }
    }

    public void doWhat(){
        System.out.print("\nVad vill du göra? ");
    }
}
