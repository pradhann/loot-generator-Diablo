import java.util.*;
import java.io.*;

public class PreSuf {
	
	private ArrayList<String> name;
	private ArrayList<String> code;
	private ArrayList<Integer> min;
	private ArrayList<Integer> max;

	public PreSuf(File file) throws FileNotFoundException {
		Scanner sn = new Scanner(file);
		while(sn.hasNextLine()) {
			String[] columns = sn.nextLine().split("/t");
			name.add(columns[0]);
			code.add(columns[1]);
			min.add(Integer.parseInt(columns[2]));
			max.add(Integer.parseInt(columns[3]));
		}
		sn.close();
	}
	/**
	 * to pick or not to pick an affix
	 * @return true iff we are to pick
	 */
	
	public boolean pick() {
		Random rnd = new Random();
		int n = rnd.nextInt(2);
		return n > 0;
	}
	/**
	 * produces a random int to select from the names
	 * @return a random int 
	 */
	public int randomIndex() {
		Random rnd = new Random();
		int rndIndex = rnd.nextInt(name.size());
		return rndIndex;
	}
	/**
	 * returns the String from the provided random index
	 * @param index
	 * @return String at index from names 
	 */
	public String randomAffix(int index) {
		String ret = name.get(index);
		return ret;
	}
	
	/**
	 * return the String from the provided index from code
	 * @param index
	 * @return String at index from code
	 */
	
	public String codeName(int index) {
		return code.get(index);
	}
	
	/**
	 * boost value within the range 
	 * @param index
	 * @return an int that indicates the boost of the affix
	 */
	public int boostVal(int index) {
		int minimum = min.get(index);
		int maximum = max.get(index);
		Random rnd = new Random();
		int ret = minimum + rnd.nextInt(maximum - minimum + 1);
		return ret;
	}
}















