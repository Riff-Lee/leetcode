package solved.problem1to999._100to199._150to159.MinStack155;

public class MinStack {
    int[] minIndex = new int[30001];
    int[] array = new int[30001];
    int index = -1;
    public MinStack() {
    }

    public void push(int val) {
        array[++index] = val;
        minIndex[index] = index==0||val<array[minIndex[index-1]]?index:minIndex[index-1];
    }

    public void pop() {
        index--;
    }

    public int top() {
        return array[index];
    }

    public int getMin() {
        return array[minIndex[index]];
    }

}
