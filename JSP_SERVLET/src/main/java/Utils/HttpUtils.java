package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
 
public class HttpUtils {
	private String value;

	public HttpUtils(String value) {
		this.value = value;
	}

	public static HttpUtils of(BufferedReader reader) {
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtils(sb.toString());
	}

	public <T> T convertToModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static <T> void convertToJSON(OutputStream ops, T t) {
		try {
			new ObjectMapper().writeValue(ops, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
