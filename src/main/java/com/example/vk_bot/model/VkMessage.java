package com.example.vk_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VkMessage {

    private String type;
    private VkObject object;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VkObject getObject() {
        return object;
    }

    public void setObject(VkObject object) {
        this.object = object;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VkObject {

        private VkInnerMessage message;

        public VkInnerMessage getMessage() {
            return message;
        }

        public void setMessage(VkInnerMessage message) {
            this.message = message;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class VkInnerMessage {

            private Integer from_id;
            private String text;

            public Integer getFrom_id() {
                return from_id;
            }

            public void setFrom_id(Integer from_id) {
                this.from_id = from_id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
