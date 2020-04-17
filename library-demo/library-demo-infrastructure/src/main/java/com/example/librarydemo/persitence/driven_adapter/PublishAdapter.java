package com.example.librarydemo.persitence.driven_adapter;

import com.example.librarydemo.application.shared.port.IPublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishAdapter implements IPublish {

    private final Logger LOGGER = LoggerFactory.getLogger(PublishAdapter.class);

    @Override
    public void publishMessage(String message) {
        LOGGER.info("Publish message: " + message);
    }
}
