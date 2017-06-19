/**
* 8.7
* remove the kth to the last node
* 1 -> 2-> 3 -> 4 -> 5  k th 2
* 1 -> 2 -> 3 -> 5
* O(2n) worst case, best case O(n+1)
*/
public Node removeKLastNode(Node node, int k){
    int size = 1;
    Node sizeNode = node;
    // gets the length of the linked list
    while(sizeNode.next !=null){
        size++;
        sizeNode = sizeNode.next
    }
    // index to remove the node
    int removeNodeIndex = size - k;
    int counter = 1;
    while( node.next != null){
    // change the pointer to skip over the k node
       if(counter == removeNodeIndex - 1){
           node.next = node.next.next;
           return node;
       }
       counter++;
       node = node.next;
    }
}

/**
* 8.8
* 1 - > 2 - > 3 -> 3 ->  3 - > 4 - > 5
* 1 -> 2 -> 3 -> 4 -> 5
* remove duplicates from a sorted linked list, returns a sorted linked list
* O(N) soltution
*/
public Node removeDuplicates(Node node){

    if(node.next == null){
       return node;
    }
    Node fastPointer =  node.next
    Node slowPointer = node;
    while( fastPointer.next != null){
        if(slowPointer.element < fastPointer.element){
            slowPointer.next = fastPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        else if( slowPointer.element == fastPointer.element){
             fastPointer = fastPointer.next;
        }
    }
}
