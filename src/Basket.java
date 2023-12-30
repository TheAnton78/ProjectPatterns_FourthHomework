import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
    private Map<Tovar, Integer> shoppingBasket = new HashMap<>();


    public boolean addTovar(Tovar tovar, int amount){
        return shoppingBasket.put(tovar, amount) == null;
    }

    public float sumOfCosts(){
        float summ = 0;
        List<Float> result = shoppingBasket.entrySet()
                .stream()
                .map(x -> x.getKey().getCost(x.getValue()))
                .collect(Collectors.toList());
        for (Float elem : result){
            summ += elem;
        }
        return summ;
    }

    public int getSize(){
        return shoppingBasket.size();
    }

    public String showBasket(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Tovar elem : shoppingBasket.keySet()){
            stringBuilder.append(" " + elem.getName()).append(" - ").append(shoppingBasket.get(elem)).append("шт");
        }
        return "\nТовары:" + stringBuilder.toString() + "\nна сумму: " + sumOfCosts();
    }

    public boolean canBuy(float money){
        return sumOfCosts() <= money && shoppingBasket.entrySet().stream().allMatch(x -> x.getKey().canBuy(x.getValue()));
    }

    public void clean(){
        shoppingBasket.clear();
    }

}
