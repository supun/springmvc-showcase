package vikram.demo.springmvc.argresolver;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class PersonEntityResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter, final NativeWebRequest webRequest)throws Exception {
		
		Class<?> beanClass = methodParameter.getParameterType();
		
		if(beanClass.isAnnotationPresent(PersonEntity.class)){
			final HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
			final Object customBean = BeanUtils.instantiate(beanClass);
			Map<String, Object> parameterMap = servletRequest.getParameterMap();
			Set<Entry<String, Object>> entrySet = parameterMap.entrySet();
			for (Entry<String, Object> entry : entrySet) {

				if(entry.getValue() != null){
					Field field = ReflectionUtils.findField(beanClass, entry.getKey());
					ReflectionUtils.setField(field, customBean, entry.getValue());
				}
			}
		
			return customBean;
		}
		return UNRESOLVED;
	}

}
