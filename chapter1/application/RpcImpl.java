package com.ldc.chapter1.application;

import com.ldc.chapter1.api.RpcApi;
import org.springframework.stereotype.Service;

@Service
public class RpcImpl implements RpcApi {
    @Override
    public String sayHi() {
        System.out.println(this.getClass().getCanonicalName() + " say hi!");
        return this.getClass().getCanonicalName();
    }
}
