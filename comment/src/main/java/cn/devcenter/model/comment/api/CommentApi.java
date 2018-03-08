package cn.devcenter.model.comment.api;

import cn.devcenter.model.template.api.CurdTemplate;
import cn.devcenter.model.comment.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface CommentApi extends CurdTemplate<Comment> {

    Serializable retrieve(Comment comment);

    <E> Page<Comment> findByItem(E condition, Pageable pageable);

    <E> Page<Comment> findByRaiser(E condition, Pageable pageable);

}
