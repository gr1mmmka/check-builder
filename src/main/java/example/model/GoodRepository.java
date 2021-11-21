package example.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GoodRepository {

	public Map<Integer, Good> getGoods() throws IOException {
		List<String> lines;
		try (InputStream inputStream = getClass().getResourceAsStream("/goods.txt");
				 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			lines = reader.lines()
				.toList();
		}

		return lines.stream()
			.collect(Collectors.
				toMap(s -> Integer.parseInt(s.split("-")[0]), s ->
					new Good(Integer.parseInt(s.split("-")[0]), s.split("-")[1], Double.parseDouble(s.split("-")[2])))
			);
	}

	public Optional<Good> getGood(int id) throws IOException {
		List<String> lines;
		try (InputStream inputStream = getClass().getResourceAsStream("/goods.txt");
				 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			lines = reader.lines()
				.toList();
		}

		return lines.stream()
			.filter(s -> s.split("-")[0].equals(String.valueOf(id)))
			.findFirst()
			.map(s ->
				new Good(Integer.parseInt(s.split("-")[0]), s.split("-")[1], Double.parseDouble(s.split("-")[2])));

	}
}
