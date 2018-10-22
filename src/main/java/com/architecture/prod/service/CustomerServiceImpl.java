package com.architecture.prod.service;

import java.util.List;

import javax.inject.Singleton;

import com.architecture.prod.cache.CustomerCacheOperation;
import com.architecture.prod.model.Customer;
import com.google.inject.Inject;

@Singleton
public class CustomerServiceImpl implements CustomerService {

  private static final String TYPE = "type";

  private final CustomerCacheOperation customerCacheOperation;

  @Inject
  CustomerServiceImpl(final CustomerCacheOperation customerCacheOperation) {
    this.customerCacheOperation = customerCacheOperation;
  }

  @Override
  public Customer getCustomerById(String id) {
    return customerCacheOperation.getCustomerById(id);
  }

  @Override
  public Customer addCustomer(final Customer customer) {
    customerCacheOperation.addCustomerObject(customer);
    return customer;
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    customerCacheOperation.updateCustomer(customer);
    return customer;
  }

  @Override
  public void deleteCustomer(String id) {
    customerCacheOperation.deleteCustomer(id);
  }

  @Override
  public Customer getCustomerByCode(final String code) throws Exception{
    return customerCacheOperation.getCustomerByCode(code);
  }

  @Override
  public List<Customer> getCustomerByPhoneNumber(final int number) {
    return customerCacheOperation.getCustomerByPhoneNumber(number);
  }

  @Override
  public String getCustomerAddressByCode(final String code) throws Exception{
    return customerCacheOperation.getCustomerAddressByCode(code);
  }

}
