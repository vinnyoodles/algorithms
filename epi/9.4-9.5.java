/**
 * EPI 9.4: Given a string representing a valid filepath,
 * return the shortest equivalent filepath.
 * Complexity: O(n) runtime and space.
 */
public String resolveFilepath(String filepath) {

    Stack<String> stack = new Stack<String>();
    String delimiter = "/";
    String[] file = filpath.split(delimiter);
    for (int i = 0; i < file.length(); i++) {
        // Ignore single periods
        if (file[i].equals("") || file[i].equals(".") ) {
            continue;
        } else if (file[i].equals("..") && !stack.isEmpty()) {
            stack.pop();
        } else {
            stack.push(file[i]);
        }

    }
    return String.join("/", stack.toArray());
}

/**
 * EPI 9.5: Given a linked list with a next pointer and a jump pointer,
 * Return the jump first traversal of the linked list.
 * The jump pointer can point to any node in the list except for itself.
 * Jump first traversal can be defined as prioritizing the jump pointer over the next pointer.
 * O(n) time and space
 */
public List<Node> jumpOrderList(Node node) {

    HashSet<Node> visited = new HashSet<Node>();
    Stack<Node> stack = new Stack<Node>();
    stack.push(node);
    while (!stack.isEmpty()) {
        Node temp = stack.pop();

        if (!visited.contains(temp)) {
            visited.add(temp);
            if (temp.next != null) stack.push(temp.next);
            stack.push(temp.jump);
        }
    }

    return visited.toArray();
}
