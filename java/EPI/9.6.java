// the class is made using the book. The solution is orginial.
// 9.6
private class Buildings{
    int id;
    int height;
    public Buildings(int id, int height){
        this.id = id
        this.height = height;
    }
}

/**
 * you are given a buildings with heights. Goal is to return the buildings in a such order that the smallest hegiht is on the west side and the largest
 * is on the east. So that way no building blocks the sunset of other building.
 * input = [ 1, 8, 5]
 * output =[(0,1),(2,5),(1,8)]
 * space is O(n), and time is O(n) time since building is never pushed or popped more than once.
 */
public Stack<Buildings> buildingsView(Iterator<Integer> building) {
    Stack<Buildings> res = new Stack<Buildings>();
    int index = 0;
    while (building.hasNext() ) {
        Integer temp = building.next(); // gives the next element in the iterations will give us the height of the building
        while(res.peek() != null && temp >= res.peek().height()){
            res.pop();
        }
        res.push(new Buildings(index++, temp));
    }
    return res;


}
