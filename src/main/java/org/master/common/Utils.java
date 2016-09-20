package org.master.common;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaenry on 2016/9/20.
 * Utils
 */
public class Utils {

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    // java 1.8 lambda
//    public static String[] getNullPropertyNames(Object source) {
//        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
//        return Stream.of(wrappedSource.getPropertyDescriptors())
//                .map(FeatureDescriptor::getName)
//                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
//                .toArray(String[]::new);
//    }

}
