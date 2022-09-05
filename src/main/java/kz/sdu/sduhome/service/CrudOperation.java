package kz.sdu.sduhome.service;

import java.util.List;

public interface CrudOperation<D, ID> {
    D create(D d);

    List<D> read();

    D read(ID id);

    void update(D d);

    void delete(ID id);
}
