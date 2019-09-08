package com.yidoughi.rest.mapper;
import com.yidoughi.domain.Message;
import com.yidoughi.dto.MessageDTO;

/**
 * @author yidoughi
 */

public class MessgeMapper {

    public static Message toMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setTopic(messageDTO.getTopic());
        message.setOtherData(messageDTO.getOtherData());
        return  message;
    }

    public static MessageDTO toMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId().toString());
        messageDTO.setContent(message.getContent());
        messageDTO.setOtherData(message.getOtherData());
        messageDTO.setCreatedAt(message.getSentAt());
        return messageDTO;
    }
}
