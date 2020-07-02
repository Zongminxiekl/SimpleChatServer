package cn.snowing.test;

import cn.snowing.domain.Message;
import cn.snowing.services.message.domian.MessageSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TestJackJson {
    @Test
    public void testCompJson(){
        List<MessageSession> messageSessionList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream ins = TestJackJson.class.getClassLoader().getResourceAsStream("test.json");
        try {
            MessageSession[] messageSessions = objectMapper.readValue(ins, MessageSession[].class);
            messageSessionList = Arrays.asList(messageSessions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (messageSessionList != null){
            int i = 0;
            for (MessageSession messageSession : messageSessionList) {
                List<Message> messageList = messageSession.getMessageSession();
                System.out.println("第个"+ (++i) + "消息会话");
                for (Message message : messageList) {
                    System.out.println(message);
                }
            }
        }
    }
}
