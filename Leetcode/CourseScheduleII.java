import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Setup Graph and In-degree (how many prerequisites each course has)
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
            inDegree[pre[0]]++; // Course pre[0] has one more prerequisite
        }

        // 2. The Queue: The heart of BFS.
        // We only add courses that are "ready" (inDegree == 0).
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int[] result = new int[numCourses];
        int count = 0;

        // 3. BFS Traversal
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Take a "ready" course
            result[count++] = current; // Add it to our schedule

            // Look at all courses that depended on this one
            for (int nextCourse : adj.get(current)) {
                inDegree[nextCourse]--; // This prerequisite is now satisfied

                // If this was the LAST prerequisite, it's now "ready"
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // Add to BFS queue
                }
            }
        }

        // 4. Cycle Check: If we couldn't take all courses, return empty array
        return (count == numCourses) ? result : new int[0];
    }
}
