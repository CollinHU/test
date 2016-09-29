/**
 * Created by kosoei on 28/9/2016.
 */

import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstsearchExample
{

    private Queue<Node> queue;
    private Stack<Node> stack;
    //static ArrayList<Node> LIST = new ArrayList<Node>();
    static ArrayList<Node> nodes=new ArrayList<Node>();
    static class Node
    {
        int data;
        boolean visited;
        ArrayList<Node> neighBours = new ArrayList<Node>();

        Node(int data)
        {
            this.data=data;

        }
    }

    public BreadthFirstsearchExample()
    {
        queue = new LinkedList<Node>();
        stack = new Stack<Node>();
    }

    public static void buildList(int[][] ArrayMatrix, ArrayList<Node> nodes)
    {
        int height = nodes.size();
        for(int i = 0;i < height;i++)
        {
            for(int j = 0;j < height;j++)
            {
                if(ArrayMatrix[i][j] == 1)
                    nodes.get(i).neighBours.add(nodes.get(j));
            }
        }
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x)
    {
        int nodeIndex=-1;

        ArrayList<Node> neighbours=new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(x))
            {
                nodeIndex=i;
                break;
            }
        }

        if(nodeIndex!=-1)
        {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if(adjacency_matrix[nodeIndex][j]==1)
                {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public void dfs(int adjacency_matrix[][], Node node) //based on matrix
    {
        stack.add(node);
        node.visited=true;
        while (!stack.isEmpty())
        {
            Node element=stack.pop();
            System.out.print(element.data + "\t");

            ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    stack.add(n);
                    n.visited=true;

                }
            }
        }
        for(int j = 0;j < nodes.size();j++)
        {
            nodes.get(j).visited = false;
        }
    }

    public void DFS(Node node)//based on list
    {
        Stack<Node> stack;
        stack = new Stack<Node>();
        stack.add(node);
        node.visited=true;
        while (!stack.isEmpty())
        {
            Node element=stack.pop();
            System.out.print(element.data + "\t");

           // ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
            for (int i = 0; i < element.neighBours.size(); i++) {
                Node n=element.neighBours.get(i);
                if(n!=null && !n.visited)
                {
                    stack.add(n);
                    n.visited=true;

                }
            }
        }
        for(int j = 0;j < nodes.size();j++)
        {
            nodes.get(j).visited = false;
        }
    }

    public  void bfs(int adjacency_matrix[][], Node node)//based on matrix
    {
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {

            Node element=queue.remove();
            System.out.print(element.data + "\t");
            ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    queue.add(n);
                    n.visited=true;

                }
            }

        }
        for(int j = 0;j < nodes.size();j++)
        {
            nodes.get(j).visited = false;
        }
    }


    public void BFS(Node node)//bsf based on list
    {
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {

            Node element=queue.remove();
            System.out.print(element.data + "\t");

            for (int i = 0; i < element.neighBours.size(); i++) {
                Node n=element.neighBours.get(i);
                if(n!=null && !n.visited)
                {
                    queue.add(n);
                    n.visited=true;
                }
            }

        }
        for(int j = 0;j < nodes.size();j++)
        {
            nodes.get(j).visited = false;
        }
    }

    public static void main(String arg[])
    {

        Node node1 =new Node(40);
        Node node2 =new Node(10);
        Node node3 =new Node(20);
        Node node4 =new Node(30);
        Node node5 =new Node(60);
        Node node6 =new Node(50);
        Node node7 =new Node(70);

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        int adjacency_matrix[][] = {
                {0,1,1,0,0,0,0},  // Node 1: 1
                {0,0,0,1,0,0,0},  // Node 2 :2
                {0,1,0,1,1,1,0},  // Node 3: 3
                {0,0,0,0,1,0,0},  // Node 4: 4
                {0,0,0,0,0,0,1},  // Node 5: 5
                {0,0,0,0,0,0,1},  // Node 6: 6
                {0,0,0,0,0,0,0},  // Node 7: 7
        };
        System.out.println("The BFS traversal of the graph is ");
        BreadthFirstsearchExample Example = new BreadthFirstsearchExample();
        Example.buildList(adjacency_matrix,nodes);

        //BFS
        System.out.print("BSF based on matrix\n");
        Example.bfs(adjacency_matrix, node1);
        System.out.println(" \nbased on list");
        Example.BFS(node1);

        //DFS
        System.out.print("\nDSF based on matrix\n");
        Example.dfs(adjacency_matrix,node1);
        System.out.println(" \nbased on list");
        Example.DFS(node1);

    }
}
