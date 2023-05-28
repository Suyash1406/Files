import java.util.*;

class node{
    int val;
    node right;
    node left;
    node(int val){this.val = val;this.right=null;this.left=null;}
    node(int val,node left,node right){this.val = val;this.left=left;this.right=right;}
}
class a{
    public static void main(String[] args) {
        node head = new node(5,new node(6,new node(3),new node(2)),new node(7));
        
        Queue<node>q = new ArrayDeque<>();
        q.add(head);
        dfs(head);
        System.out.println();
        bfs(head,q);
    }
    private static void dfs(node head){
        if(head==null) return;
        System.out.print(head.val+" ");
        dfs(head.left);
        dfs(head.right);
    }
    private static void bfs(node head,Queue<node>q){
        if(q.isEmpty()) return;
        node t = q.poll();
        System.out.print(t.val+" ");
        if(t.left!=null) q.add(t.left);
        if(t.right!=null) q.add(t.right);
        bfs(q.peek(),q);
    }
    
}