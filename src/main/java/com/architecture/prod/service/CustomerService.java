/*
 * This material is the confidential, unpublished property
 * of Fair Isaac Corporation.  Receipt or possession
 * of this material does not convey rights to divulge,
 * reproduce, use, or allow others to use it without
 * the specific written authorization of Fair Isaac
 * Corporation and use must conform strictly to the
 * license agreement.
 *
 * Copyright (c) Fair Isaac Corporation, 2016
 * All Rights Reserved.
 */

package com.architecture.prod.service;

import java.util.List;

import com.architecture.prod.model.Customer;

public interface CustomerService {

  Customer getCustomerById(String id);

  Customer addCustomer(Customer customer);

  Customer updateCustomer(Customer customer);

  void deleteCustomer(String id);

  Customer getCustomerByCode(String code) throws Exception;

  List<Customer> getCustomerByPhoneNumber(int number) throws Exception;

  String getCustomerAddressByCode(String code) throws Exception;

}