package example.service;

import example.excepton.GoodNotFoundException;
import example.model.Good;
import example.model.GoodRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static example.util.ServiceUtil.buildFootBar;
import static example.util.ServiceUtil.buildHeader;
import static example.util.ServiceUtil.formatListOfGoods;
import static example.util.ServiceUtil.isPromoGood;
import static example.util.ServiceUtil.totalPrice;

public record DefaultGoodService(GoodRepository goodRepository) implements GoodService {

	@Override
	public String buildCheck(List<String> ids) {
		String card = null;
		double totalPrice = 0;
		var builder = new StringBuilder();
		builder.append(buildHeader());

		for (String s : ids) {
			if (s.startsWith("card")) {
				card = s;
				continue;
			}
			var quantity = s.split("-")[0];
			var id = s.split("-")[1];
			var good = getGood(Integer.parseInt(id)).get();
			builder.append(formatListOfGoods(Integer.parseInt(quantity), good)).append("\n");

			if (isPromoGood(good)) {
				totalPrice += totalPrice(Integer.parseInt(quantity), good.price()) * 0.9;
			} else {
				totalPrice += totalPrice(Integer.parseInt(quantity), good.price());
			}
		}
		builder.append(buildFootBar(totalPrice));
		builder.append("discount card - ").append(card);

		return builder.toString();
	}

	@Override
	public Optional<Good> getGood(int id) {
		Optional<Good> good = Optional.empty();
		try {
			good = goodRepository.getGood(id);
			if (good.isEmpty()) throw new GoodNotFoundException("Invalid id of good");
		} catch (IOException | GoodNotFoundException e) {
			e.printStackTrace();
		}
		return good;
	}
}
