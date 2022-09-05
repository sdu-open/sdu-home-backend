package kz.sdu.sduhome.controller.restApiRequests;

import kz.sdu.sduhome.dto.DTOs;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/default")
public interface RestApiRequests<D extends DTOs> {

    @PostMapping
    D create(@RequestBody D d);

    @GetMapping
    List<D> read();

    @GetMapping("/{id}")
    D read(@PathVariable String id);

    @PutMapping
    void update(@RequestBody D d);

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id);
}
