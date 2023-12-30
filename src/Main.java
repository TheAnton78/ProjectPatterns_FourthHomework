import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        shop.addTovar(new ElectronicDevices("Телевизор", 15_000, 3));
        shop.addTovar(new ElectronicDevices("Смартфон", 25_000, 4));
        shop.addTovar(new Clothes("Кофта", 5_000, 5));


        boolean flag = true;
        while(flag){
            showMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "0":
                    flag = false;
                case "1":
                    System.out.println(shop.showCatalog());
                    break;
                case "2":
                    System.out.println("Введите название товара, который хотите добавить в корзину: ");
                    String tovarName = scanner.nextLine();
                    System.out.println("Введите необходимое количество: ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    if (shop.addTovarToBasket(tovarName, amount)){
                        System.out.println("Товар добавлен");
                    }else{
                        System.out.println("Error. Try again");
                    }
                    break;
                case "3":
                    System.out.println(shop.getBasket().showBasket());
                    break;
                case "4":
                    Basket basket = shop.getBasket();
                    System.out.printf("В вашей корзине %d товаров на сумму %.2f рублей\nВвнесите деньги: ", basket.getSize(), basket.sumOfCosts());
                    int money = Integer.parseInt(scanner.nextLine());
                    if(shop.buyBasket(money)){
                        System.out.printf("Вы успешно приобрели все товары, ваша сдача %.2f rub\n", money - basket.sumOfCosts());
                        basket.clean();
                    } else{
                        System.out.println("Error. Try again");
                    }
                    break;
                case "5":
                    System.out.println("Введите слово: ");
                    String word = scanner.nextLine();
                    shop.search(word).forEach(System.out::println);
                    break;
                case "6":
                    System.out.print("Введите нижнюю границу цены: ");
                    int lowLimit = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите верхнюю границу цены: ");
                    int upLimit = Integer.parseInt(scanner.nextLine());
                    shop.filterByPrice(lowLimit, upLimit).forEach(System.out::println);
                    break;
                case "7":
                    shop.sortByPrice().forEach(System.out::println);
            }

        }


    }

    public static void showMenu(){
        System.out.println("""
                Введите:
                1 - Вывод доступных для покупки товаров
                2 - Добавить товар в корзину
                3 - Посмотреть корзину
                4 - Купить товары из корзины
                5 - Поиск по ключевому слову
                6 - Филтр по цене
                7 - Сортировать по убыванию цены
                0 - ВЫХОД""");
    }
}
