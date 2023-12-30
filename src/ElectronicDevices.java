import java.util.Scanner;

public class ElectronicDevices extends Tovar implements  Warranty{
    public float availability;



    public ElectronicDevices(String name, int price, float availability){
        super(name, price);
        this.availability = availability;
    }
    @Override
    public boolean canBuy(int amount){
        availability -= amount;
        return availability >= 0 && setPersonalData();
    }

    @Override
    public float getCost(int amount) {
        return amount * price;
    }

    @Override
    public String toString() {
        return String.format("%s , по цене %d за шт", name, price);
    }

    @Override
    public boolean setPersonalData() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите ФИО и номер телефона для гарантийного талона: ");
        String data = scaner.nextLine();
        return data.split(" ").length >= 4;
    }
}
