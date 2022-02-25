Gatling 3 Fundamentals
=========================
* 基本步骤
  * 创建http client，初始化url，请求头部格式等等
    * http.baseUrl
  * 创建测试场景
    * scenario 定义测试场景
    * exec 声明测试的endpoint
      * http
      * get/post/put ....
      * check 检查response结果
        * eg: check(status.is(200)))
    * pause 设置等待时间
  * 执行测试
    * setUp
      * inject 注入
        * atOnceUsers 测试并发量
      * 设置http configuration
        * protocols