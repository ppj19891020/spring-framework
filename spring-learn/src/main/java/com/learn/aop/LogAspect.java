package com.learn.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: peijiepang
 * @date 2019-09-05
 * @Description:
 */
@Aspect
public class LogAspect {

	/**
	 * 切面方法
	 */
	@Pointcut("execution(public * com.learn.services.MathService.*(..))")
	public void pointcut(){};

	/**
	 * 前置通知
	 */
	@Before(value = "pointcut()")
	public void logstart(JoinPoint joinPoint){
		System.out.println("before 参数为:"+joinPoint.getArgs());
	}

	/**
	 * 后置通知
	 * JoinPoint参数一定要出现在参数表的第一位
	 */
	@After(value = "pointcut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println("after 方法:"+joinPoint.getSignature().getName());
	}

	/**
	 * 返回通知
	 */
	@AfterReturning(value = "pointcut()",returning = "result")
	public void logreturn (Object result){
		System.out.println("return 通知 结果是:"+result);
	}

	/**
	 * 异常通知
	 */
	@AfterThrowing(value = "pointcut()",throwing = "ex")
	public void logException(Exception ex){
		System.out.println("after throwing error:"+ex.getMessage());
	}

	/**
	 * 环绕通知
	 */
	@Around(value = "pointcut()")
	public Object logAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		System.out.println("logAround1");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("logAround2");
		return result;
	}

}
