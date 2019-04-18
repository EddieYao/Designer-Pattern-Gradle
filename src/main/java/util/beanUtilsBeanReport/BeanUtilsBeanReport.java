package util.beanUtilsBeanReport;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.commons.beanutils.expression.Resolver;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.apache.commons.beanutils.ConvertUtils.lookup;


public class BeanUtilsBeanReport extends BeanUtilsBean {

    private static BeanUtilsBeanReport beanUtilsBeanReport = new BeanUtilsBeanReport();

    /**
     * Gets the instance which provides the functionality for {@link BeanUtils}.
     * This is a pseudo-singleton - an single instance is provided per (thread) context classloader.
     * This mechanism provides isolation for web apps deployed in the same container.
     *
     * @return The (pseudo-singleton) BeanUtils bean instance
     */
    public static BeanUtilsBeanReport getInstance() {
        return beanUtilsBeanReport;
    }


    /**
     * Return the value of the (possibly nested) property of the specified
     * name, for the specified bean, as a String.
     *
     * @param bean Bean whose property is to be extracted
     * @param name Possibly nested name of the property to be extracted
     * @return The nested property's value, converted to a String
     * @throws IllegalAccessException    if the caller does not have
     *                                   access to the property accessor method
     * @throws IllegalArgumentException  if a nested reference to a
     *                                   property returns null
     * @throws InvocationTargetException if the property accessor method
     *                                   throws an exception
     * @throws NoSuchMethodException     if an accessor method for this
     *                                   property cannot be found
     */
    @Override
    public String getNestedProperty(Object bean, String name)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        if (bean == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (name == null) {
            throw new IllegalArgumentException("No name specified for bean class '" +
                    bean.getClass() + "'");
        }
        Resolver resolver = getPropertyUtils().getResolver();
        // Resolve nested references
        while (resolver.hasNested(name)) {
            String next = resolver.next(name);
            Object nestedBean = null;
            if (bean instanceof Map) {
                nestedBean = getPropertyOfMapBean((Map<?, ?>) bean, next);
            } else if (resolver.isMapped(next)) {
                nestedBean = getMappedProperty(bean, next);
            } else if (resolver.isIndexed(next)) {
                nestedBean = getIndexedProperty(bean, next);
            } else {
                nestedBean = getSimpleProperty(bean, next);
            }
            if (nestedBean == null) {
                throw new NestedNullException
                        ("Null property value for '" + name +
                                "' on bean class '" + bean.getClass() + "'");
            }
            bean = nestedBean;
            name = resolver.remove(name);
        }

        if (bean instanceof Map) {
            bean = getPropertyOfMapBean((Map<?, ?>) bean, name);
        } else if (resolver.isMapped(name)) {
            bean = getMappedProperty(bean, name);
        } else if (resolver.isIndexed(name)) {
            bean = getIndexedProperty(bean, name);
        } else {
            bean = getSimpleProperty(bean, name);
        }
        return (convert(bean));
    }


    private Object getPropertyOfMapBean(Map<?, ?> bean, String propertyName)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {

        Resolver resolver = getPropertyUtils().getResolver();
        if (resolver.isMapped(propertyName)) {
            String name = resolver.getProperty(propertyName);
            if (name == null || name.length() == 0) {
                propertyName = resolver.getKey(propertyName);
            }
        }

        if (resolver.isIndexed(propertyName) ||
                resolver.isMapped(propertyName)) {
            throw new IllegalArgumentException(
                    "Indexed or mapped properties are not supported on"
                            + " objects of type Map: " + propertyName);
        }

        return bean.get(propertyName);
    }

    private String convert(Object value) {

        if (value == null) {
            return "";
        } else if (value.getClass().isArray()) {
            if (Array.getLength(value) < 1) {
                return "";
            }
            value = Array.get(value, 0);
            if (value == null) {
                return "";
            } else {
                final Converter converter = lookup(String.class);
                return (converter.convert(String.class, value));
            }
        } else {
            final Converter converter = lookup(String.class);
            return (converter.convert(String.class, value));
        }

    }
}
