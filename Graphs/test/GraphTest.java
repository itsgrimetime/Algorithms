import com.google.common.collect.Iterables;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    private static final String testFile = "test-graph.txt";

    @Test
    public void testDepthFirstTraversals() {
        Graph graph = new Graph(testFile);
        int[] expected = new int[]{0, 7, 6, 5, 3, 4, 2, 1};
        Integer[] expectedIntegers = new Integer[expected.length];
        for (int i = 0; i < expected.length; i++) {
            expectedIntegers[i] = expected[i];
        }
        assertArrayEquals(expectedIntegers, Iterables.toArray(graph.depthFirstTraversalIterative(0), Integer.class));
        assertArrayEquals(expectedIntegers, Iterables.toArray(graph.depthFirstTraversalRecursive(0), Integer.class));
    }

    @Test
    public void testBreadthFirstTraversals() {
        Graph graph = new Graph(testFile);
        int[] expected = new int[]{0, 1, 2, 7, 3, 4, 5, 6};
        Integer[] expectedIntegers = new Integer[expected.length];
        for (int i = 0; i < expected.length; i++) {
            expectedIntegers[i] = expected[i];
        }
        assertArrayEquals(expectedIntegers, Iterables.toArray(graph.breadthFirstTraversalIterative(0), Integer.class));
        assertArrayEquals(expectedIntegers, Iterables.toArray(graph.breadthFirstTraversalRecursive(0), Integer.class));

    }

}
