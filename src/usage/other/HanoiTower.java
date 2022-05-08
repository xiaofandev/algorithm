package usage.other;

/**
 * Formula proof
 * 
 * Assume that the question of how many steps that n layer hanoi 
 * move to middle need can be represented by function f(n).
 * The question described above can be decomposed to two questions:
 * 1.How many steps need to move n-1 layer hanoi to right?
 * 2.Moving number n layer to middle needs 1 setp.
 * 3.How many steps needs to move n-1 layer hanoi to middle?
 * According to the description of question 1 and quesion 3,we can know 
 * that these question is the same.Thus,Hanoi Problem can be described by
 * the formula: F(n) = 2F(n-1)+1
 *
 */
public class HanoiTower {

	/**
	 * 
	 * According to hanoi layer count,acculate the result of
	 * how many steps need to move all hanois from left to middle
	 */
	public static int fn(int n) {
		// assert n > 0
		if(n == 1) {
			return 1;
		} else {
			return 2*fn(n-1)+1;
		}
	}
	
}
