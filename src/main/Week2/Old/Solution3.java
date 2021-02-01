package main.Week2.Old;

class Solution3 {
    public static double[][] clone(double[][] a) {


        if (a == null) return null;

        double[][] b = new double[a.length][];

        for (int c = 0; c < a.length; c++) {
            b[c] = new double[a[c].length];
            System.arraycopy(a[c], 0, b[c], 0, a[c].length);
            //or
//            for(int r = 0; r < a[c].length ; r++){
//                b[c][r] = a[c][r];
//            }

        }

        return b;

//        double[][] b = new double[a.length][];
//        for (int i = 0; i < a.length; i++) {
//            double[] dArr = a[i];
//            if (dArr == null) {
//                b[i] = null;
//                continue;
//            }
//
//            double[] dClone = new double[dArr.length];
//            for (int i2 = 0; i2 < dArr.length; i2++) {
//                dClone[i2] = dArr[i2];
//            }
//            b[i] = dClone;
//        }
//        return b;
    }
}
