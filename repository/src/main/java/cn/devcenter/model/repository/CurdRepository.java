package cn.devcenter.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface CurdRepository<T, ID extends Serializable> extends Repository<T, ID> {

    T save(T object);

    <CONDITION extends T> Page<T> find(CONDITION condition, Pageable pageable);

    T findById(ID id);

    Serializable delete(ID id);

    Serializable update(T object);

    Boolean exists(ID id);

    Long count();

}
