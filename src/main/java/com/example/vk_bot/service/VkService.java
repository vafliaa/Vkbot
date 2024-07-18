package com.example.vk_bot.service;

import com.example.vk_bot.model.VkMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VkService {

    @Value("${vk.api.version}")
    private String apiVersion;

    @Value("${vk.api.token}")
    private String apiToken;

    @Value("${vk.confirmation.code}")
    private String confirmationCode;

    private final RestTemplate restTemplate = new RestTemplate();

    public String handleMessage(VkMessage message) {
        if ("confirmation".equals(message.getType())) {
            return confirmationCode;
        } else if ("message_new".equals(message.getType())) {
            String text = message.getObject().getMessage().getText();
            sendMessage(message.getObject().getMessage().getFrom_id(), text);
            return "ok";
        }
        return "ok";
    }

    private void sendMessage(Integer userId, String text) {
        String url = String.format(
                "https://api.vk.com/method/messages.send?user_id=%d&message=%s&random_id=%d&access_token=%s&v=%s",
                userId, text, System.currentTimeMillis(), apiToken, apiVersion
        );
        restTemplate.getForObject(url, String.class);
    }

    public String handleConfirmation() {
        return confirmationCode;
    }
}
