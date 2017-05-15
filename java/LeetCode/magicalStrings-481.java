public class magicalStrings-481 {
    public int magicalString(int n) {
        if( n == 0){
            return 0;
        }else if( n <= 3){
            return 1;
        }
        int[] seq = sequenceMaker(n);
        // for( int i = 0; i < seq.length; i++){
        //     System.out.print(seq[i] + " ");
        // }
        int counter = 0;
        for(int i = 0; i < n; i++){
          counter += seq[i] == 1 ? 1 : 0;
        }
        return counter;
    }

    private int[] sequenceMaker(int n){
        int[] sequence = new int[n+1];
        sequence[0] = 1;
        sequence[1] = 2;
        sequence[2] = 2;
        int tail = 3;
        int head = 2;
        while( tail < n){
            int element = sequence[tail - 1] == 2 ? 1 : 2;
            int frequency = sequence[head];
            for(int i = 0; i < frequency; i++){
                sequence[tail] = element;
                tail++;
            }
            head++;
        }
        return sequence;
    }
}
