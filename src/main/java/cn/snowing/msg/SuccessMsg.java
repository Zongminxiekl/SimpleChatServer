package cn.snowing.msg;

public class SuccessMsg implements ReturnMsg{
    //type有0、1两个值。0代表失败，1代表成功
    private final   Integer type = 1;
    private final String msgContent = "success";
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
