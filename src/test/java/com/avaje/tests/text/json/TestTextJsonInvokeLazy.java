package com.avaje.tests.text.json;

import java.util.List;

import org.junit.Test;

import com.avaje.ebean.BaseTestCase;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.text.json.JsonContext;
import com.avaje.ebean.text.json.JsonWriteOptions;
import com.avaje.tests.model.basic.Customer;
import com.avaje.tests.model.basic.ResetBasicData;

public class TestTextJsonInvokeLazy extends BaseTestCase {

  @Test
  public void test() {

    ResetBasicData.reset();

    List<Customer> list = Ebean.find(Customer.class).select("name").findList();

    JsonWriteOptions opt = new JsonWriteOptions();
    opt.setRootPathProperties("name, status");

    JsonContext jsonContext = Ebean.createJsonContext();
    String jsonString = jsonContext.toJsonString(list, true, opt);

    System.out.println(jsonString);

  }
}
