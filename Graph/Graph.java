package Graph;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap <String, ArrayList<String>> addList = new HashMap<>();

    void printAddList(){
        System.out.println(addList);
    }
    public boolean addVertex(String vertex){
        if(addList.get(vertex) == null){ // that the vertex is not present in the hashmap (get method)
            addList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        if(addList.get(vertex1)!= null && addList.get(vertex2) != null){
            addList.get(vertex1).add(vertex2);
            addList.get(vertex2).add(vertex1);
            return true;
        }
        return false;

    }

    public boolean removeEdge (String vertex1, String vertex2){
        if(addList.get(vertex1) != null && addList.get(vertex2) != null){
            addList.get(vertex1).remove(vertex2);
            addList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if(addList.get(vertex) == null) {
            return false;
        }
        for(String otherVertex : addList.get(vertex)){  // other vertex traverses the arraylist of the vertex which we want to remove
            addList.get(otherVertex).remove(vertex); // remove all the edges that go back to Vertex D
        }
        addList.remove(vertex); // this removes the vertex D
        return true;
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "C");
        g.addEdge("A", "B");
//        g.removeEdge("A", "B");
        g.removeVertex("B");
        g.printAddList();
    }
}
