package com.alpha.heroku.test.bo;

import com.alpha.heroku.test.exception.ValidateException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 返回给前端的公共response,这个对应只能在Controller里面使用，请不要在业务层使用
 *
 * @author tobi
 */
@Data
@AllArgsConstructor
public class ResponseBO<T> {

    private static final Boolean SUCCESS_RESULT = Boolean.TRUE;

    protected Boolean result;
    private T content;
    private String errorCode;
    private String errorMsg;

    /**
     * 只需向前台返回操作成功时使用
     */
    public ResponseBO() {
        this.result = SUCCESS_RESULT;
    }

    /**
     * 操作成功同时返回一些信息
     */
    public ResponseBO(T content) {
        this.result = SUCCESS_RESULT;
        this.content = content;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.result;
    }

    /**
     * 如果errorCode不为空，则抛出异常（通常在app和mgmt中针对service的响应结果验证）
     */
    public void valid() {
        if (!StringUtils.isBlank(this.getErrorCode())) {
            throw new ValidateException(this.getErrorCode());
        }
    }
}
