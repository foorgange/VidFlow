package com.example.server.service;

/** 视频上下文未就绪异常：追问/检索前 VideoContext 缺失时抛出，全局异常处理器转 409。 */
public class VideoContextNotReadyException extends RuntimeException {

    public VideoContextNotReadyException() {
        super("视频内容尚未解析完成，请先完成一次 Video Agent 分析");
    }
}
