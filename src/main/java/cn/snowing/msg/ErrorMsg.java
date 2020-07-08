package cn.snowing.msg;

/**
 * 简易的错误消息提示类
 */
public class ErrorMsg implements ReturnMsg {
    //type有0、1两个值。0代表失败，1代表成功
    private final   Integer type = 0;
    private final String msgContent = "error";
    @Override
    public ReturnMsg getReturnMsg() {
        return new ErrorMsg();
    }

    public Integer getType() {
        return type;
    }

    public String getMsgContent() {
        return msgContent;
    }
}
