package sieveoferatosthenes;

/**
 *
 * @author ncpow
 */
public class SieveOfEratosthenes {

    /**
     *  We could optimize the code below by only including even numbers! 
     */
    
    static boolean[] sieveOfEratosthenese( int max ) {
        boolean[] flags = new boolean[max + 1];        
        for ( int i = 2; i < max; i++ ) {
            flags[i] = true;
        }
        int prime = 2;
        
        while ( prime <= Math.sqrt(max)) {
            // cross off remaining multiples of prime
            crossOff(flags, prime);
            
            // find next value which is true
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }
    
    static void crossOff(boolean[] flags, int prime ) {
        /** Cross off remaining multiples of prime we can start with prime * prime
         *  because if we already have k * prime, where k < prime, this would have
         *  already been crossed off in a prior iteration,
         */ 
        for ( int i = prime * prime; i < flags.length; i++ ) {
            flags[i] = false;
        }
    }
    
    static int getNextPrime( boolean[] flags, int prime ) {
        int next = prime + 1;
        while ( next < flags.length && !flags[next] ) {
            next++;
        }
        return next;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sieveOfEratosthenese(100));
    }
    
}
