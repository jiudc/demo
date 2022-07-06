package com.ldc.chapter1.application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

}
