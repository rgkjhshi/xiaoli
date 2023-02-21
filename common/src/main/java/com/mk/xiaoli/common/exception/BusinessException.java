package com.mk.xiaoli.common.exception;


import com.mk.xiaoli.common.enums.ExceptionEnum;

/**
 * <p>使用举例:</p>
 * <p>1. 构造方法: {@link #BusinessException(int, String)}, {@link #BusinessException(ExceptionEnum)}和{@link #BusinessException(ExceptionEnum, String)}
 * <pre>
 * throw new BusinessException(code, message); // 自定义响应码和响应描述信息
 * throw new BusinessException(ExceptionEnum.SYSTEM_ERROR); // 抛出某类型的异常
 * throw new BusinessException(ExceptionEnum.BUSINESS_ERROR, "rpc调用异常");  // 抛出某类型的异常, 并加上具体描述, 最终描述信息将变成: "业务异常:rpc调用异常"
 * throw new BusinessException(ExceptionEnum.INVALID_PARAMETER, "userId不能为空"); // 抛出某类型的异常, 并加上具体描述, 最终描述信息将变成: "参数错误:userId不能为空"
 * </pre></p>
 *
 * <p>2. 异常的使用场景
 * <pre>
 * try { ... } catch (BusinessException e) {
 *     Response response = Response(e.getCode(), e.getReturnMessage());
 * }
 *
 * try {
 *     Preconditions.checkNotNull(request, "请求参数不能为空");    // 抛出 NullPointerException
 *     Preconditions.checkArgument(!Strings.isNullOrEmpty(mobile), "mobile不能为空");   // 抛出 IllegalArgumentException
 * } catch (Exception e) {
 *     throw new BusinessException(ExceptionEnum.INVALID_PARAMETER, e.getMessage());
 * }
 * </pre></p>
 *
 * @author song.shi
 * @since 2016-04-05
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 4067917628321917086L;

    /**
     * 错误码, 美团的错误码用的是int类型
     */
    private int code;
    private String message;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 根据枚举类创建异常, 以枚举类的描述信息作为异常的message
     */
    public BusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    /**
     * 根据枚举类创建异常, 并补充具体的错误描述信息, 以枚举描述+detail作为异常的message
     */
    public BusinessException(ExceptionEnum exceptionEnum, String detail) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        String message = exceptionEnum.getMessage();
        if (detail != null && !detail.isEmpty()) {
            message = message + ":" + detail;
        }
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 业务异常不需要跟踪堆栈信息，减少VM在抛异常时java进程的子线程的停顿
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
