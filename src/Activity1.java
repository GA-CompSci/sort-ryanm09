public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 thingie = new Activity1();
        thingie.buildList();
        thingie.printPretty();
        thingie.shuffle();
        thingie.printPretty();
      //  thingie.selectionSort();
      //  thingie.printPretty();
      //  thingie.selectionSort(true);
      //  thingie.printPretty();
      //  thingie.insertionSort();
      //  thingie.printPretty();
      //  thingie.insertionSort(true);
      // thingie.printPretty();
      //  thingie.mergeSort(thingie.nums);
      //  thingie.printPretty();
    }

    @Override
    void buildList() {
        nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100) + 1; // 1-100
        }
    }

    @Override
    void shuffle() {
        // loop through all numbers, and at that index pick a random index to swap with.
        // Uses a 3-part-swap (use temp array)
        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * nums.length);   //random position
            int temp = nums[i];   //store value
            nums[i] = nums[r];    //new posiion equal to another value at the random position
            nums[r] = temp;      //random position takes the original's value
        }
    }

    void insertionSort(boolean highToLow){
        if(!highToLow){
            insertionSort();
            return;
        }
        //outer loop
        for(int j = 1; j < nums.length; j++){
            //inner loop: while loop that goes backwards
            int temp = nums[j];
            int i = j - 1;
            while((i > -1) && (nums[i] < temp)){
                //shift over
                nums[i + 1] = nums[i]; //drag out three-part-swap
                i--;
            }
            nums[i + 1] = temp; //complete three-part-swap
        }         
    }

    @Override
    void insertionSort() {
        //verbose sort - extra outputs
        //outer loop
        for(int j = 1; j < nums.length; j++){
            //inner loop: while loop that goes backwards
            int temp = nums[j];
            int i = j - 1;
            while((i > -1) && (nums[i] > temp)){
                //shift over
                nums[i + 1] = nums[i]; //drag out three-part-swap
                i--;
            }
            nums[i + 1] = temp; //complete three-part-swap
            System.out.println("\n PASS # " + j);
            printPretty();
        }         
    }

    void selectionSort(boolean highToLow){
        if(!highToLow){
            selectionSort();
            return;
        }
        // outer loop - STOP ONE EARLY SO INNER DOESN'T GO OVER
        for(int outer = 0; outer < nums.length - 1; outer++){
            // find the largest
            int largestIndex = outer;
            // inner loop to search for smallest
            for(int inner = outer + 1; inner < nums.length; inner++){
                if(nums[inner] > nums[largestIndex]) largestIndex = inner;
            }
            // three part swap outer loop with smallest
                int temp = nums[largestIndex];
                nums[largestIndex] = nums[outer];
                nums[outer] = temp;
        }
        
    }

    @Override
    void selectionSort() {
        // outer loop - STOP ONE EARLY SO INNER DOESN'T GO OVER
        for(int outer = 0; outer < nums.length - 1; outer++){
            // find the smallest
            int smallestIndex = outer;
            // inner loop to search for smallest
            for(int inner = outer + 1; inner < nums.length; inner++){
                if(nums[inner] < nums[smallestIndex]) smallestIndex = inner;
            }
            // three part swap outer loop with smallest
                int temp = nums[smallestIndex];
                nums[smallestIndex] = nums[outer];
                nums[outer] = temp;
        }
            
    }

    void merge(int[] nums, int[] l, int[] r, int leftEnd, int rightEnd){
        //need a bunch of counters
        int i = 0, j = 0, k = 0;
        while(i < leftEnd && j < rightEnd){
            if(l[i] <= r[j]){
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }
        //there's only left remaining
        while(i < leftEnd){
            nums[k++] = l[i++];
        }
        //there's only right remaining
        while(j < rightEnd){
            nums[k++] = r[j++];
        }
    }

    void mergeSort(int[] nums){
        // base case
        int n = nums.length;
        if(n <= 1) return;
        //split in half
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for(int i = 0; i < mid; i++){
            l[i] = nums[i];
        }
        for(int i = mid; i < n; i++){
            //subtracting mid to offset
            r[i- mid] = nums[i];
        }
        mergeSort(l);
        mergeSort(r);

        //you can't get to this next line until the base case hits
        merge(nums, l, r, mid, n - mid);
    }

    @Override
    int pickRandom(){
        int randomIndex = (int)(Math.random() * nums.length);
        return randomIndex;
    }

    int binarySearch(int something){
        //start in the middle
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int middle = nums.length / 2;
            if(nums[middle] == something) return middle;
            else if(nums[middle] > something){
                high = middle - 1;
            } else if(nums[middle] < something){
                low = middle + 1;
            }

        }

        //if we don't find what we need
        return -1;
    }

    public void printPretty() {
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[96m";
        final String YELLOW = "\u001B[93m";

        System.out.print(CYAN + "\n ══ ARRAY (size: " + nums.length + ") ══  " + YELLOW);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println(RESET);
    }

}
