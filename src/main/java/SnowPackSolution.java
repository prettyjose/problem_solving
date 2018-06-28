public class SnowPackSolution {
    static int findCapacity(int[] in) {

        int capacity = 0;
        int[] right=new int[in.length], left=new int[in.length];
        int i;
        left[0] = in[0];
        for(i=1;i<in.length;i++){
            left[i] = Math.max(left[i-1], in[i]);
        }
        right[in.length-1]=in[in.length-1];
        for(i=in.length-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], in[i]);
        }
        // for(i=0;i<in.length;i++) {
        //   System.out.print(right[i]+"  ");
        // }
        // System.out.println();
        // for(i=0;i<in.length;i++) {
        //   System.out.print(left[i]+"  ");
        // }
        for(i=0;i<in.length;i++)
            capacity += Math.abs( Math.min(left[i], right[i]) - in[i]);

        return capacity;
    }

    public static void main(String[] args) {

        // int[] in = new int[]{3,2,3,1,2,3,2,1,2};
        // int expected = 5;
        // int[] in = new int[]{3, 0, 0, 2, 0, 4};
        // int expected = 10;
        int[] in = new int[]{2,0,2};
        int expected = 2;
        int calculated = findCapacity(in);
        // System.out.println();
        // System.out.println(expected + " " + calculated);
        if(expected == calculated)
            System.out.println("Success. sum:: "+calculated);

    }
//    public static void main(String[] args) {
//
////        int[] in = new int[]{3,2,3,1,2,3,2,1,2};
//        int[] in = new int[]{3, 0, 0, 2, 0, 4};
////        int[] in = new int[]{2,0,2};
//        int diff=in[0] - in[1], sum=Math.abs(diff);
//        Boolean goingUp=( diff>=0 )?Boolean.FALSE : Boolean.TRUE;
//        int delta=0;
//        int n= in.length;
//        Boolean prevGoingUp;
//
//        // in={3,2,3,1,2,3,2,1,2};
//        // in=[2,0,2];
//
//        for(int i=1;i<n-1;i++) {
//            delta = in[i] - in[i+1];
//            prevGoingUp = goingUp;
//            if(delta >= 0)
//                goingUp = Boolean.FALSE;
//            else
//                goingUp = Boolean.TRUE;
//
//            if(prevGoingUp.equals(goingUp))
//                diff += delta;
//            else {
//                diff += delta;
//                sum += diff;
//            }
//
//            System.out.println(diff+" "+delta);
//            System.out.println(sum + " " + goingUp);
//
//        }
//        delta = in[n-2] - in[n-1];
//        sum+= delta;
//
//        System.out.print("sum: "+sum);
//    }
}
