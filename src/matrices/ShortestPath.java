package matrices;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPath {

    public class Coordinates {
        public int x;
        public int y;

        public Coordinates(){};

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        List<Coordinates> getAdjacentPositions() {
            Coordinates top = new Coordinates(this.x-1, this.y);
            Coordinates bottom = new Coordinates(this.x+1, this.y);
            Coordinates left = new Coordinates(this.x, this.y-1);
            Coordinates right = new Coordinates(this.x, this.y+1);
            return Arrays.asList(top, bottom, left, right);
        }
    }

    public static boolean pathExists(int[][] map, Coordinates start, Coordinates end) {

        int[][] visitedMatrix = new int[map.length][map[0].length];
        Queue<Coordinates> queue = new LinkedList<>();

        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                visitedMatrix[i][j]=0;
            }
        }

        queue.add(start);
        while(!queue.isEmpty()) {
            Coordinates current = queue.remove();
            if(current.equals(end)) {
                return true;
            } else  {
                markVisited(visitedMatrix, current);
                List<Coordinates> adj = current.getAdjacentPositions();
                List<Coordinates> toVisit = adj.stream().filter(coordinates -> canVisit(map, visitedMatrix, coordinates)).collect(Collectors.toList());
                queue.addAll(toVisit);
            }
        }
        return false;
    }

    public static int[][] markVisited(int[][] map, Coordinates position) {
        map[position.x][position.y] = 1;
        return map;
    }

    public static boolean canVisit(int[][] map, int[][] visitedMap, Coordinates position) {
        if(position.x > map.length) {
            return false;
        } else if(position.y > map[0].length) {
            return false;
        }

        if(visitedMap[position.x][position.y] == 1) {
            return false;
        }
        if(map[position.x][position.y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
