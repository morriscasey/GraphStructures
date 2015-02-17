/**
 * Name: Casey Morris
 * Date: 2/15/15.
 * Project Name: GraphTraversalSearch
 * Description:  A representation of a graph. Assumes that we do not have negative cost edges in the graph.
 */

import sun.awt.image.ImageWatched;

import java.util.*;

public class MyGraph implements Graph {
    private Collection<Vertex> myVertices; // the vertices in this graph
    private Collection<Edge> myEdges;       // the edges in this graph

    /**
     * Creates a MyGraph object with the given collection of vertices
     * and the given collection of edges.
     *
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
        //Checks if either collection is null then throws an error.  if good then adds vertices to myVertices and
        // edges to myEdges.
        if (v == null || e == null) {
            throw new IllegalArgumentException("null");
        }

        this.myVertices = v;
        this.myEdges = e;

    }

    /**
     * Return the collection of vertices of this graph
     *
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {

        if(this.myVertices == null){
            throw new IllegalArgumentException("null");
        }
        return this.myVertices;

    }

    /**
     * Return the collection of edges of this graph
     *
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {

        if(this.myEdges == null){
            throw new IllegalArgumentException("null");
        }
        return this.myEdges;

    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     * i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     *
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {

        if (!(vertices().contains(v))){
            throw new IllegalArgumentException("null");
        }

        return outNeighbors(v);
    }

    /**
     * Return a collection of vertices that are reachable from a given vertex v.
     * A vertex is reachable if a path exists from v to the other vertex.
     *
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices that are reachable from v in the graph
     */
    public Collection<Vertex> reachableVertices(Vertex v) {
        //Set returning
        Set<Vertex> result = new HashSet<Vertex>();
        //Initialized a map holding an adjancy list for all the nodes
        Map<Vertex,Set> adjacentMap = adjList();
        //Initialized a queue to add frontier nodes
        Queue<Vertex> nextNode = new LinkedList<Vertex>();
        nextNode.addAll(adjacentMap.get(v));
        result.addAll(adjacentMap.get(v));

        for (Vertex node: nextNode){
            result.addAll(outNeighbors(node));
        }

        //return set of vertices reachable by vertex given
        return result;
    }

    /**
     * Returns a topological sorting of the vertices in the graph.
     *
     * @return an ordered list of vertices in topological sort order
     */
    public List<Vertex> topologicalSort() {
        int counter = 0;

        //Create a set for holding the vertices
        LinkedList<Vertex> topoList = new LinkedList<Vertex>();


            for(Vertex v: myVertices) {
                if(inNeighbors(v).isEmpty()){
                    v.setIndegree(0);
                }else {
                    v.setIndegree(inNeighbors(v).size());
                }
            }

        while(counter < myVertices.size()) {
            for (Vertex v : myVertices) {

                    if (v.getIndegree() == 0) {
                        counter++;
                        topoList.add(v);
                        v.setIndegree(-1);
                    } else if (v.getIndegree() > 0) {
                        v.setIndegree(v.getIndegree() - 1);
                    }
                }
            }

        return topoList;
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     *
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph,
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int isAdjacent(Vertex a, Vertex b) {
        if(a == null || b == null){
            throw new IllegalArgumentException("null");
        }
        for (Edge e: myEdges) {
            if (e.from.equals(a) && e.to.equals(b)){
                return e.w;
            }
        }

        return -1;

    }

    /**
     * Returns the shortest path from a to b in the graph.  Assumes positive
     * edge weights.  Uses Dijkstra's algorithm.
     *
     * @param a    the starting vertex
     * @param b    the destination vertex
     * @param path a list in which the path will be stored, in order, the first
     *             being the start vertex and the last being the destination vertex.  The
     *             list will be empty if no such path exists.  NOTE: the list will be
     *             cleared of any previous data.  path is not expected to contain any data
     *             needed by the method when the method is called.  It is used to allow
     *             us to return multiple values from the function.
     * @return the length of the shortest path from a to b, -1 if no such path
     * exists.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public int shortestPath(Vertex a, Vertex b, List<Vertex> path) {

        // YOUR CODE HERE
        return -1;

    }

    //helper method
    //when provided with a vertex called v
    //returns all incoming sets
    Set<Vertex> inNeighbors(Vertex v){
        // create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Edge e: myEdges) {
            if (e.to.equals(v)){
                result.add(e.from);
            }
        }
        //return the result set
        return result;
    }

    //helper method
    //when provided with a vertex called v
    //returns all outgoing sets
    Set<Vertex> outNeighbors(Vertex v){
        // create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Edge e: myEdges) {
            if (e.from.equals(v)){
                result.add(e.to);
            }
        }
        //return the result set
        return result;
    }

    public Set<Vertex>minNodes(){
        //create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Vertex node : myVertices){
            Set<Vertex> inNbrs = inNeighbors(node);
            if (inNbrs.isEmpty()){
                result.add(node);
            }
        }
        //return result
        return result;
    }
    //Helper that returns an adjacency list as a map
    public Map<Vertex, Set>adjList(){
        Set<Vertex> result = new HashSet<Vertex>();
        Map<Vertex,Set> adjMap = new HashMap<Vertex, Set>();
        for (Vertex node: myVertices){
            adjMap.put(node,outNeighbors(node));
        }
        return adjMap;
    }

}