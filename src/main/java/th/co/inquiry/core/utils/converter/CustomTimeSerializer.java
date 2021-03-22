package th.co.inquiry.core.utils.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomTimeSerializer extends JsonSerializer<java.sql.Time> {

	@Override
	public void serialize(java.sql.Time value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
		
		if (value != null) {
			jgen.writeString(dateFormat.format(value));
		} else {
			jgen.writeString("");
		}
	}

}