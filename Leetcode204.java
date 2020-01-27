import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/* Sieve of Erastosthenese */
public class Leetcode204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 500006382;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, false);
		int count = 0;
		
		/*
		Instant start = Instant.now();
		for (int i = 2; i < n; i++) {
			if (primes[i] == false) {
				count++;
				for (int j = i; i*j < n; j++) {
					primes[i*j] = true;
				}
			}
		}
		Instant finish = Instant.now();
		//System.out.println(Duration.between(start, finish).toMillis());
		System.out.println(count);
		*/
		count = 0;
		
		Instant start = Instant.now();
		for (int i = 2; i < n; i++) {
			if (primes[i] == false) {
				count++;
				for (int j = i; j < n; j = j + i) {
					primes[j] = true;
				}
			}
		}
		Instant finish = Instant.now();
		System.out.println(Duration.between(start, finish).toMillis());
		System.out.println(count);
	}
}
