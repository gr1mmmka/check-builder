package example.util;

import example.model.Good;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static example.Constants.PROMO_GOODS;
import static java.lang.String.format;

public class ServiceUtil {
	public static String buildHeader() {
		return "Date: " + LocalDate.now() + "\n" +
			"Time: " + LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + "\n" +
			format("%-10s %-10s %-10s %s", "QTY", "Name", "Price", "Total") + "\n";
	}

	public static String buildFootBar(double totalPrice) {
		return "-----------------------------------------" + "\n" +
			"-----------------------------------------" + "\n" +
			format("%-32s %,.2f", "TAXABLE PRICE", totalPrice) + "\n" +
			format("%-32s %,.2f", "TAX", totalPrice * 0.2) + "\n" +
			format("%-32s %,.2f", "TOTAL PRICE", totalPrice * 1.2) + "\n";
	}

	public static String formatListOfGoods(int quantity, Good good) {
		return format("%-10s %-10s %-10s %,.2f", quantity, good.name(), good.price(), totalPrice(quantity, good.price()));
	}

	public static double totalPrice(int quantity, double price) {
		return price * quantity;
	}

	public static boolean isPromoGood(Good good) {
		return PROMO_GOODS.contains(good.name());
	}
}
