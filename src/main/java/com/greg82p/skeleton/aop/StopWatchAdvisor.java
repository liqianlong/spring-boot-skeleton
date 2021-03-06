package com.greg82p.skeleton.aop;

import java.lang.reflect.Method;

import javax.inject.Inject;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.stereotype.Component;

@Component
public class StopWatchAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	@Inject
	private StopWatchMethodInterceptor interceptor;

	private final StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.isAnnotationPresent(StopWatchExecution.class);
		}
	};

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

	@Override
	public Advice getAdvice() {
		return this.interceptor;
	}
}
