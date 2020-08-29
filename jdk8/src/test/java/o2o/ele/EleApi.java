package o2o.ele;

public enum EleApi {

  // 获取商品类目列表
  // https://open-retail.ele.me/#/apidoc/me.ele.retail:sku.category.list-3?aopApiCategory=item_all
  sku_category_list("sku.category.list"),
  activity_create("activity.create"),//创建商品营销活动
  activity_update("activity.update"),//更新商品营销活动
  activity_disable("activity.disable"),//下线商品营销活动
  activity_sku_add("activity.sku.add"),//添加活动商品
  activity_sku_update("activity.sku.update"),
  activity_sku_delete("activity.sku.delete"),

  ;

  private String method;

  EleApi(String method) {
    this.method = method;
  }

  public String getMethod() {
    return method;
  }

}