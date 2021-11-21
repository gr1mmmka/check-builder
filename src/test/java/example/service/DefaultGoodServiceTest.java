package example.service;

import example.model.Good;
import example.model.GoodRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultGoodServiceTest {
	GoodService goodService = new DefaultGoodService(new GoodRepository());

	@Test
	void shouldBuildCheck() {
		var bill = goodService.buildCheck(List.of("1-3", "4-5", "card #12313"));

		assertThat(bill).isInstanceOf(String.class);
		assertThat(bill).isNotBlank();
	}

	@Test
	void getGood() {
		var good = goodService.getGood(10).get();

		assertThat(good).isInstanceOf(Good.class);
		assertThat(good.id()).isEqualTo(10);
		assertThat(good.name()).isEqualTo("fantasy is over;(");
	}
}
