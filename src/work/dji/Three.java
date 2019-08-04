package work.dji;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>Title: Three</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int pointCount = in.nextInt();
            int routeCount = in.nextInt();
            int raceCount = in.nextInt();
            Node[] nodes = new Node[pointCount];
            for(int i = 0; i < pointCount; i++){
                nodes[i] = new Node(i);
            }
            Route[] routes = new Route[routeCount];
            for(int i = 0; i < routeCount; i++){
                routes[i] = new Route(in.nextInt(), in.nextInt(), in.nextInt());
            }

            Deque<Integer> FIFO = new ArrayDeque<>();

            for (Route route : routes) {
                if(route.x == 0){
                    nodes[route.y].cost = route.cost;
                    FIFO.add(route.y);
                }
                if(route.y == 0){
                    nodes[route.x].cost = route.cost;
                    FIFO.add(route.x);
                }
            }
            nodes[0].visited = true;

            while (!FIFO.isEmpty()){
                int currentVisited = FIFO.poll();
                if (!nodes[currentVisited].visited) {
                    nodes[currentVisited].visited = true;
                    for (Route route : routes) {
                        if(route.x == currentVisited){
                            if(nodes[currentVisited].cost + route.cost < nodes[route.y].cost){
                                nodes[route.y].cost = nodes[currentVisited].cost + route.cost;

                            }
                            if(!nodes[route.y].visited) FIFO.add(route.y);
                        }
                        if(route.y == currentVisited){
                            if(nodes[currentVisited].cost + route.cost < nodes[route.x].cost){
                                nodes[route.x].cost = nodes[currentVisited].cost + route.cost;

                            }
                            if(!nodes[route.x].visited)FIFO.add(route.x);
                        }
                    }
                }
            }

            int totalTime = 0;
            for(int i = 0 ; i < raceCount; i++){
                totalTime += nodes[in.nextInt()].cost;
            }
            System.out.println(totalTime);
        }
    }
}

class Node{
    int index;
    int cost;
    boolean visited;
    Node(int index){
        this.index = index;
        this.cost = Integer.MAX_VALUE;
        visited = false;
    }
}

class Route{
    int x;
    int y;
    int cost;

    public Route(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;

    }
}