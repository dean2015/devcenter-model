package cn.devcenter.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface BaseRepository<T> {

    T save(T object);

    <E> Page<T> find(E condition, Pageable pageable);

    T findById(Serializable id);

    <E> Boolean exists(E condition);

    Long count();

    Serializable delete(Serializable id);

    Serializable update(T object);

}
