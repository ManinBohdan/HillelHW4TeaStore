import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        // Creating an object of Tea Store
        var teaStore = new Shop();
        // Filling map of black tea
        teaStore.blackTea.put("Black", new Tea("Black", 15));
        teaStore.blackTea.put("BlackWithStrawberry", new Tea("BlackWithStrawberry", 20));
        teaStore.blackTea.put("BlackWithGinger", new Tea("BlackWithGinger", 25));
        // Filling map of green tea
        teaStore.greenTea.put("Green", new Tea("Green", 17));
        teaStore.greenTea.put("GreenWithLime", new Tea("GreenWithLime", 21));
        teaStore.greenTea.put("GreenWithLemonAndHoney", new Tea("GreenWithLemonAndHoney", 27));
        // Filling map of sorts of tea with green tea and black tea maps
        teaStore.sortOfTea.put("Green", teaStore.greenTea);
        teaStore.sortOfTea.put("Black", teaStore.blackTea);
        // Print our greetings
        System.out.println("Hello! What do you like to drink?");
        System.out.println("We can offer you Green tea or Black tea");
        // initialization of boolean variable.
        boolean continueOrders = true;
        // Start the loop of ordering
        while (continueOrders) {
            System.out.println("Choose type of tea: ");
            // Enter the type of tea
            String teaType = String.valueOf(READER.readLine());
            // In this method we print all values of the map.
            // Method CheckAndChooseTea(String str, Map map) check if key exist and return the map which match wit a key we entered.
            teaStore.toShowTea((Map) teaStore.CheckAndChooseTea(teaType, teaStore.sortOfTea));
            System.out.println("Choose a tea please: ");
            // Enter the specific tea from available.
            String teaChoose = String.valueOf(READER.readLine());
            // Getting a map which match with a key teaType from sortOfTea. And then getting the element from this map which match with key teaChoose.
            // Adding element we got from the map to ArrayList.
            teaStore.toMakeOrder(teaChoose, (Map) teaStore.CheckAndChooseTea(teaType, teaStore.sortOfTea));
            // Print offer about continue ordering
            System.out.println("Do you want to order one more tea?  Y/N");
            // Check what value user entered
            if (String.valueOf(READER.readLine()).equals("N"))
            // If user entered N, loop would be finished
                continueOrders = false;
        }
        // Use foreach loop for making all tea from orderList.
        for (Object object:teaStore.ordersList) {
            Tea tea = (Tea) object;
            tea.toMakeTea();
        }
        // Print the final price for the order by sum all prices of element in the loop.
        System.out.println(teaStore.toCollectOrder());

    }
}
