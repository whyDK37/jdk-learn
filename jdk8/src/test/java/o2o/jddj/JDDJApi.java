package o2o.jddj;

public enum JDDJApi {

  // https://opendj.jd.com/staticnew/widgets/resources.html?groupid=180&apiid=66abea97d2ee4dd1a8be42b95d40fbae
//  查询类目属性字典信息接口
  getAllSkuCategoryAttr("https://openapi.jddj.com/djapi/pms/getAllSkuCategoryAttr"),
  //    https://opendj.jd.com/staticnew/widgets/resources.html?groupid=180&apiid=964f2d248a7e42b196be2ab35b4e93b4
  //查询商家店内分类信息接口
  queryCategoriesByOrgCode("https://openapi.jddj.com/djapi/pms/queryCategoriesByOrgCode"),
  //    单品直降添加主活动信息接口
  singlePromote_createPromotionInfos(
      "http://openo2o.jd.local/djapi/singlePromote/createPromotionInfos"),
  //    单品直降添加活动规则信息接口
  singlePromote_createPromotionRules(
      "http://openo2o.jd.local/djapi/singlePromote/createPromotionRules"),
  //    单品直降添加活动商品信息接口
  singlePromote_createPromotionSku(
      "http://openo2o.jd.local/djapi/singlePromote/createPromotionSku"),

  //    单品直降活动提交保存接口
  singlePromote_confirmPromotion("http://openo2o.jd.local/djapi/singlePromote/confirmPromotion"),
  //    单品直降活动部分商品取消接口
  singlePromote_cancelPromotionSku(
      "http://openo2o.jd.local/djapi/singlePromote/cancelPromotionSku"),
  //    单品直降整个活动取消接口
  singlePromote_cancelPromotion("http://openo2o.jd.local/djapi/singlePromote/cancelPromotion"),
  //    单品实时促销商品促销数量调整接口
  singlePromote_adjustPromotionSku("http://openo2o.jd.local/djapi/promotesku/adjustPromotionSku"),
  //    单品实时促销活动结束时间调整接口
  singlePromote_adjustPromotionTime("http://openo2o.jd.local/djapi/promotesku/adjustPromotionTime"),

  //    限时抢添加主活动信息接口
  limitTime_createPromotionInfos("http://openo2o.jd.local/djapi/limitTime/createPromotionInfos"),
  //   限时抢添加活动规则信息接口
  limitTime_createPromotionRules("http://openo2o.jd.local/djapi/limitTime/createPromotionRules"),
  //限时抢添加活动商品信息接口
  limitTime_createPromotionSku("http://openo2o.jd.local/djapi/limitTime/createPromotionSku"),

  //    限时抢活动提交保存接口
  limitTime_confirmPromotion("http://openo2o.jd.local/djapi/limitTime/confirmPromotion"),
  //    限时抢活动部分商品取消接口
  limitTime_cancelPromotionSku("http://openo2o.jd.local/djapi/limitTime/cancelPromotionSku"),
  //    限时抢整个活动取消接口
  limitTime_cancelPromotion("http://openo2o.jd.local/djapi/limitTime/cancelPromotion"),
  //    限时抢实时促销商品促销数量调整接口
  limitTime_adjustPromotionSku("http://openo2o.jd.local/djapi/limitTime/adjustPromotionSku"),
  //    限时抢活动结束时间调整接口
  limitTime_adjustPromotionTime("http://openo2o.jd.local/djapi/limitTime/adjustPromotionTime"),

  // 满减
  // 创建活动基本信息接口
  fullCutPromote_createOpenPlatActivityBasicInfo(
      "http://openo2o.jd.local/djapi/fullCutPromote/createOpenPlatActivityBasicInfo"),
  // 满减添加门店接口
  fullCutPromote_addOpenPlatAcitivityStation(
      "http://openo2o.jd.local/djapi/fullCutPromote/addOpenPlatAcitivityStation"),
  // 满减添加活动商品接口
  fullCutPromote_addOpenPlatAcitivitySku(
      "http://openo2o.jd.local/djapi/fullCutPromote/addOpenPlatAcitivitySku"),
  // 满减删除门店接口
  fullCutPromote_deleteOpenPlatStation(
      "http://openo2o.jd.local/djapi/fullCutPromote/deleteOpenPlatStation"),
  // 满减删除商品接口
  fullCutPromote_deleteOpenPlatSku(
      "http://openo2o.jd.local/djapi/fullCutPromote/deleteOpenPlatSku"),
  // 满减生效或取消活动接口
  fullCutPromote_auditPassOrCancelActivity(
      "http://openo2o.jd.local/djapi/fullCutPromote/auditPassOrCancelActivity"),

  ;

  private String url;

  JDDJApi(String name) {
    this.url = name;
  }

  public String getUrl() {
    return url;
  }

}