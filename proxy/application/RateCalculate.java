package com.ldc.proxy.application;

import com.ldc.proxy.api.ProxyDemoApi;
import lombok.AllArgsConstructor;

/**
 * 率计算
 *
 * @author charles
 * @date 2022/06/30
 */
@AllArgsConstructor
public class RateCalculate implements ProxyDemoApi {
    private Integer rate;

    @Override
    public void calculate(int x) {
        System.out.println("RateCalculate:[" + x + "]" + "rate=" + rate);
    }
}
