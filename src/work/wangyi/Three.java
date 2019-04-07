package work.wangyi;

import java.util.*;

public class Three {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Map<Integer, Ring> rings = new HashMap<>();
        boolean[] visited = new boolean[total];
        int cutNum = 0;
        Deque<Ring> cutRings = new ArrayDeque<>();
        int result = 0;
        for(int i = 1; i <= total; i++){
            rings.put(i, new Ring(i));
        }

        while (in.hasNext()){
            int ring1 = in.nextInt();
            int ring2 = in.nextInt();
            rings.get(ring1).getLinked().add(rings.get(ring2));
            rings.get(ring2).getLinked().add(rings.get(ring1));
        }
        Ring currRing = null;
        for(int i = 1; i <= total; i++){
            if(rings.get(i).getLinked().size() == 1){
                currRing = rings.get(i);
                break;
            }
        }
        if(currRing == null){
            for(int i = 1; i <= total; i++){
                if(rings.get(i).getLinked().size() == 2){
                    currRing = rings.get(i);
                    cutRings.add(currRing.getLinked().remove(0));
                    break;
                }
            }
        }

        while (true){
            boolean flag = false;


        }
    }
}

class Ring{
    private int num;
    private List<Ring> linked;

    int getNum() {
        return num;
    }

    List<Ring> getLinked() {
        return linked;
    }

    Ring(int num){
        this.num = num;
    }
}
