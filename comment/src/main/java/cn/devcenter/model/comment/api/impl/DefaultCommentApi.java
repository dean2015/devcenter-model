package cn.devcenter.model.comment.api.impl;

import cn.devcenter.model.comment.Comment;
import cn.devcenter.model.comment.api.CommentApi;
import cn.devcenter.model.comment.dao.CommentDAO;
import cn.devcenter.model.repository.exception.NotSupportedException;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultCommentApi implements CommentApi {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment save(Comment object) {
        return commentDAO.save(object);
    }

    @Override
    public <E> Page<Comment> find(E condition, Pageable pageable) {
        throw new NotSupportedException();
    }

    @Override
    public Comment findById(Serializable id) {
        throw new NotSupportedException();
    }

    @Override
    public Serializable delete(Serializable id) {
        return commentDAO.delete(id);
    }

    @Override
    public Serializable update(Comment object) {
        throw new NotSupportedException();
    }

    @Override
    public Serializable retrieve(Comment comment) {
        return commentDAO.update(comment);
    }

    @Override
    public <E> Page<Comment> findByItem(E condition, Pageable pageable) {
        return commentDAO.find(condition, pageable);
    }

    @Override
    public <E> Page<Comment> findByRaiser(E condition, Pageable pageable) {
        return commentDAO.find(condition, pageable);
    }
}
