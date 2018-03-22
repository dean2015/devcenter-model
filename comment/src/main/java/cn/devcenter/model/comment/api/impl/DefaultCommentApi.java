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


    @Override
    public Serializable retrieve(Comment comment) {
        return null;
    }

    @Override
    public Page<Comment> findByItem(Comment condition, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Comment> findByRaiser(Comment condition, Pageable pageable) {
        return null;
    }

    @Override
    public Comment save(Comment object) {
        return null;
    }


    @Override
    public Comment findById(Serializable serializable) {
        return null;
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Serializable deleteById(Serializable serializable) {
        return null;
    }

    @Override
    public Serializable update(Comment object) {
        return null;
    }

    @Override
    public Boolean existsById(Serializable serializable) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }
}
