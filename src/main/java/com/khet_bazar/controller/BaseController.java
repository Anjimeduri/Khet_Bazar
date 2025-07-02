package com.khet_bazar.controller;

import com.khet_bazar.dto.response.BaseResponse;
import com.khet_bazar.entity.BaseEntity;
import com.khet_bazar.service.BaseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Getter
@RequiredArgsConstructor
public abstract class BaseController<R extends BaseResponse, E extends BaseEntity> {
    // how are we getting this?
    // when user initializes the controller there in the constructor user passes the service
    protected final BaseService<E> service;

    /* This is if user has override any method if user want to send the response from the respective controller */
    protected abstract R createResponse(List<E> entityList);

    @PostMapping
    public R create(@RequestBody E input) {
        E entry = getService().create(input);
        R response = createResponse(Collections.singletonList(entry));
        response.setStatus("Item has been created successfully");
        response.setStatusCode(201);
        return response;
    }

    @PutMapping("/{id}")
    public R update(@RequestBody E input, @PathVariable Long id) {
        E entry = getService().update(id, input);
        R response = createResponse(Collections.singletonList(entry));
        response.setStatus("Item has been updated successfully");
        response.setStatusCode(200);
        return response;
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        E entry = getService().delete(id);
        R response = createResponse(Collections.singletonList(entry));
        response.setStatus("Item has been deleted successfully");
        response.setStatusCode(204);
        return response;
    }

    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        E entry = getService().get(id);
        R response = createResponse(Collections.singletonList(entry));
        response.setStatus("Item has been retrieved successfully");
        response.setStatusCode(200);
        return response;
    }
}
