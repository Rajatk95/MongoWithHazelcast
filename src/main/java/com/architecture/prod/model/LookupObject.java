package com.architecture.prod.model;


import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;


@Entity("lookups")
// Compound unique index for faster db operations
@Indexes(@Index(fields = {@Field("code"), @Field("description")}, options = @IndexOptions(unique = true)))
public class LookupObject implements Serializable {

  private static final long serialVersionUID = 4853298355312750847L;
  @Id
  private final String id;
  private final String code;
  private final String value;
  private final String description;
  private final boolean defaultLookup;
  private final int rank;
  private boolean active;
  private final Set<AccessedBy> accessedBy;

  public LookupObject(final String id,
                      final String code,
                      final String value,
                      final String description,
                      final boolean defaultLookup,
                      final int rank,
                      final boolean active,
                      final Set<AccessedBy> accessedBy) {
    this.id = id;
    this.code = code;
    this.value = value;
    this.description = description;
    this.defaultLookup = defaultLookup;
    this.rank = rank;
    this.active = active;
    this.accessedBy = new HashSet<AccessedBy>(accessedBy);
  }

  public LookupObject(final String id,
                      final String code,
                      final String value,
                      final String description,
                      final boolean defaultLookup,
                      final int rank,
                      final boolean active) {
    this(id, code, value, description, defaultLookup, rank, active, new HashSet<AccessedBy>(Arrays.asList(AccessedBy.SYSTEM, AccessedBy.USER)));
  }

  private LookupObject() {
    // for morphia
    this(null, null, null, null, false, 0, false);
  }

  public String getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  public boolean isDefaultLookup() {
    return defaultLookup;
  }

  public int getRank() {
    return rank;
  }

  public boolean isActive() {
    return active;
  }

  public void deactivateLookup() {
    active = false;
  }

  public Set<AccessedBy> getAccessedBy() {
    return new HashSet<>(accessedBy);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LookupObject object = (LookupObject) o;
    return Objects.equals(id, object.id) && Objects.equals(code, object.code)
        && Objects.equals(value, object.value) && Objects.equals(description, object.description) && Objects.equals(
        defaultLookup, object.defaultLookup) && Objects.equals(rank, object.rank) && Objects.equals(active,
        object.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, value, description, defaultLookup, rank, active);
  }
}

