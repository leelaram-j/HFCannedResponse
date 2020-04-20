package utils;

import java.util.Iterator;
import java.util.Set;

public class WindowSwitcher
{


    public static String getParentWindow(Set<String> s)
    {
        Iterator<String> id = s.iterator();
        String parentWindow  = id.next();
        return parentWindow;
    }

    public static String getChildWindow(Set<String> s)
    {
        Iterator<String> id = s.iterator();
        id.next();
        String childWindow = id.next();
        System.out.println(childWindow+"***");
        return childWindow;
    }
}
