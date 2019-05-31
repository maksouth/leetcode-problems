package course_schedule_207;

class Solution {

    private static final int NOT_VISITED = 0;
    private static final int IN_PROGRESS = 1;
    private static final int VISITED = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] edgeNums = new int[numCourses];

        for (int[] course: prerequisites) {
            int edgeIndex = edgeNums[course[0]]++;
            graph[course[0]][edgeIndex] = course[1];
        }

        int[] visited = new int[numCourses];
        int[] courseOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (visited[i] == NOT_VISITED)
                if (!dfs(i, graph, edgeNums, courseOrder, visited)) return new int[0];

        return courseOrder;
    }

    private int courseSize = 0;
    private boolean dfs(
            int index,
            int[][] graph, int[] edgeNums,
            int[] courseOrder,
            int[] visited
    ) {
        if (visited[index] == IN_PROGRESS) return false;
        if (visited[index] == VISITED) return true;

        visited[index] = IN_PROGRESS;

        for (int i = 0; i < edgeNums[index]; i++)
            if (!dfs(graph[index][i], graph, edgeNums, courseOrder, visited)) {
                visited[index] = VISITED;
                return false;
            }

        courseOrder[courseSize++] = index;
        visited[index] = VISITED;
        return true;
    }
}