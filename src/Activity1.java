public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 thingie = new Activity1();
        thingie.buildList();
        thingie.printPretty();
        thingie.shuffle();
        thingie.printPretty();
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

    @Override
    void insertionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertionSort'");
    }

    @Override
    void selectionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectionSort'");
    }

    @Override
    void mergeSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mergeSort'");
    }

    @Override
    int pickRandom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickRandom'");
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
