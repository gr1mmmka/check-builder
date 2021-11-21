package example;

import example.model.GoodRepository;
import example.service.DefaultGoodService;
import example.service.GoodService;

import java.util.List;

public class Runner {
	public static void main(String[] args) {
		GoodService service = new DefaultGoodService(new GoodRepository());

		System.out.println(service.buildCheck(List.of(args)));
	}
}
