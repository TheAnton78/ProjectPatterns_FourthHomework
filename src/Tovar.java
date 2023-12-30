abstract class Tovar {
    protected final int price;
    protected final String name;

    public Tovar(String name, int price){
        this.name = name;
        this.price = price;
    }

    abstract boolean canBuy(int numOfTovar);
    abstract float getCost(int numOfTovar);

    public float getPrice(){
        return price;
    }

   public String getName(){
        return name;
   }



}
