package z.blog.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import z.blog.model.entity.Comment;

import java.util.Set;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Comments extends Comment {

    private int level;

    private Set<Comments> list;

    public Comments() {
    }

    public Comments(Comment comment) {
        setCid(comment.getCid());
        setAid(comment.getAid());
        setParent(comment.getParent());
        setAuthor(comment.getAuthor());
        setMail(comment.getMail());
        setUrl(comment.getUrl());
        setIp(comment.getIp());
        setAgent(comment.getAgent());
        setContent(comment.getContent());
        setType(comment.getType());
        setStatus(comment.getStatus());
        setCreateTime(comment.getCreateTime());
    }
}