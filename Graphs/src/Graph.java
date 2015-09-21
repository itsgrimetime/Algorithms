import sun.security.provider.certpath.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    List<List<Integer>> vertices;

    public Graph(String inputFile) {
        this.vertices = new ArrayList<List<Integer>>();
        try {
            Scanner scanner = new Scanner(new File(inputFile));
            while (scanner.hasNextLine()) {
                List<Integer> vertex = new ArrayList<Integer>();
                String line = scanner.nextLine();
                String[] adjacents = line.split(" ");
                for (String adjacent : adjacents) {
                    vertex.add(Integer.parseInt(adjacent));
                }
                vertices.add(vertex);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file " + inputFile);
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Graph(List<List<Integer>> vertices) {
        this.vertices = vertices;
    }

    public List<List<Integer>> getVertices() {
        return vertices;
    }

    public void addVertex(List<Integer> adjacentVertices) {
        this.vertices.add(adjacentVertices);
    }

    public List<Integer> depthFirstTraversalRecursive(int start) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[this.vertices.size()];
        stack.push(start);
        visited[start] = true;
        List<Integer> path = new ArrayList<Integer>();
        return depthFirstTraversalRecursive(stack, path, visited);
    }

    public List<Integer> depthFirstTraversalRecursive(Stack<Integer> stack, List<Integer> path, boolean[] visited) {
        if (!stack.isEmpty()) {
            path.add(stack.peek());
            System.out.println("Added " + stack.peek());
            for (Integer vertex : this.vertices.get(stack.pop())) {
                if (!visited[vertex]) {
                    stack.push(vertex);
                    visited[vertex] = true;
                }
            }
            return depthFirstTraversalRecursive(stack, path, visited);
        } else {
            return path;
        }
    }

    public List<Integer> depthFirstTraversalIterative(int start) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        int current;
        boolean[] visited = new boolean[this.vertices.size()];
        visited[start] = true;
        while (!stack.empty()) {
            current = stack.pop();
            ret.add(current);
            for (int v : this.vertices.get(current)) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
        return ret;
    }

    public List<Integer> breadthFirstTraversalIterative(int start) {
        List<Integer> ret = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        boolean[] visited = new boolean[this.vertices.size()];
        int current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (!visited[current]) {
                ret.add(current);
                visited[current] = true;
                for (Integer vertex : this.vertices.get(current)) {
                    queue.add(vertex);
                }
            }
        }
        return ret;
    }

    public List<Integer> breadthFirstTraversalRecursive(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        boolean[] visited = new boolean[this.vertices.size()];
        List<Integer> path = new ArrayList<Integer>();
        return breadthFirstTraversalRecursive(path, queue, visited);
    }

    public List<Integer> breadthFirstTraversalRecursive(List<Integer> path, Queue<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()) {
            return path;
        } else {
            int current = queue.poll();
            visited[current] = true;
            path.add(current);
            for (Integer vertex : this.vertices.get(current)) {
                if (!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
            return breadthFirstTraversalRecursive(path, queue, visited);
        }
    }

    public int longestPathLength() {
        return this.longestPath().size();
    }

    public List<Integer> longestPath() {
        return new ArrayList<Integer>();
    }
}
