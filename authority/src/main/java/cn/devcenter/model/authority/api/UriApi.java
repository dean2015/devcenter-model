package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.Uri;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UriApi {

    ExecutionResult<Uri> create(Uri uri);

    ExecutionResult<Uri> findById(String id);

    ExecutionResult<Page<Uri>> findAll(Pageable pageable);
}
