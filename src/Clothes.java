import java.util.Scanner;

public class Clothes extends Tovar implements Sizeable{
    public boolean isWeighed = false;
    public float availability;

    public Clothes(String name, int price, float availability){
        super(name, price);
        this.availability = availability;
    }
    @Override
    public String toString() {
        return String.format("%s , по цене %d за шт", name, price);
    }

    @Override
    public boolean canBuy(int amount) {
        availability -= amount;
        return availability >= 0 && setSize();
    }

    @Override
    public float getCost(int amount) {
        return amount * price;
    }

    @Override
    public boolean setSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер:");
        String size = scanner.nextLine();
        return !size.equals("");
    }
}
