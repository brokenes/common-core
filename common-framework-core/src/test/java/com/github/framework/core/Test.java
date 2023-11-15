package com.github.framework.core;

public class Test {

    public static void main(String[] args) {
        Result result = Result.fail(ErrorMsgEnum.EX_SYSTEM_ERROR);

        System.out.println(result.getCode() + "---" + result.getMessage());
    }
}
