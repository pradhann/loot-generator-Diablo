import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
public class Armor {

	private Map<String, ArrayList<Integer>> armor;
	
	public Armor (File file) throws FileNotFoundException {
		armor = new HashMap<String, ArrayList<Integer>>();
		Scanner sn = new Scanner(file);
		while(sn.hasNextLine()) {
			String[] columns = sn.nextLine().split("\t");
			ArrayList<Integer> range = new ArrayList<Integer>();
			range.add(0, Integer.parseInt(columns[1]));
			range.add(1, Integer.parseInt(columns[2]));
			armor.put(columns[0], range);
		}
		sn.close();
	}

	public int baseStats(String item) {
		Random rnd = ThreadLocalRandom.current();
		
		ArrayList<Integer> range = armor.get(item);
		int min = range.get(0);
		int max = range.get(1);
		int ret = min + rnd.nextInt(max - min + 1);
		return ret;
	}
}
