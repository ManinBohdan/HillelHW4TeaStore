public class Tea implements toMakeATea{

    public String name;
    public int price;

    public Tea(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void toMakeTea() {
        System.out.println( this.name + " is made");
    }

    @Override
    public String toString () {
        return this.name + " - " + this.price;
    }
}
