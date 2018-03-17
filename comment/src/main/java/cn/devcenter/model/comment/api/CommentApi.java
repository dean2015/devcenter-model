package cn.devcenter.model.comment.api;

import cn.devcenter.model.comment.Comment;
import cn.devcenter.model.repository.CurdRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface CommentApi extends CurdRepository<Comment, Serializable> {

    Serializable retrieve(Comment comment);

    Page<Comment> findByItem(Comment condition, Pageable pageable);

    Page<Comment> findByRaiser(Comment condition, Pageable pageable);

}
