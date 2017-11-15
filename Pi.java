import java.util.concurrent.ThreadLocalRandom;

public class Pi {
    public static void main(String[] args) {
        int threads = -1;
        int iterations = -1;
        long timestamp = System.currentTimeMillis();

        try {
            threads = Integer.parseInt(args[0]);
            iterations = Integer.parseInt(args[1]);
            if (iterations < 1 || threads < 1) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Arguments should be two ints, <# threads> <# iterations>");
            System.exit(1);
        }

        final int iterationsPerThread = iterations / threads;

        /* Arrays to hold the number of "dart throws inside the circle"
         * for each "dart thrower" as well as each of the "dart throwers" 
         * we need to keep track of */
        int[] insideArray = new int[threads];
        Thread[] threadArray = new Thread[threads];

        /* Each thread writes its results to an index parallel to it's
         * "id", or it's own index in the thread array */
        for (int i = 0; i < threads; i++) {
            final int fi = i;

            threadArray[fi] = new Thread(() -> {
                insideArray[fi] = calculateInside(iterationsPerThread);
            });
        }

        try {
            for (Thread thread : threadArray) {
                thread.start();
            }
            for (Thread thread : threadArray) {
                thread.join();
            }
        } catch (InterruptedException iex) {
            // we broken
        }

        int totalInside = 0;

        for (int n : insideArray) {
            totalInside += n;
        }

        double ratio = (double) totalInside / (double) iterations;
        System.out.println("Total\t= " + iterations);
        System.out.println("Inside\t= " + totalInside);
        System.out.println("Ratio\t= " + ratio);
        System.out.println("Pi\t= " + ratio * 4);

        long newTimestamp = System.currentTimeMillis();
        long deltaTime = newTimestamp - timestamp;
        System.out.println("\nTime\t= " + deltaTime + " ms");
    }

    private static int calculateInside(int iterations) {
        int numPointsInside = 0;
        for (int i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble(1);
            double y = ThreadLocalRandom.current().nextDouble(1);
            if (x * x + y * y < 1) {
                numPointsInside++;
            }
        }
        return numPointsInside;
    }
}