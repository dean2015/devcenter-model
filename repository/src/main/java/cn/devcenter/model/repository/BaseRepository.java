package cn.devcenter.model.repository;

import cn.devcenter.model.apitemplate.CurdTemplate;

public interface BaseRepository<T> extends CurdTemplate<T> {

    <E> Boolean exists(E condition);

    Long count();

}
