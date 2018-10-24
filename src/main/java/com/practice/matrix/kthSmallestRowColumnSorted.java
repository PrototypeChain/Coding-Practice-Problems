package com.practice.matrix;

public class kthSmallestRowColumnSorted {

    /*Swapping Values*/
    public static void swap(HeapNode[] arr, int i, int j) {
        HeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*Adjust Node in heap at position i*/
    public static void minHeapify(HeapNode[] arr, int i, int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int smallest = i;
        if (leftChild < heapSize && arr[leftChild].data < arr[i].data) {
            smallest = leftChild;
        } else if (rightChild < heapSize && arr[rightChild].data < arr[smallest].data) {
            smallest = rightChild;
        }
        if (smallest != i) {
            swap(arr, smallest, i);
            minHeapify(arr, smallest, heapSize);
        }
    }

    /*Build Heap*/
    public static void buildHeap(HeapNode[] arr, int heapSize) {
        int i = arr.length - 1 / 2;
        while (i >= 0) {
            minHeapify(arr, i, heapSize);
            i--;
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        HeapNode[] heapArray = new HeapNode[mat[0].length];
        for (int i = 0; i < mat[0].length; i++) {
            heapArray[i] = new HeapNode(0, i, mat[0][i]);
        }
        buildHeap(heapArray, heapArray.length);

        HeapNode result = null;
        for (int i = 0; i < k; i++) {
            result = extractMin(heapArray, mat, heapArray.length);
        }
        return result.data;
    }

    public static HeapNode extractMin(HeapNode[] heapArray, int[][] mat, int heapSize) {
        HeapNode minNode = heapArray[0];
        HeapNode nextVal = null;

        if (minNode.row < heapSize - 1) {
            nextVal = new HeapNode(minNode.row + 1, minNode.col, mat[minNode.row + 1][minNode.col]);
        } else {
            nextVal = new HeapNode(minNode.row + 1, minNode.col, Integer.MAX_VALUE);
        }

        heapArray[0] = nextVal;
        minHeapify(heapArray, 0, heapSize);
        return minNode;
    }

    public static void main(String[] args) {
        kthSmallestRowColumnSorted kthSmallest = new kthSmallestRowColumnSorted();

        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50},
        };
        int k = 7;
        int result = kthSmallest.kthSmallest(mat, k);
        System.out.println(k + "th Smallest: " + result);
    }

    static class HeapNode {
        int row;
        int col;
        int data;

        HeapNode(int row, int col, int data) {
            this.row = row;
            this.col = col;
            this.data = data;
        }
    }


}

