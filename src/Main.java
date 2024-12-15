public class Main {
  public static void main(String[] args) {
    String[] vertices = {
        "Liberal Arts", "Student Services", "Health Careers & Sciences", "Health Technologies",
        "Recreation Center", "Technology Learning Center", "Business & Technology", "Theater"
    };

    int[][] edges = {
        { 0, 1 }, // Liberal Arts -> Student Services
        { 1, 2 }, // Student Services -> Health Careers & Sciences
        { 2, 3 }, // Health Careers & Sciences -> Health Technologies
        { 3, 4 }, // Health Technologies -> Recreation Center
        { 4, 5 }, // Recreation Center -> Technology Learning Center
        { 5, 6 }, // Technology Learning Center -> Business & Technology
        { 3, 6 }, // Health Technologies -> Business & Technology
        { 4, 7 }, // Recreation Center -> Theater
        { 1, 5 }, // Student Services -> Technology Learning Center
        { 0, 6 } // Liberal Arts -> Business & Technology
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);

    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

    dfs.printPath(graph.getIndex("Health Technologies"));
    dfs.printPath(graph.getIndex("Student Services"));
    dfs.printPath(graph.getIndex("Recreation Center"));

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++) {
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    }
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++) {
      if (dfs.getParent(i) != -1) {
        System.out.println("Parent of " + graph.getVertex(i) + " is " + graph.getVertex(dfs.getParent(i)));
      }
    }
    dfs.printTree();
  }
}