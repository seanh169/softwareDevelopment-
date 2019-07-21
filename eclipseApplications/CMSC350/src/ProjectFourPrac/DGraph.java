package ProjectFourPrac;

import java.io.*;
import java.util.*;

/**
 * Filename:    DGraph
 * Author:      William Crutchfield
 * Date:        7/13/2017
 * Description: Creates a DGraph of vertices from a txt file. Then uses a depth-first search algorithm starting from
 * a vertex that is input from the GUI class. Outputs the topological order of said sub-graph.
 */
class DGraph<T> {

    // Variables
    private Map<T, Integer> mapToInteger;                   // Key is className, Value is Integer (Ex. ClassA,0)
    private ArrayList<LinkedList<Integer>> adjLists;        // List of ALL Edges in DGraph
    private int v = 0;                                      // Number of vertices in DGraph, also determines indices
    private List<Integer> neighbors;                        // List of all neighbors in subGraph, used to find cycles
    private StringBuilder output;                           // Output Text


    /**
     * Default Constructor for DGraph
     */
    DGraph() {
        adjLists = new ArrayList<>();       // Stores ALL edges for ALL vertices
        mapToInteger = new HashMap<>();     // Maps className to vertex index(v)
    }

    /**
     * Creates Vertices and Edges from tokens
     * @param tokensArray ArrayList of tokens
     */
    void buildDGraphFromFile(ArrayList<T[]> tokensArray) {
        for (T[] tokensLine : tokensArray) {                // for each line of file
            for (int i = 0; i < tokensLine.length; i++) {   // for each token in line
                addVertex(tokensLine[i]);                   // Adds a Vertex to represent token
                if (i != 0) {                               // if current token is not the first in this line
                    addEdge(tokensLine[0], tokensLine[i]);  // Adds an Edge from the first of the line to current
                }
            }
        }
    }

    /**
     * Opens txt file, splits file contents into ArrayList of tokens
     * @param fileName name of file to be opened
     * @return tokenized ArrayList of file contents, fileArray
     * @throws IOException is thrown if the txt file is not found
     */
    ArrayList<String[]> tokenizeFile(String fileName) throws IOException {
        String filePath = new File("res/" + fileName).getAbsolutePath();    // Gets relative filePath
        BufferedReader br = new BufferedReader(new FileReader(filePath));   // Opens File from filePath
        ArrayList<String[]> fileArray = new ArrayList<>();  // Array List of String[] for each line in the file
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {            // Reads a line from the file
            String[] lineArray = line.split("\\s"); // Takes line from file, splits into tokens by spaces
            fileArray.add(index,lineArray);                 // Takes tokenized line, adds to ArrayList
            index++;                                        // Increases index
        }

        return fileArray;
    }

    /**
     * Adds a Vertex to mapToInteger, creates LinkedList<Integer> adj to hold edges for said vertex
     * @param className token string that is to be mapped to an Integer
     */
    private void addVertex(T className) {
        if (!mapToInteger.containsKey(className)) {         // Ensures each className is only mapped once
            mapToInteger.put(className, v);                 // Maps className to v (v being index number)
            LinkedList<Integer> adj = new LinkedList<>();   // Creates empty LinkedList (inner list for adjLists)
            adjLists.add(v, adj);                           // Adds adj to ArrayLists at corresponding index
            v++;                                            // Increments v for to prepare for next vertex
        }
    }

    /**
     * Adds a Edge that connects two vertices, stores edge in appropriate adj in adjLists
     * @param vertexFrom Vertex that the Edge starts at
     * @param vertexTo Vertex that the Edge points to
     */
    private void addEdge(T vertexFrom, T vertexTo) {
        int from = mapToInteger.get(vertexFrom);    // Gets int associated with vertexFrom
        int to = mapToInteger.get(vertexTo);        // Gets int associated with vertexTo
        adjLists.get(from).add(to);                 // Inserts vertexTo value at the index of vertexFrom in adjLists
    }

    /**
     * Generates an output StringBuilder for a sub-graph within DGraph
     * @param startVertex Vertex in which sub-graph starts from
     * @return output String of classNames in sub-graph
     * @throws InvalidClassNameException is thrown if startVertex is not valid
     * @throws ContainsCycleException is thrown if the sub-graph contains a cycle
     */
    String topOrdGeneration(T startVertex) throws InvalidClassNameException, ContainsCycleException {
        if (mapToInteger.get(startVertex) == null) {    // Checks if className exists in HashMap
            throw new InvalidClassNameException();      // Throws error if it does not
        }

        output = new StringBuilder();           // Creates instance of output StringBuilder
        neighbors = new ArrayList<>();          // Creates instance of neighbors ArrayList
        dfs(mapToInteger.get(startVertex));     // depth-first search, started from user-specified vertex

        return output.toString();
    }

    /**
     * Gets className(key) associated with a given vertex index(value) from mapToInteger HashMap
     * @param vertex index of a vertex value
     * @return className String of vertex
     */
    private String getNameFromIndex(int vertex) {
        for (T k : mapToInteger.keySet()) {             // for every key in keySet
            if (mapToInteger.get(k).equals(vertex)) {   // if value for key == vertex value
                return k.toString();                    // returns key(className) as String
            }
        }
        return "";
    }

    /**
     * Depth-first search algorithm, appends className of each vertex visited to output StringBuilder
     * @param v vertex index value
     * @throws ContainsCycleException is thrown when a cycle is found in the sub-graph
     */
    private void dfs(int v) throws ContainsCycleException {
        output.append(getNameFromIndex(v)).append(" ");     // appends (className + " ") to output StringBuilder
        for (Integer x : adjLists.get(v)) {                 // for every Integer in adjLists at index v
            if (neighbors.contains(x)) {                    // Check if x has been visited already
                throw new ContainsCycleException();         // throw error if true
            }
            neighbors.add(x);                               // Add x to neighbors List (to catch cycles)
            dfs(x);                                         // recursively search neighbors
        }
    }
}