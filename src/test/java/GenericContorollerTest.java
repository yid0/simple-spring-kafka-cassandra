import com.fasterxml.jackson.databind.ObjectMapper;
import com.yidoughi.Application;
import com.yidoughi.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class GenericContorollerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProduceNewMessage() throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTopic("new-topic");
        messageDTO.setContent("hello world");
        ObjectMapper objectMapper = new ObjectMapper();
        String StringMessage = objectMapper.writeValueAsString(messageDTO);
        this.mockMvc.perform(post( "/produce")
                .content(StringMessage)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllMessage() throws Exception {
        this.mockMvc.perform(get( "/message"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMessage() throws Exception {
        UUID id = UUID.randomUUID();
        this.mockMvc.perform(get( "/message/".concat(id.toString())))
                .andExpect(status().isOk());
    }
}
