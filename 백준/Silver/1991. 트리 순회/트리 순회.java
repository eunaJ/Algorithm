import java.util.*;
import java.io.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class Main {
    static Node[] tree;

    public static void pre(Node node){
        if(node == null) return;
        System.out.print(node.value);
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node){
        if(node == null) return;
        in(node.left);
        System.out.print(node.value);
        in(node.right);
    }

    public static void post(Node node){
        if(node == null) return;
        post(node.left);
        post(node.right);
        System.out.print(node.value);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            char pv = s.charAt(0);
            char lv = s.charAt(2);
            char rv = s.charAt(4);
            if(pv == 'A') tree[pv-'A'] = new Node(pv); // 부모 노드 생성
            if(lv != '.'){ // 왼쪽 자식 존재
                tree[lv-'A'] = new Node(lv);
                tree[pv-'A'].left = tree[lv-'A'];
            }
            if(rv != '.'){ // 오른쪽 자식 존재
                tree[rv-'A'] = new Node(rv);
                tree[pv-'A'].right = tree[rv-'A'];
            }
        }
        pre(tree[0]);
        System.out.println();
        in(tree[0]);
        System.out.println();
        post(tree[0]);
        System.out.println();
    }
}