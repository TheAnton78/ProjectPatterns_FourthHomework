import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    protected List<Tovar> catalog = new ArrayList<>();
    private Basket customerBasket = new Basket();

    public boolean addTovar(Tovar tovar){
        return catalog.add(tovar);
    }

    public String showCatalog(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Tovar elem : catalog){
            stringBuilder.append(elem.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Tovar> search(String word){
        return catalog.stream()
                .filter(x -> x.toString().contains(word))
                .collect(Collectors.toList());
    }

    public List<Tovar> filterByPrice(int lowerLimitPrice, int upperLimitPrice) {
        return catalog.stream()
                .filter(x -> x.getPrice() >= lowerLimitPrice && x.getPrice() <= upperLimitPrice)
                .collect(Collectors.toList());
    }

    public List<Tovar> sortByPrice(){
        return catalog.stream().sorted(new Comparator<Tovar>() {
            @Override
            public int compare(Tovar o1, Tovar o2) {
                return Integer.compare(o1.price, o2.price);
            }
        }).collect(Collectors.toList());
    }

    public Basket getBasket(){
        return customerBasket;
    }

    public boolean addTovarToBasket(String tovarName, int amount){
        for(Tovar elem : catalog){
            if(elem.getName().equalsIgnoreCase(tovarName)){
                return customerBasket.addTovar(elem, amount);
            }
        }
        return false;
    }

    public boolean buyBasket(float money){
        return customerBasket.canBuy(money);
    }
}
