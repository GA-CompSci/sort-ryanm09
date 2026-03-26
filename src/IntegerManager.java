import java.util.ArrayList;

abstract class IntegerManager {
    /** Core data structure to hold your integer list */
    protected int[] nums;

    /** Adds integers to the list until a sentinel value is submitted */
    abstract void buildList();

    /** Uses selection shuffle algorithm */
    abstract void shuffle();

    /** Sorts the list of integers using insertion sort */
    abstract void insertionSort();

    /** Sorts the list of integers using selection sort */
    abstract void selectionSort();

    /** Returns a random integer from the nums list */
    abstract int pickRandom();
}
