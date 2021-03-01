package com.mytask.emailservice.model;

import com.mytask.emailservice.util.First;
import com.mytask.emailservice.util.Second;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@GroupSequence({Message.class, First.class, Second.class})
public class Message {

    @NotBlank(groups = First.class, message = "must not be null or empty")
    @Pattern(regexp = "^email$", groups = Second.class, message = "must be equals to email")
    private String type;

    @NotBlank(groups = First.class, message = "must not be null or empty")
    @Size(min = 1, max = 300, groups = Second.class, message = "length must be in [1,300]")
    private String text;

    public Message() {
    }

    public Message(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(getType(), message.getType()) &&
                Objects.equals(getText(), message.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getText());
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
