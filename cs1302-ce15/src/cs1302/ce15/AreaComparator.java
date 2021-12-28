package cs1302.ce15;
import java.util.*;

public class AreaComparator implements Comparator<Circle>{

    public AreaComparator() {

    }

    public int compare(Circle o1, Circle o2) {
        return Double.compare(o2.getArea(), o1.getArea());
    }
}
