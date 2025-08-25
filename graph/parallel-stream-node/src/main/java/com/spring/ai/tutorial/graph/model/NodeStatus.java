package com.spring.ai.tutorial.graph.model;

/**
 * @author yingzi
 * @since 2025/8/26
 */

public enum NodeStatus {

    RUNNING("running", "运行中"),

    COMPLETED("completed", "已完成"),

    FAILED("failed", "失败");

    String code;

    String desc;

    NodeStatus(String running, String 运行中) {
        this.code = running;
        this.desc = 运行中;
    }

}
