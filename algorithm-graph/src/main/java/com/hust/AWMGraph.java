package com.hust;

import java.util.*;

/**
 * locate com.hust
 * Created by mastertj on 2019/3/20.
 * 图 邻接矩阵方式实现
 */
public class AWMGraph {
    private ArrayList vertexList;//存储点的链表
    private List<Edge> edgeList;//存储边的链表
    private int[][] edges;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目

    public AWMGraph(int num) {
        edges=new int[num][num];
        vertexList=new ArrayList(num);
        edgeList=new ArrayList<>();
        numOfEdges=0;
    }

    public void insertVertex(Object vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edgeList.add(new Edge(v1,v2,weight));
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited,int  i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;

        int w=getFirstNeighbor(i);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited,w);
            }
            w=getNextNeighbor(i, w);
        }
    }

    private List<Integer> getNeighbors(int v1){
        List<Integer> arrayList=new ArrayList<>();
        int w=getFirstNeighbor(v1);
        while (w!=-1){
            arrayList.add(w);
            w=getNextNeighbor(v1,w);
        }
        return arrayList;
    }

    private Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
        boolean isVisited[]=new boolean[vertexList.size()];
        for(int i=0;i<getNumOfVertex();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited,i);
            }
        }
    }

    //私有函数，广度优先遍历
    private void broadFirstSearch(boolean[] isVisited,int i) {
        int u,w;
        LinkedList<Integer> queue=new LinkedList<>();

        //访问结点i
        System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u=queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w=getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
        boolean isVisited[]=new boolean[vertexList.size()];
        for(int i=0;i<getNumOfVertex();i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }

    private int getNumOfVertex() {
        return numOfEdges;
    }

    /**
     * 单源最短路径算法
     * @param v1
     * @param isVisited
     * @return
     */
    public HashMap<Integer,Node>  djstra(int v1,boolean isVisited[]){
        //最小堆保存未访问的节点
        PriorityQueue<Node> minHeap=new PriorityQueue<>();

        HashMap<Integer,Node> hashMap=new HashMap<>();
        for (int i = 0; i < vertexList.size(); i++) {
            Node node = new Node(i, getValueByIndex(i));
            hashMap.put(i,node);
            minHeap.add(node);
        }

        Node node=hashMap.get(v1);
        node.des=0;
        minHeap.add(node);

        while (!minHeap.isEmpty()){
            Node poll = minHeap.poll();
            int v = poll.v;
            isVisited[v]=true;

            for (Integer w : getNeighbors(v)) {
                //如果没有访问则访问
                if(!isVisited[w]) {
                    Node wNode = hashMap.get(w);
                    if (poll.des + edges[v][w] < wNode.des) {
                        wNode.des = poll.des + edges[v][w];
                        if(wNode.path.equals("")) {
                            wNode.path += poll.v;
                        }else {
                            wNode.path += " " + poll.v;
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    /**
     * 找到树的最小生成树算法
     * @return
     */
    public List<Edge> kruskal(){
        // 定义一个一维数组，下标为连线的起点，值为连线的终点
        int[] parent = new int[edgeList.size()];
        List<Edge> resultList=new ArrayList<>();
        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        int sum=0;
        for(Edge edge:edgeList){
            int start = kruskalHelper(edge.v1, parent);
            int end = kruskalHelper(edge.v2, parent);
            if(start!=end){
                //不在同一个最小生成树中，可以放入结果中
                resultList.add(edge);
                // 没有产生回环则将临时数组中，起点为下标，终点为值
                parent[start]=end;
                sum+=edge.weight;
            }
        }
        System.out.println("最小生成树的权值为："+sum);
        return resultList;
    }

    /**
     * kruskal辅助函数 找到生成树的连线的终点
     * @param index
     * @param parent
     * @return
     */
    public int kruskalHelper(int index,int[] parent){
        while (parent[index]>0){
            index=parent[index];
        }
        return index;
    }

    private class Node implements Comparable<Node>{
        public int v;
        public Object vertex;
        public int des=Integer.MAX_VALUE;
        //保存最后的路径
        public String path;

        public Node(int v, Object vertex) {
            this.v = v;
            this.vertex = vertex;
            path= "";
        }

        @Override
        public int compareTo(Node o) {
            return this.v-o.v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", vertex=" + vertex +
                    ", des=" + des +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

    private class Edge{
        public int v1;
        public int v2;
        public int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        AWMGraph awmGraph=new AWMGraph(4);
        awmGraph.insertVertex("A");
        awmGraph.insertVertex("B");
        awmGraph.insertVertex("C");
        awmGraph.insertVertex("D");
        awmGraph.insertEdge(0,1,5);
        awmGraph.insertEdge(0,2,6);
        awmGraph.insertEdge(1,3,10);
        awmGraph.insertEdge(2,3,5);
        HashMap<Integer, Node> djstra = awmGraph.djstra(0, new boolean[4]);
        System.out.println(djstra);

        List<Edge> kruskal = awmGraph.kruskal();
        System.out.println(kruskal);
    }
}
