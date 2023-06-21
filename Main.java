
import java.util.*;
import java.util.ArrayList;
class Main {
    public static void main(String[] args)
    {
        ArrayList<Integer> my_list = new ArrayList<Integer>();
        my_list.add(10);
        my_list.add(80);
        my_list.add(30);
        my_list.add(70);
        my_list.add(5);
        my_list.add(90);
        my_list.add(19);
        my_list.add(25);

        Collections.shuffle(my_list);

        System.out.println("Random values :");

        for (Integer random_values : my_list)
        {
            System.out.print(random_values + " ");
        }
    }
}
