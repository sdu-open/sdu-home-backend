package kz.sdu.sduhome.service.temp;

import kz.sdu.sduhome.dto.DTOs;
import kz.sdu.sduhome.entity.BaseEntity;
import kz.sdu.sduhome.exception.ServerLogicException;

/**
 * @param <E> Entity
 * @param <D> Data Transfer Object
 */
public abstract class BaseSingleEntityService<E extends BaseEntity, D extends DTOs> {

    protected abstract E convertToEntity(D d) throws ServerLogicException;

    protected abstract D convertToDto(E e) throws ServerLogicException;
}
