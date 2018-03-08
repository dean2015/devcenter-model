package cn.devcenter.model.eventbus;

import java.io.Serializable;

public interface EventPublisher {

    <T extends Serializable> Object publish(T event);

}
