package cn.itcast.exception;

/**
 * 自定义异常类
 */
public class ZfsException extends Exception {
    //存储错误提示信息
    private String message;

    public ZfsException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
