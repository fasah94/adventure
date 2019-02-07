public class SpaceStation extends Room {

    public SpaceStation(String name) {
        super(name);
    }

    @Override
    public void describeYourself() {
        if(!getBeenHere()){
            System.out.println("\nGalaxer i mina braxer! Det är dags att vakna för att utforska rymden.\n"
            		+ "Du stiger upp ur din säng på rymdstationen. Du känner att idag\n"
            		+ "blir ett äventyr. Det ligger i luften. För att få hjälp med vad du kan göra skriv\n"
            		+ "in kommandot 'help'.");
            directions();
            printItems(getItems());
            setBeenHere(true);
        } else {
            System.out.println("\nTillbaka på rymdstationen");
            printItems(getItems());
            directions();
        }
    }
}