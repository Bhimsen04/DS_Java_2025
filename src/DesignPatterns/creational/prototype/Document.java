package DesignPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Document implements IPrototype {

    private String title;
    private String content;
    private List<String> attachments;

    public Document(String title, String content, List<String> attachments) {
        this.title = title;
        this.content = content;
        this.attachments = attachments;
    }

    @Override
    public IPrototype clone() {
        return new Document(
                this.title,
                this.content,
                new ArrayList<>(this.attachments) // deep copy of list
        );
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}

