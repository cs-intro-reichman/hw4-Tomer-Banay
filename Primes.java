public class Primes {
    public static void main(String[] args) {

        // Parse argument
        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            System.out.println("No primes");
            return;
        }

        // Get prime numbers up to n
        int[] primes = isPrime(n);

        // Print the prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        for (int prime : primes) {
            System.out.println(prime);
        }

        // Print the count and percentage
        int totNumbers = n; // Numbers from 2 to n inclusive
        System.out.println("There are " + primes.length + 
                            " primes between 2 and " + n + " (" + 
                            (primes.length * 100 / totNumbers) + "% are primes)");
    }

        // function for prime
    public static int[] isPrime(int n) {

        // Create a boolean array 
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // Assume all numbers true
        }

        // prime algorithm
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // Mark multiples of i as not prime
                }
            }
        }

        // Count the number of primes
        int primeCount = 0;
        for (boolean b : isPrime) {
            if (b) {
                primeCount++;
            }
        }

        // Collect the primes into an array
        int[] primes = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }
        return primes;
    }
}
