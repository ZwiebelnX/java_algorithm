package work.huanju;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Title: ThreePlus</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class ThreePlus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        int goal = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        System.out.println(findLastIndex(goal, list));
    }

    private static int findLastIndex(int key, List<Integer> array) {
        int head = 0;
        int tail = array.size() - 1;
        while (true) {
            int mid = (head + tail) / 2;
            if(array.get(mid) > key) tail = mid;
            if (array.get(mid) < key) {
                head = mid;
            } else {
                int current = mid;
                while (true) {
                    if (array.get(current + 1).equals(array.get(current))) {
                        current++;
                    } else {
                        return  current;
                    }

                }
            }
        }
    }
}
