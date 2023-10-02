package Graph;

//used to find strongly connected component


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {

        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int v = sc.nextInt();
            int e = sc.nextInt();

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < v; i++)
            {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int v1 = sc.nextInt() - 1;
                int v2 = sc.nextInt() - 1;

                graph.get(v1).add(v2);
            }

                boolean[] visited = new boolean[v];
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < v; i++)
                {
                    if (visited[i] == false)
                        dfs(graph, visited, i, stack);
                }

                //reversing the graph

                for (int i = 0; i < v; i++)
                {
                    ArrayList<Integer> nbrs = graph.get(i);

                    for (int nbr : nbrs)
                    {
                        graph.get(nbr).add(i);
                    }
                }

                //calling second dfs

                visited = new boolean[v];
                int ans = 0;
                while (stack.size() > 0)
                {
                    int rem = stack.pop();

                    if (visited[rem] == false)
                    {
                        dfs1(graph, visited, rem);
                    }
                    ans++;
                }

                System.out.println("no of strongly connected component : " +ans);
            }


            public  static void dfs(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int ver, Stack<Integer> stack)
            {
                visited[ver] = true;

                ArrayList<Integer> nbrs = graph.get(ver);

                for (int nbr : nbrs)
                {
                    if (visited[nbr] == false)
                    {
                        dfs(graph, visited, nbr, stack);
                    }
                    stack.push(nbr);
                }
            }


            public static void dfs1(ArrayList <ArrayList<Integer>> graph , boolean[] visited, int ver)
            {
                visited[ver] = true;

                ArrayList<Integer> nbrs = graph.get(ver);

                for (int nbr : nbrs)
                {
                    if (visited[nbr] == false)
                    {
                        dfs1(graph, visited, nbr);
                    }

                }
            }



    }

