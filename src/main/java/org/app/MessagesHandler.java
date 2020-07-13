package org.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.app.models.IncomingMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.app.models.Message;

public class MessagesHandler {
    private static MessagesHandler instance;
    private static int nextId = 0;
    private static ConcurrentHashMap<Integer, Message> storage;

    static {
        instance = new MessagesHandler();
        storage = new ConcurrentHashMap<>();
    }

    private MessagesHandler() {
    }

    public static MessagesHandler getInstance() {
        return instance;
    }

    public ResponseEntity addSingleMessage(IncomingMessage incomingMessage) {
        storage.put(nextId, new Message(nextId, incomingMessage.getUser(), incomingMessage.getMessage()));
        nextId++;

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Message> getAllUnreadMessages() {
        return new ArrayList<>(storage.values());
    }
}
