public class Crater extends OutdoorsArea{

    public Crater(String name) {
        super(name);
        Item facklan = new Torch("facklan");
        setHiddenTreasure(facklan);
    }

    @Override
    public void describeYourself() {
        if(!getBeenHere()){
            System.out.println("\nDu anländer till en krater på månen. Det finns inte ett tecken på\n"
            		+ "liv här. Kanske gömmer sig nåt underjord?");
            directions();
            printItems(getItems());
            setBeenHere(true);
        } else {
            System.out.println("\nTillbaka i kratern.");
            directions();
        }
    }
}
