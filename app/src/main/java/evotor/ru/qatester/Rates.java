package evotor.ru.qatester;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nixan on 17.06.16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
	private final String base;
	private final String date;
	private final Map<String, BigDecimal> values;

	@JsonCreator
	public Rates(@JsonProperty("base") String base, @JsonProperty("date") String date, @JsonProperty("rates") Map<String,
			BigDecimal>
			values) {
		this.base = base;
		this.date = date;
		this.values = values;
	}

	public String getBase() {
		return base;
	}

	public String getDate() {
		return date;
	}

	public Map<String, BigDecimal> getValues() {
		return values;
	}
}
