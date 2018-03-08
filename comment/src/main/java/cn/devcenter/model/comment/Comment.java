package cn.devcenter.model.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment {

    private Serializable id;

    private Serializable commentToUser;

    private Serializable commentToItem;

    private Serializable raisedBy;

    private String content;

    private Date raisedTime;

}
