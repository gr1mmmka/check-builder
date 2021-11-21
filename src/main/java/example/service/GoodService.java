package example.service;

import example.model.Good;

import java.util.List;
import java.util.Optional;

public interface GoodService {
	String buildCheck(List<String> ids);

	Optional<Good> getGood(int id);
}
