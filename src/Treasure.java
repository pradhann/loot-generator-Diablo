import java.util.*;
import java.io.*;

public class Treasure {

	private Map<String, ArrayList<String>> treasures;

	public Treasure(File file) throws IOException {
		treasures = new HashMap<String, ArrayList<String>>();
		Scanner in = new Scanner(file);

		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("/t");
			ArrayList<String> items = new ArrayList<>();
			items.add(columns[1]);
			items.add(columns[2]);
			items.add(columns[3]);
			treasures.put(columns[0], items);
		}
		in.close();
	}

	public String getbaseItem(String treasureClass) {
		String baseItem = treasureClass;

		while (treasures.containsKey(baseItem)) {
			ArrayList<String> items = treasures.get(baseItem);
			Random rnd = new Random();
			baseItem = getbaseItem(items.get(rnd.nextInt(items.size())));
		}
		return baseItem;
	}

}
