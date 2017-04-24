import java.util.*;
import java.io.*;
public class Armor {

	private Map<String, ArrayList<Integer>> armor;

	public Armor (File file) throws FileNotFoundException {
		Scanner sn = new Scanner(file);
		while(sn.hasNextLine()) {
			String[] columns = sn.nextLine().split("/t");
			ArrayList<Integer> range = new ArrayList<>();
			range.add(Integer.parseInt(columns[1]));
			range.add(Integer.parseInt(columns[2]));
			armor.put(columns[0], range);
		}
		sn.close();
	}

	public int baseStats(String item) {
		Random rnd = new Random();
		ArrayList<Integer> range = armor.get(item);
		int ret = range.get(0) + rnd.nextInt(range.get(1) - range.get(0) + 1);
		return ret;
	}
}
