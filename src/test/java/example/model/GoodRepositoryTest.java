package example.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class GoodRepositoryTest {
	GoodRepository goodRepository = new GoodRepository();

	@Test
	void shouldReturnGoodObject() throws IOException {
		var good = goodRepository.getGood(2).get();

		assertThat(good).isInstanceOf(Good.class);
	}

	@Test
	void shouldReturnAllGoods() throws IOException {
		var goods = goodRepository.getGoods();

		assertThat(goods).hasSize(10);
	}
}
