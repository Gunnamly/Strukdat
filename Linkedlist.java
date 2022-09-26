public class Linkedlist {
    private Node first;
    private int length;

    public class Node {
    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public String getValue() {
        return this.value;
    }

}

    public void showAll() {
        while (first != null) {
            System.out.print(first.getValue() + " ");
            first = first.getNext();
        }
    }

    public Linkedlist() {
        this.first = null;

    }

    public void add(String value) {
        Node temp = new Node(value);
        if (this.first == null) {
            this.first = temp;
        } else {
            temp.setNext(first);
            first = temp;
        }
        length++;
    }

    public Node searchNode(int index) {
        Node currentNode = this.first;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public void insert(String value, int index) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = new Node(value);
        if (0 == index) {
            temp.setNext(first);
            first = temp;
        } else {
            Node SNode = searchNode(index);
            temp.setNext(SNode.getNext());
            SNode.setNext(temp);
        }
        length++;
    }

    public void remove(int index) {
        if (index > length || index < 0) {
            // showAll();
            System.out.println("Data yang dihapus tidak ada");
        } else {
            Node temp;
            if (index == 0) {
                temp = this.first.getNext();
                first = temp;
            } else {
                temp = searchNode(index);
                temp.setNext(temp.getNext().getNext());
            }
        }
    }

    public void swap(int index1, int index2) {
        if (length > index1 && length > index2 && index1 >= 0 && index2 >= 0) {
            Node temp1 = searchNode(index1 + 1), temp2 = searchNode(index2 + 1);
            insert(temp2.getValue(), index1);
            remove(index1 + 1);
            insert(temp1.getValue(), index2);
            remove(index2 + 1);
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    void removeduplicate (){
        Node current = this.first;
        Node next_next;

        if (this.first == null){
            return;
        }

        while (current.getNext() != null){
            if(current.value == current.next.value){
                next_next = current.next.next;
                current.next = null;
                current.next =next_next;
            }
            else{
                current = current.next;
            }
        } 
    }

    public void removevalue (String value){
        Node current = this.first;
        if (current == null){
            return;
        }
        else if (current.getValue() == value){
            this.first = this.first.getNext();
            this.length--;
        }
        else{
            while (current.getValue() != value){
                if (current.getNext().getValue() == value){
                    current.setNext(current.getNext().getNext());
                    this.length--;
                    return;
                }
                else{
                    current = current.getNext();
                }
            }
        }
    }
    public void swapLastWithFirst() {  
        Node current = first, temp = null, index = null;   
        if(first == null) {  
            return;  
        }  
        else {  
            while(current.getNext() != null) {  
                index = current;  
                current = current.next;  
            }  
              
            if(first == current) {  
                return;  
            }  
            else if(first.next == current) {  
                temp = first;   
                first = current;   
                first.next = temp;    
                temp.next = null;  
            }  
            else {  
                temp = first;   
                first = current;  
                first.next = temp.next;    
                index.next = temp;    
                temp.next = null;  
            }  
        } 
    }  
    public static void main(String[] args) {
        Linkedlist bebek = new Linkedlist();
        bebek.add("P");
        bebek.add("A");
        bebek.add("S");
        bebek.add("A");
        bebek.add("A");
        bebek.insert("L", 2);
        bebek.remove(5);
        bebek.swap(4, 2);
        bebek.remove(2);
        bebek.add("A");
        bebek.removeduplicate();
        bebek.removevalue("S");
        bebek.swapLastWithFirst();
        bebek.showAll();
    }
}