package com.mscharhag.exceptiontranslation.aspect;

import com.mscharhag.exceptiontranslation.exception.DataAccessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;

@Aspect
public class ExceptionTranslationAspect {

	@Around("execution(* com.mscharhag.exceptiontranslation.repository..*(..))")
	public Object doStuff(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (HibernateException e) {
			throw new DataAccessException(e);
		}
	}
}
