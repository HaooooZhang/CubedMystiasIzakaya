package team.cztouhou.cmi.item;

import java.util.ArrayList;
import java.util.List;

public interface allaffects {
    public static List getlist(){
        List list = new ArrayList<String>(5);
        list.add("spicy");
        list.add("sour");
        return list;
        //return List.of("spicy");
    }
}