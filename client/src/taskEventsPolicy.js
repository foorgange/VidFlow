// taskEventsPolicy.js —— SSE 重连策略：判定哪些 HTTP 状态码属于"重试无意义"的终态。
/**
 * 4xx 中除请求超时与限流外都不会自行恢复；网络错误和服务端错误继续退避重连。
 */
export function isTerminalStatus(status) {
  return status >= 400 && status < 500 && status !== 408 && status !== 429
}
