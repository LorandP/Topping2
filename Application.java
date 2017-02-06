import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lori on 2/6/2017.
 */
public class Application {

    /**
     * This method receives a java map, modifies it and returns the modified version of the map.
     *
     * @param map the map that is being provided.
     * @return the modified or unmodified map.
     */
    private Map<String, String> topping3(Map<String, String> map)
    {
        String fries;
        String spinach;

        if ((map.get("potato") == null || map.get("salad") == null))
        {
            fries = stringValueOrEmpty(map, "potato");
            spinach = stringValueOrEmpty(map, "salad");
            map.put("fries", fries);
            map.put("spinach", spinach);
        }
        else
        {
            map.put("fries", map.get("potato"));
            map.put("spinach", map.get("salad"));
        }
        return map;
    }

    /**
     * This method is used to verify the value of the given key.
     * If the value is null, change it to empty.
     * Else convert it to string.
     *
     * @param map the map in which we find the key and value.
     * @param key the key that we will verify the value from.
     * @return the modified value.
     */

    private String stringValueOrEmpty(Map<String,String> map, String key)
    {
        String value = map.get(key);
        return value == null ? "" : value;
    }

    public static void main (String[] args)
    {
        Application application = new Application();
        Map<String, String> map = new HashMap<String, String>();
        map.put("salad", null);
        map.put("potato",null);

        Set set = application.topping3(map).entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext())
        {
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }

    }
}
