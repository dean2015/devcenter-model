package cn.devcenter.model.comment.dao;

import cn.devcenter.model.comment.Comment;
import cn.devcenter.model.repository.CurdRepository;

import java.io.Serializable;

public interface CommentDAO extends CurdRepository<Comment, Serializable> {
}
