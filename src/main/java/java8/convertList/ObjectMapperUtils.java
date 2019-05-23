package java8.convertList;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于不同类型的对象数据转换（包括List）
 */
public class ObjectMapperUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();

	
	public static <T> T convertValue(Object object, Class<T> clazz) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(df);
		objectMapper.setDateFormat(df1);
		return (T)objectMapper.convertValue(object, clazz);
	}
	
	public static List convertValueList(Object object, Class clazz) {
		List list = new ArrayList();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(df);
		objectMapper.setDateFormat(df1);
		
		if (object instanceof List) {
			List tmpList = (List)object;
			for (int i = 0; i < tmpList.size(); i++) {
				list.add(objectMapper.convertValue(tmpList.get(i), clazz));
			}
		}
		
		return list;
	}

}
