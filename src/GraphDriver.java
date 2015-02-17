import java.util.HashSet;
import java.util.Set;

/**
 * Name: Casey Morris
 * Date: 2/16/15.
 * Project Name: GraphTraversalSearch
 */
public class GraphDriver {
    public static void main(String[] args)
    {
        Set<Vertex> vert = new HashSet<Vertex>();

        vert.add(new Vertex("1"));
        vert.add(new Vertex("2"));
        vert.add(new Vertex("3"));
        vert.add(new Vertex("4"));
        vert.add(new Vertex("5"));
        vert.add(new Vertex("6"));
        vert.add(new Vertex("7"));

        System.out.println("Vertices: "+vert.toString());
        Set<Edge> edge = new HashSet<Edge>();
        edge.add(new Edge(new Vertex("1"),new Vertex("2"),0));
        edge.add(new Edge(new Vertex("1"),new Vertex("3"),0));
        edge.add(new Edge(new Vertex("1"),new Vertex("4"),0));

        edge.add(new Edge(new Vertex("2"),new Vertex("4"),0));
        edge.add(new Edge(new Vertex("2"),new Vertex("5"),0));
        edge.add(new Edge(new Vertex("3"),new Vertex("6"),0));

        edge.add(new Edge(new Vertex("4"),new Vertex("3"),1));
        edge.add(new Edge(new Vertex("4"),new Vertex("6"),0));
        edge.add(new Edge(new Vertex("4"),new Vertex("7"),3));

        edge.add(new Edge(new Vertex("5"),new Vertex("4"),0));
        edge.add(new Edge(new Vertex("5"),new Vertex("7"),0));
        edge.add(new Edge(new Vertex("7"),new Vertex("6"),0));
        System.out.println("Edges: "+edge.toString());

        MyGraph testGraph = new MyGraph(vert,edge);

        System.out.println("Vertices: " + testGraph.vertices()+" Edges: " + testGraph.edges());

        System.out.println("Adjacent to 5: " + testGraph.adjacentVertices(new Vertex("5")));

        System.out.println("Reachable vertices to 1: "+ testGraph.reachableVertices(new Vertex("4")));

        System.out.println("Topological: " + testGraph.topologicalSort());

        System.out.println("Adjacency List: " + testGraph.adjList());

        System.out.println("InDegree Vertex 2: "+testGraph.inNeighbors(new Vertex("2")));
        System.out.println("InDegree Vertex 4: "+testGraph.inNeighbors(new Vertex("4")));
        System.out.println("InDegree Vertex 3: "+testGraph.inNeighbors(new Vertex("3")));
        //Test is Adjacent
        System.out.println("Is Adjacent: " +testGraph.isAdjacent(new Vertex("1"),new Vertex("2")));
        System.out.println("Is Adjacent: " +testGraph.isAdjacent(new Vertex("1"),new Vertex("6")));
        System.out.println("Is Adjacent: " +testGraph.isAdjacent(new Vertex("1"),new Vertex("0")));


    }
}
