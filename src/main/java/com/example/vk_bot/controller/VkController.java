package com.example.vk_bot.controller;

import com.example.vk_bot.model.VkMessage;
import com.example.vk_bot.service.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vk-bot/test")
public class VkController {

    @Autowired
    private VkService vkService;

    @PostMapping
    public String callback(@RequestBody VkMessage message) {
        if ("confirmation".equals(message.getType())) {
            return vkService.handleConfirmation();
        } else {
            return vkService.handleMessage(message);
        }
    }
}

