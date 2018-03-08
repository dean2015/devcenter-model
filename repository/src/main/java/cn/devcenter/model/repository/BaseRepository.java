package cn.devcenter.model.repository;

import cn.devcenter.model.template.api.CurdTemplate;

public interface BaseRepository<T> extends CurdTemplate<T> {

    <E> Boolean exists(E condition);

    Long count();

}
