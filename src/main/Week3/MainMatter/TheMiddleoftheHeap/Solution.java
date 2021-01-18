package main.Week3.MainMatter.TheMiddleoftheHeap;

class Solution {
    /**
     * @param heap the Heap to check, can be null. If not null, this heap will always contain at least one Node.
     * @return the Node corresponding to the middle element in the last layer of the Heap, or null if the Heap is null.
     * In case the last layer contains an even number of elements, returns the element just left of the middle (see test).
     */
    public static Heap.Node findMiddleInLastLayer(Heap heap) {

        if (heap == null) return null;
        int numberOfNodesInLastLevel = numberOfNodesInLastLevel(heap.size());


        int index = numberOfNodesInLastLevel / 2;

        if (numberOfNodesInLastLevel % 2 == 1) index++;

        int height = height(heap.size());

        char[] path = getPathToNode(heap.size(), index, height).toCharArray();

        Heap.Node pointer = heap.getRoot();

        for (int i = path.length - 1; i >= path.length - height; i--) {
            if (path[i] == '0') {
                pointer = heap.getLeft(pointer);
            } else if (path[i] == '1') {
                pointer = heap.getRight(pointer);
            } else System.err.println("WTF LOL");
        }
        return pointer;
    }

    public static int numberOfNodesInLastLevel(int size) {
        return (int) (size - Math.pow(2, Math.floor(Math.log(size) / Math.log(2))) + 1);
    }

    //take log2(n) rightmost bits
    public static String getPathToNode(int size, int index, int height) {

        int numberOfNodesExceptLastLevel = (int) Math.pow(2, height) - 1;

        int offset = numberOfNodesExceptLastLevel + index;

//        return getPathToLastNode(offset );

        int res = (int) (offset - Math.pow(2, Math.ceil(Math.log(offset) / Math.log(2))));

        String path = Integer.toBinaryString(res);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = path.length() - height; i < path.length(); i++) {
            stringBuilder.append(path.charAt(i));
        }


        return stringBuilder.toString();
    }

    //take log2(n) rightmost bits
    public static String getPathToLastNode(int size) {

        int res = (int) (size - Math.pow(2, Math.ceil(Math.log(size) / Math.log(2))));


        String path = Integer.toBinaryString(res);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = path.length() - 1; i >= path.length() - height(size); i--) {
            stringBuilder.append(path.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static int height(int size) {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
    }


}


