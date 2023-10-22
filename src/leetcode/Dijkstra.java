package leetcode;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length; // 网络节点数
        // 距离数组dist[i]表示从源点到第i个节点的最短距离
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化为无穷大
        // 初始化，起始节点到自己的距离为0
        dist[start] = 0;
        // 记录每个节点是否已经确定了最短路径
        boolean[] visited = new boolean[n];
        // 按照最短距离依次遍历节点
        for (int i = 0; i < n; i++) {
            // 找到距离起始节点最近的未确定最短路径的节点
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    u = j;
                    minDist = dist[j];
                }
            }
            // 所有节点已经遍历过，跳出循环
            if (u == -1) {
                break;
            }
            visited[u] = true;

            // 更新u的邻接节点的距离
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !visited[v]) {
                    int newDist = dist[u] + graph[u][v];
                    //更新起始点到目标节点的距离
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }

        // 输出最短距离
        System.out.println("最短距离：");
        for (int i = 0; i < n; i++) {
            System.out.println(start + " 到 " + i + " 的距离为 " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {2, 0, 2, 4, 2, 0},
                {4, 2, 0, 0, 3, 0},
                {0, 4, 0, 0, 3, 2},
                {0, 2, 3, 3, 0, 2},
                {0, 0, 0, 2, 2, 0}};
        dijkstra(graph, 0); // 从节点0出发
    }
}

