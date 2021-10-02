package test.coding.algorithm.boj;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCA implements Solution {

  private static ArrayList<ArrayList<Integer>> tree;
  private static int[] nodeDepth;
  private static int[] nodeParent;
  private static boolean[] visited;

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    try {
      int n = Integer.parseInt(br.readLine());

      nodeDepth = new int[n + 1];
      nodeParent = new int[n + 1];
      tree = new ArrayList<>();
      visited = new boolean[n + 1];

      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }

      for (int i = 0; i < n - 1; i++) {
        String[] nodes = br.readLine().trim().split(" ");
        int l = Integer.parseInt(nodes[0]);
        int r = Integer.parseInt(nodes[1]);
        tree.get(l).add(r);
        tree.get(r).add(l);
      }

      dfs(1, 0);

      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        sb.append(lca(l, r)).append('\n');
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void dfs(int node, int depth) {
    visited[node] = true;
    nodeDepth[node] = depth;

    for (int i = 0; i < tree.get(node).size(); i++) {
      int childNode = tree.get(node).get(i);
      if (visited[childNode]) {
        continue;
      }
      nodeParent[childNode] = node;
      dfs(childNode, depth + 1);
    }
  }

  public static int lca(int lhs, int rhs) {
    while (nodeDepth[lhs] != nodeDepth[rhs]) {
      if (nodeDepth[lhs] < nodeDepth[rhs]) {
        rhs = nodeParent[rhs];
      } else {
        lhs = nodeParent[lhs];
      }
    }

    while (lhs != rhs) {
      lhs = nodeParent[lhs];
      rhs = nodeParent[rhs];
    }
    return lhs;
  }
}
