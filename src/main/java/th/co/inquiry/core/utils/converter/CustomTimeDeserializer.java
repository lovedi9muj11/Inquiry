package th.co.inquiry.core.utils.converter;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomTimeDeserializer extends JsonDeserializer<Time> {

	Logger logger = LoggerFactory.getLogger(CustomTimeDeserializer.class);

	@Override
	public Time deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Time result = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
			if (StringUtils.isNotEmpty(node.asText())) {
				Date refDate = (Date) dateFormat.parse(node.asText());
				result = new Time(refDate.getTime());
			}
		} catch (ParseException e) {
			logger.error("Can't parse " + node.asText() + " to java.sql.Time()", e);
		}
		return result;
	}
}
