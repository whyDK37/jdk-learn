package o2o.mt;

public enum MtApi {

  /**
   * https://developer.meituan.com/home/docDetail/4 poi/getids获取门店ID
   */
  getids("https://waimaiopen.meituan.com/api/v1/poi/getids"),

  /**
   * https://developer.meituan.com/home/docDetail/7 poi/mget批量获取门店详细信息
   */
  mget("https://waimaiopen.meituan.com/api/v1/poi/mget"),
  /**
   * http://developer.waimai.meituan.com/home/docDetail/287 批量创建或更新零售折扣商品
   */
  act_retail_discount_batchsave(
      "https://waimaiopen.meituan.com/api/v1/act/retail/discount/batchsave"),
  /**
   * http://developer.waimai.meituan.com/home/docDetail/289 批量删除零售折扣商品
   */
  act_retail_discount_batchdelete(
      "https://waimaiopen.meituan.com/api/v1/act/retail/discount/batchdelete"),


  // 批量创建指定商品满减活动或创建店内满减活动
  act_full_discount_batchsave("https://waimaiopen.meituan.com/api/v1/act/full/discount/batchsave"),
  // act/full/discount/foods/batchsave 批量添加活动商品至指定商品满减活动
  act_full_discount_foods_batchsave(
      "https://waimaiopen.meituan.com/api/v1/act/full/discount/foods/batchsave"),
  //批量修改指定商品满减活动中商品的当日活动库存
  act_full_discount_foods_daylimit(
      "https://waimaiopen.meituan.com/api/v1/act/full/discount/foods/daylimit"),
  // 批量删除活动商品至指定商品满减活动
  act_full_discount_foods_delete(
      "https://waimaiopen.meituan.com/api/v1/act/full/discount/foods/delete"),
  // act/full/discount/delete 批量删除指定商品满减活动或店内满减活动
  act_full_discount_delete("https://waimaiopen.meituan.com/api/v1/act/full/discount/delete"),


  // 订单配送中
  order_delivering("https://waimaiopen.meituan.com/api/v1/order/delivering"),
  // 订单已送达
  order_arrived("https://waimaiopen.meituan.com/api/v1/order/arrived"),
  // 订单取消
  order_cancel("https://waimaiopen.meituan.com/api/v1/order/cancel"),
  // 接单
  order_confirm("https://waimaiopen.meituan.com/api/v1/order/confirm"),
  ;

  private String url;

  MtApi(String name) {
    this.url = name;
  }

  public String getUrl() {
    return url;
  }

}