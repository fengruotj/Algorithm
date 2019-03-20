package com.hust;

import java.util.*;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/20.
 */
public class AMWGraphClone {
    private ArrayList arrayList;
    private int[][]edges;
    private int numsEdges;

    public AMWGraphClone(int nums) {
        edges=new int[nums][nums];
        arrayList=new ArrayList();
        numsEdges=0;
    }

    //添加一个节点
    public void insertVertex(Object object){
        arrayList.add(object);
    }

    public void insertEdges(int v1,int v2, int weight){
        edges[v1][v2]=weight;
        numsEdges++;
    }

    public int getFirstNeighbor(int v1){
        for (int i = 0; i < arrayList.size(); i++) {
            if(edges[v1][i]>0)
                return i;
        }
        return -1;
    }

    public Object getValueByIndex(int v1){
        return arrayList.get(v1);
    }

    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < arrayList.size(); i++) {
            if(edges[v1][i]>0)
                return i;
        }
        return -1;
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

    public void depthFirstSearch(){
        boolean isVisited[]=new boolean[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            depthFirSearch(i,isVisited);
        }
    }

    private void depthFirSearch(int v1,boolean[] isVisited){
        System.out.print(getValueByIndex(v1)+"  ");

        isVisited[v1]=true;
        int w=getFirstNeighbor(v1);
        for (Integer integer : getNeighbors(v1)) {
            if(!isVisited[integer]){
                System.out.println(getValueByIndex(w));
                depthFirSearch(integer,isVisited);
            }
        }
    }

    public void boardFirstSearch(){
        boolean isVisited[]=new boolean[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            boardFirstSearch(i,isVisited);
        }
    }

    private void boardFirstSearch(int v1,boolean[] isVisited){
        System.out.println(getValueByIndex(v1));
        isVisited[v1]=true;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(v1);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (Integer integer : getNeighbors(v)) {
                if(!isVisited[integer]){
                    System.out.println(getValueByIndex(integer));
                    queue.add(integer);
                    isVisited[integer]=true;
                }
            }
        }
    }

    public HashMap<Integer,Node>  djstra(int v1,boolean isVisited[]){
        //最小堆保存未访问的节点
        PriorityQueue<Node> minHeap=new PriorityQueue<>();

        HashMap<Integer,Node> hashMap=new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
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
                Node wNode = hashMap.get(w);
                if(minHeap.contains(wNode)) {
                    if (poll.des + edges[v][w] < wNode.des) {
                        wNode.des = poll.des + edges[v][w];
                        if(wNode.path.equals("")) {
                            wNode.path = wNode.path + poll.v;
                        }else {
                            wNode.path = " " + poll.v;
                        }
                    }
                }
            }
        }
        return hashMap;
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

    public static void main(String[] args) {
        AMWGraphClone amwGraphClone=new AMWGraphClone(4);
        amwGraphClone.insertVertex("A");
        amwGraphClone.insertVertex("B");
        amwGraphClone.insertVertex("C");
        amwGraphClone.insertVertex("D");
        amwGraphClone.insertEdges(0,1,5);
        amwGraphClone.insertEdges(0,2,6);
        amwGraphClone.insertEdges(1,3,10);
        amwGraphClone.insertEdges(2,3,5);
        HashMap<Integer, Node> djstra = amwGraphClone.djstra(0, new boolean[4]);
        System.out.println(djstra);
    }
}
