package com.threenoodles.platform.muldb;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

/**
 * @author threenoodles
 *
 */
public class MultipleDataSourceAspect {

    private static final Logger LOG = org.apache.log4j.Logger.getLogger(MultipleDataSourceAspect.class);

    public Object doAround(ProceedingJoinPoint jp) throws Throwable {

        if (LOG.isDebugEnabled()) {
            LOG.debug("MultipleDataSourceAspectAdvice invoked!");
        }

        Signature signature = jp.getSignature();

        String dataSourceKey = getDataSourceKey(signature);

        if (StringUtils.hasText(dataSourceKey)) {
            MultipleDataSource.setDataSourceKey(dataSourceKey);
        }

        Object jpVal = jp.proceed();

        return jpVal;


    }

    private String getDataSourceKey(Signature signature) {
        if (signature == null) return null;

        if (signature instanceof MethodSignature) {

            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            if (method.isAnnotationPresent(DataSource.class)) {
                return dsSettingInMethod(method);
            }

            //类级注解
            Class<?> declaringClazz = method.getDeclaringClass();
            if (declaringClazz.isAnnotationPresent(DataSource.class)) {
                try {
                    return dsSettingInConstructor(declaringClazz);
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }

            Package pkg = declaringClazz.getPackage();
            dsSettingInPackage(pkg);

        }

        return null;
    }

    private String dsSettingInMethod(Method method) {
        DataSource dataSource = method.getAnnotation(DataSource.class);
        return dataSource.value();
    }

    private String dsSettingInConstructor(Class<?> clazz) {
        DataSource dataSource = (DataSource) clazz.getAnnotation(DataSource.class);
        return dataSource.value();
    }

    private void dsSettingInPackage(Package pkg) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(pkg.getName());
        }
        MultipleDataSource.usePackageDataSource(pkg.getName());
    }


}
