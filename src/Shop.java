import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop implements toMakeOrder{

    public Map sortOfTea;
    public Map blackTea;
    public Map greenTea;
    public List ordersList;

    public Shop() {
        blackTea = new HashMap<String, Tea>();
        greenTea = new HashMap<String, Tea>();
        sortOfTea = new HashMap<String, Map <String, Tea>>();
        ordersList = new ArrayList();
    }

    @Override
    public void toMakeOrder(String str, Map map) {
        if (map.containsKey(str)) {
            ordersList.add(map.get(str));
        }
    }

    @Override
    public Object CheckAndChooseTea(String str, Map map) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    @Override
    public void toShowTea(Map map) {
        System.out.println(map.values());
    }

    @Override
    public String toCollectOrder() {
        int sum = 0;
        for (int i = 0; i < ordersList.size(); i++) {
            sum +=  ((Tea) ordersList.get(i)).price;
        }
        return "Your order is" + this.ordersList + "\n" + "Bill is " + sum;
    }
}
