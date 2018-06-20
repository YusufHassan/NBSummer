package NB3;

public class Node {
    public String data;
    public Node next;
    public Node(String data){
        this.data = data;
    }
    public static void main(String[] args){
        Node n1 = new Node("Gilgamesh");
        Node n2 = new Node("Löper");
        Node n3 = new Node("På");
        Node n4 = new Node("Stäppen");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node node = n1;
        while(node !=null){
            System.out.printf(node.data+"->");
            node = node.next;
        }

    }
}
