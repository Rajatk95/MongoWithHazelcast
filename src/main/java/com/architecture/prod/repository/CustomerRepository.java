package com.architecture.prod.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.architecture.prod.model.Customer;
import com.architecture.prod.module.DataStoreProvider;
import com.google.inject.Inject;

/**
 * This class directly interact with the database, Mongo DB is being used here.
 */
public class CustomerRepository {

  private final DataStoreProvider dataStoreProvider;

  @Inject
  public CustomerRepository(final DataStoreProvider dataStoreProvider){
    this.dataStoreProvider = dataStoreProvider;
  }

  public void addOrUpdateCustomer(final Customer customer) {
    dataStoreProvider.get().save(customer);
  }

  public void deleteCustomer (final String id) {
    dataStoreProvider.get().delete(dataStoreProvider.get().createQuery(Customer.class).field("id").equal(id));
  }

  public List<String> findIds() {
    return dataStoreProvider.get().find(Customer.class).asList().stream().map(Customer::getId).collect(Collectors.toList());
  }

  public Customer get(final String id) {
    return dataStoreProvider.get().createQuery(Customer.class).field("id").equal(id).get();
  }
}