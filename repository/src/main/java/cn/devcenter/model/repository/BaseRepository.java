package cn.devcenter.model.repository;

public interface BaseRepository<T> extends CurdTemplate<T> {

    <E> Boolean exists(E condition);

    Long count();

}
