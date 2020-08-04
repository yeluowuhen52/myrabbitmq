package com.myrabbitmq.myrabbitmq.dingdingconfig;

import com.myrabbitmq.myrabbitmq.utils.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jiang
 * @Description: 钉钉消息推送(企业信息)
 * @Date: 2020-08-04 16:26
 * @Version: 1.0
 * @Update:
 */
@Getter
@Setter
public class DingDingAppProperties {
  /**
   * 钉钉appKey
   */
  private String appKey;
  /**
   * 钉钉appsecret
   */
  private String appsecret;
  /**
   * 钉钉应用agentid
   */
  private Long agentid;
  /**
   * 钉钉基地址
   */
  private String baseUrl;

  @Override
  public String toString() {
    return JsonUtils.toJson(this);
  }
}
