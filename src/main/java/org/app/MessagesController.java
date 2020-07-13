package org.app;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.app.models.IncomingMessage;
import org.app.models.Message;

@RestController
public class MessagesController {

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return MessagesHandler.getInstance().getAllUnreadMessages();
    }

    @PostMapping("/messages")
    public ResponseEntity addMessage(
            @RequestBody IncomingMessage incomingMessage) {
        return MessagesHandler.getInstance().addSingleMessage(incomingMessage);
    }
}
